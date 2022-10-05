/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author sellersj
 */
public class CheckForAuthUse {

    /** A logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckForAuthUse.class);

    /**
     * This will look through for templating attributes in jsp's.
     *
     * @param startingDir where the project is checked out
     * @return the CMA roles as defined in the web.xml
     */
    public Set<String> getContainerManagedAuthenticationRoles(File startingDir) {
        TreeSet<String> roleNames = new TreeSet<>();

        List<File> webFiles = getWebDotXmlFiles(startingDir);

        if (webFiles.isEmpty()) {
            LOGGER.warn("Could not find any web.xml files for " + startingDir);
        }

        for (File file : webFiles) {
            roleNames.addAll(getSecurityRoleNames(file));
        }

        return roleNames;
    }

    /**
     * This will search for web.xml files that are in the standard maven layout structure.
     *
     * @param dir starting directory
     * @return
     */
    public List<File> getWebDotXmlFiles(File dir) {

        List<File> files = (List<File>) FileUtils.listFiles(dir, //
            // only visit these files
            FileFilterUtils.and(
                // only look in the webapp directory
                new NamePathFileFilter(
                    "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"), //

                // only looking at this one file
                FileFilterUtils.nameFileFilter("web.xml")),

            // ignore these directories
            FileFilterUtils.notFileFilter(FileFilterUtils.or( //
                FileFilterUtils.nameFileFilter("target"), //
                FileFilterUtils.nameFileFilter(".git"), //
                FileFilterUtils.nameFileFilter(".settings"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "java"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "application"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "resources"), //
                new NamePathFileFilter("src" + File.separator + "test"))));

        return files;
    }

    public Set<String> getSecurityRoleNames(File file) {
        TreeSet<String> roleNames = new TreeSet<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element rootElement = document.getDocumentElement();

            NodeList list = rootElement.getElementsByTagName("role-name");
            if (list != null && list.getLength() > 0) {
                for (int i = 0; i < list.getLength(); i++) {
                    NodeList subList = list.item(i).getChildNodes();

                    if (subList != null && subList.getLength() > 0) {
                        roleNames.add(subList.item(0).getNodeValue());
                    }
                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            LOGGER.error("Could not parse web.xml to look for CMA, file " + file, e);
        }

        if (!roleNames.isEmpty()) {
            LOGGER.info(String.format("Found %s roles in %s", roleNames.size(), file.getAbsolutePath()));
        }

        return roleNames;
    }

    /**
     * @param dir starting directory
     * @return
     */
    public Set<String> getLoginPageLines(File dir) {

        List<File> files = (List<File>) FileUtils.listFiles(dir, //
            // only visit these files
            FileFilterUtils.and(
                // only look in main directories
                new NamePathFileFilter("src" + File.separator + "main"), //

                FileFilterUtils.or( //
                    FileFilterUtils.suffixFileFilter("jsp"), //
                    FileFilterUtils.suffixFileFilter("jspf"), //
                    FileFilterUtils.suffixFileFilter("html") //
                )),

            // ignore these directories
            FileFilterUtils.notFileFilter(FileFilterUtils.or( //
                FileFilterUtils.nameFileFilter("target"), //
                FileFilterUtils.nameFileFilter(".git"), //
                FileFilterUtils.nameFileFilter(".settings"), //
                new NamePathFileFilter("src" + File.separator + "main" + File.separator + "application"), //
                new NamePathFileFilter("src" + File.separator + "test"))));

        TreeSet<String> matchingLines = new TreeSet<>();

        for (File file : files) {
            try {
                List<String> lines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);
                int lineNumber = 1;
                for (String line : lines) {
                    if (line.contains("/login") //
                        || line.contains("j_security_check") //
                        || line.contains("j_spring_security_check")) {

                        // TODO we need the path, minus the starting directory
                        String absPath = file.getAbsolutePath();
                        String relPath = absPath.replace(dir.getAbsolutePath(), "");

                        String result = relPath + "#" + lineNumber;

                        LOGGER.info("Found login page on " + result + " for with content");

                        // the matching file with the line number
                        matchingLines.add(result);
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                throw new RuntimeException("Could not read file " + file, e);
            }
        }

        return matchingLines;
    }

}
