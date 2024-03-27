/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Manifest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.App;
import com.github.sellersj.artifactchecker.model.ArtifactAttributes;
import com.github.sellersj.artifactchecker.model.ArtifactInfoResourceResponseWorkAround;
import com.github.sellersj.artifactchecker.model.MavenGAV;
import com.github.sellersj.artifactchecker.model.ScmCorrection;
import com.github.sellersj.artifactchecker.model.TechOwner;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;

public class InventoryFileUtil {

    /** A logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryFileUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void write(File file, Object objectToWrite) {
        try {
            System.out.println("Writing app inventory to : " + file.getAbsolutePath());
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, objectToWrite);
        } catch (IOException e) {
            throw new RuntimeException("Could not write file: " + file, e);
        }
    }

    public static List<ScmCorrection> readScmCorrection(File file) {
        try {
            List<ScmCorrection> corrections = mapper.readValue(file, new TypeReference<List<ScmCorrection>>() {
            });
            return corrections;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }
    }

    public static List<TechOwner> readTechOwner(File file) {
        try {
            List<TechOwner> techOwners = mapper.readValue(file, new TypeReference<List<TechOwner>>() {
            });
            return techOwners;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }
    }

    public static Set<ArtifactAttributes> readMergedManifests(URL url) {
        try (InputStream in = url.openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            return readMergedManifests(contents);
        } catch (Exception e) {
            throw new RuntimeException("Could not download file from " + url, e);
        }

    }

    public static Set<MavenGAV> readMergedPomFiles(URL url) {
        try (InputStream in = url.openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            Set<MavenGAV> gavs = new HashSet<>();

            // read the merged pom files and extract the GAV info
            String[] lines = contents.split("\\r?\\n");
            MavenGAV gav = new MavenGAV();
            for (String line : lines) {
                if (line.startsWith("#")) {
                    continue;
                }

                if (line.startsWith("groupId=")) {
                    gav.setGroupId(StringUtils.substringAfter(line, "groupId="));
                } else if (line.startsWith("artifactId=")) {
                    gav.setArtifactId(StringUtils.substringAfter(line, "artifactId="));
                } else if (line.startsWith("version=")) {
                    gav.setVersion(StringUtils.substringAfter(line, "version="));
                }

                // add it to the set and get ready for the next loop
                if (gav.isFilledOut()) {
                    gavs.add(gav);
                    gav = new MavenGAV();
                }

                System.out.println(line);
            }
            return gavs;

        } catch (Exception e) {
            throw new RuntimeException("Could not download file from " + url, e);
        }
    }

    /**
     * This is from the KED data center.
     *
     * @param url to read the file from
     * @return
     */
    public static Set<ArtifactAttributes> readMergedApplicationListing(URL url) {

        Map<String, ArtifactAttributes> appMap = new HashMap<>();

        // TODO we need to keep track of the different nodes the app is deployed on to eliminate duplicates

        try (InputStream in = url.openStream()) {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);

            String[] lines = contents.split("\n");
            for (String line : lines) {

                if (StringUtils.isNotBlank(line) && !line.trim().startsWith("#") && line.trim().endsWith(".ear")) {
                    // these should only be the ear listing

                    // TODO wrap in try / catch to isolate errors?
                    String[] chunks = line.trim().split("\\s+");
                    if (3 != chunks.length) {
                        LOGGER.warn(
                            "We can't parse the line: " + line + " because we have " + chunks.length + " parts to it");
                    }
                    // ear name
                    String earArtifactName = chunks[2];
                    ArtifactAttributes attributes = null;
                    if (appMap.containsKey(earArtifactName)) {
                        attributes = appMap.get(earArtifactName);

                    } else {
                        attributes = new ArtifactAttributes();
                        appMap.put(earArtifactName, attributes);

                        // the deploy date
                        // convert the string to a date to convert to a date.
                        // TODO fix this since it's too silly for words
                        LocalDate date = LocalDate.parse(chunks[1]);

                        // ear name
                        String artifactId = StringUtils.substringBeforeLast(earArtifactName, "-");
                        attributes.getManifest().put(ArtifactAttributes.ARTIFACT_ID, artifactId);

                        // set the title to the ear name until we have something better
                        attributes.getManifest().put(ArtifactAttributes.IMPLEMENTATION_TITLE, artifactId);

                        String version = StringUtils
                            .substringBeforeLast(StringUtils.substringAfterLast(earArtifactName, "-"), ".");
                        attributes.getManifest().put(ArtifactAttributes.VERSION, version);

                        // set the deployment info here
                        App deploymentInfo = new App();
                        deploymentInfo.setDataCenter(App.DATA_CENTER_KED);
                        deploymentInfo.setDeploymentDate(DateUtils.asDate(date));
                        attributes.setDeploymentInfo(deploymentInfo);
                    }

                    // server node
                    String serverNode = chunks[0];
                    Map<String, List<String>> deployAtt = attributes.getDeploymentInfo().getAttributes();
                    if (!deployAtt.containsKey("NODE")) {
                        deployAtt.put("NODE", new ArrayList<String>());
                    }
                    deployAtt.get("NODE").add(serverNode);

                    appMap.put(earArtifactName, attributes);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not download file from " + url, e);
        }

        HashSet<ArtifactAttributes> apps = new HashSet<ArtifactAttributes>(appMap.values());
        // fix any manifests we can find
        fillInMissingScmInfo(apps);
        fillInTechOwner(apps);
        fillInBuildTimestamp(apps);

        return apps;

    }

    private static void fillInBuildTimestamp(HashSet<ArtifactAttributes> apps) {
        String toolsHost = Constants.getSysOrEnvVariable(Constants.TOOLS_HOST);
        if (StringUtils.isBlank(toolsHost)) {
            throw new RuntimeException("The 'TOOLS_HOST' env variable has to be set");
        }

        // TODO figure out how we should solve it if the data is in a different repo. Probably have to query it first
        String repo = "all-released";
        String urlStart = "https://" + toolsHost + "/maven-proxy/service/local/repositories/" + repo + "/content/";
        Client client = Client.create();

        for (ArtifactAttributes artifact : apps) {

            if (StringUtils.isAnyBlank(artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion())) {
                LOGGER.info(String.format("Do not have enough info to query nexus for %s", artifact));
            } else if (null == artifact.getBuildDate()) {
                LOGGER.info(String.format("Build date not set for %s:%s:%s. Querying nexus to find it",
                    artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion()));

                String groupIdPath = String.join("/", artifact.getGroupId().split("\\."));
                String url = urlStart + groupIdPath + "/" + artifact.getArtifactId() + "/" + artifact.getVersion() + "/"
                    + artifact.getArtifactId() + "-" + artifact.getVersion() + ".ear";

                ArtifactInfoResourceResponseWorkAround response = null;
                try {

                    // a way that sort of works
                    response = client.resource(url) //
                        .queryParam("describe", "info") //
                        .get(ArtifactInfoResourceResponseWorkAround.class);

                    LocalDateTime buildDate = DateUtils.asLocalDateTime(response.getData().getLastChanged());
                    artifact.getManifest().put(ArtifactAttributes.BUILD_TIME,
                        ArtifactAttributes.MAVEN_DATE_FORMAT.format(buildDate));

                } catch (ClientHandlerException e) {
                    // re-throw with more info
                    throw new IllegalArgumentException(
                        "Couldn't find artifact by groupId using url: " + url + " for groupId: " + artifact, e);
                }
            }
        }
        // cleanup
        client.destroy();
    }

    /**
     * This will read a file of merged pom.properties from maven artifacts.
     *
     * It will return a list of partially filled apps, containing on their GAV info.
     *
     * @param file to read
     * @return a filled out list.
     */
    public static Set<ArtifactAttributes> readMergedManifests(File file) {
        try {
            String contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return readMergedManifests(contents);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }

    }

    /**
     * This will read a file of merged pom.properties from maven artifacts.
     *
     * It will return a list of partially filled apps, containing on their GAV info.
     *
     * @param contents to read
     * @return a filled out list.
     */
    public static Set<ArtifactAttributes> readMergedManifests(String contents) {

        Set<ArtifactAttributes> apps = new HashSet<>();

        // split the file on a the manifest header, while keeping the header
        String[] chunks = contents.split("(?=Manifest-Version)");

        for (String string : chunks) {

            // read the chunk into a manifest object so it can deal with the manifest quirks
            Manifest manifest = readToManifest(string);

            if (doesManifestHaveValues(manifest)) {
                // get the object to load
                ArtifactAttributes attributes = new ArtifactAttributes();

                for (Entry<Object, Object> entry : manifest.getMainAttributes().entrySet()) {
                    attributes.getManifest().put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }

                apps.add(attributes);
            }
        }

        // fix any manifests we can find
        fillInMissingScmInfo(apps);

        fillInTechOwner(apps);

        return apps;
    }

    /**
     * @param manifest to check
     * @return true if any of the main values have values
     */
    public static boolean doesManifestHaveValues(Manifest manifest) {
        // skip creating an artifact is there none of the manifest entries contain a value
        boolean hasValues = false;

        for (Entry<Object, Object> entry : manifest.getMainAttributes().entrySet()) {
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());

            if (!"Manifest-Version".equals(key) && //
                StringUtils.isNotBlank(value)) {
                hasValues = true;
                break;
            }
        }

        if (!hasValues) {
            System.out.println("Ignoring an empty manifest");
        }

        return hasValues;
    }

    /** Fills in scm info that's missing for a best guess. */
    public static void fillInMissingScmInfo(Set<ArtifactAttributes> apps) {

        List<ScmCorrection> corrections = getCorrections();
        // make a map, keyed on if their is an
        Map<String, ScmCorrection> mapOfCorrections = new HashMap<>();
        for (ScmCorrection scmCorrection : corrections) {
            if (StringUtils.isNotBlank(scmCorrection.getImplementationTitle())) {
                mapOfCorrections.put(scmCorrection.getImplementationTitle(), scmCorrection);
            }
        }

        Collection<String> unneededCorrections = getUnneededCorrections(apps, mapOfCorrections);
        if (!unneededCorrections.isEmpty()) {
            System.err.println("******************************");
            System.err.println("Unneeded corrections in scm-corrections.json include:");
            for (String string : unneededCorrections) {
                System.err.println(string);
            }
            System.err.println("******************************");
        }

        for (ArtifactAttributes app : apps) {
            if (mapOfCorrections.containsKey(app.getTitle())) {
                ScmCorrection correction = mapOfCorrections.get(app.getTitle());

                // correct the git info
                if (!app.hasRequiredGitInfo()) {
                    System.out.println("Correcting repo and name for " + app.getTitle() + " to "
                        + correction.getScmProject() + " and " + correction.getScmRepo());

                    app.setCorrectedScmProject(correction.getScmProject());
                    app.setCorrectedScmRepo(correction.getScmRepo());
                }

                // TODO consider checking this separately with a double check of the version number
                // correct the artifactId if we can
                if (StringUtils.isBlank(app.getArtifactId())) {
                    System.out.println(
                        "Adding corrected artifactId for " + app.getTitle() + " to " + correction.getArtifactId());
                    app.setCorrectedArtifactId(correction.getArtifactId());
                }
                if (StringUtils.isBlank(app.getGroupId())) {
                    System.out
                        .println("Adding corrected groupId for " + app.getTitle() + " to " + correction.getGroupId());
                    app.setCorrectedGroupId(correction.getGroupId());
                }

                if (StringUtils.isNotBlank(correction.getJiraKey())) {
                    System.out
                        .println("Adding corrected jira key for " + app.getTitle() + " to " + correction.getJiraKey());
                    app.setCorrectedJiraKey(correction.getJiraKey());
                }
            }
        }
    }

    /** Fills in tech owner. */
    public static void fillInTechOwner(Set<ArtifactAttributes> apps) {

        Map<String, TechOwner> mapOfTechOwners = getTechOwners();

        List<String> cipoScmProjects = Arrays.asList("CWP", "CIPO", "CIPITM");

        for (ArtifactAttributes app : apps) {
            if (mapOfTechOwners.containsKey(app.getJiraKey())) {
                TechOwner owner = mapOfTechOwners.get(app.getJiraKey());

                if (StringUtils.isNotBlank(owner.getJiraKey())) {
                    System.out.println("Updating TechOwner for " + app.getJiraKey() + " to " + owner.getTechOwner());
                    app.setTechOwner(owner.getTechOwner());
                }
            } else if (cipoScmProjects.contains(app.getScmProject()) //
                || StringUtils.isBlank(app.getScmProject())) {
                app.setTechOwner("CIPO");
            }
        }
    }

    /**
     * If the app is to be decomissioned.
     *
     * @param apps to check
     */
    public static void fillInDecomissionedInfo(Set<ArtifactAttributes> apps) {
        List<String> jiraKeys = getJiraKeysToBeDecomissioned();

        for (ArtifactAttributes app : apps) {
            if (jiraKeys.contains(app.getJiraKey())) {
                app.setToDecomission(true);
            }
        }
    }

    /**
     *
     * @param apps from the scraped sources
     * @param mapOfCorrections the corrections
     * @return all names that are in the corrected list but not in the apps
     */
    public static Collection<String> getUnneededCorrections(Set<ArtifactAttributes> apps,
                                                            Map<String, ScmCorrection> mapOfCorrections) {

        // get all the titles
        HashSet<String> titles = new HashSet<>();
        for (ArtifactAttributes artifactAttributes : apps) {
            titles.add(artifactAttributes.getTitle());
        }

        // get all the corrections
        TreeSet<String> unneeded = new TreeSet<>();
        unneeded.addAll(mapOfCorrections.keySet());
        // remove all the titles that we we care about
        unneeded.removeAll(titles);

        // we should be left with all the values that are in the corrections file but no longer in
        // prod
        return unneeded;
    }

    private static List<ScmCorrection> getCorrections() {
        File file = getFileOnClasspath("/scm-corrections.json");
        List<ScmCorrection> correction = readScmCorrection(file);

        return correction;
    }

    private static Map<String, TechOwner> getTechOwners() {
        File file = getFileOnClasspath("/tech-owner.json");
        List<TechOwner> techOwner = readTechOwner(file);
        Map<String, TechOwner> mapOfTechOwners = new HashMap<>();
        for (TechOwner owner : techOwner) {
            mapOfTechOwners.put(owner.getJiraKey(), owner);
        }

        return mapOfTechOwners;
    }

    public static List<String> getJiraKeysToBeDecomissioned() {
        File file = getFileOnClasspath("/to-be-decomissioned.json");

        try {
            List<String> jiraKeys = mapper.readValue(file, new TypeReference<List<String>>() {
            });
            return jiraKeys;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read file: " + file, e);
        }
    }

    private static Manifest readToManifest(String string) {
        try {
            Manifest manifest = new Manifest(IOUtils.toInputStream(string, StandardCharsets.UTF_8));
            return manifest;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read manifest chunk: " + string, e);
        }
    }

    /**
     * @param filename should start with leading slash
     * @return the file handle
     */
    public static File getFileOnClasspath(String filename) {
        try {
            URL url = InventoryFileUtil.class.getResource(filename);
            return new File(url.toURI());
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load the file " + filename, e);
        }
    }

}
