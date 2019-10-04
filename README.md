# Thing for checking artifacts

We are going to build a dependency tree as well as make arifacts available so we can use owasp dependency check

This is for extracting info out of where the jar, war, ear plugins are defined like 
```
<archive>
  <manifest>
    <addDefaultImplementationEntries>true</addDefaultImplementationEntries>
  </manifest>
  <manifestEntries>
    <Build-Time>${maven.build.timestamp}</Build-Time>
    <Implementation-Artifact-Id>${project.artifactId}</Implementation-Artifact-Id>
    <Issue-System>${project.issueManagement.system}</Issue-System>
    <Issue-Tracking>${project.issueManagement.url}</Issue-Tracking>
    <Scm-Sha1>${mavanagaiata.commit.sha}</Scm-Sha1>
    <Scm-Sha1-Abbrev>${mavanagaiata.commit.abbrev}</Scm-Sha1-Abbrev>
    <Scm-branch>${mavanagaiata.branch}</Scm-branch>
    <Scm-Commit-Date>${mavanagaiata.commit.committer.date}</Scm-Commit-Date>
    <Scm-Project-Id>${git.project.id}</Scm-Project-Id>
    <Scm-Repo-Name>${git.repo.name}</Scm-Repo-Name>
  </manifestEntries>
</archive>
```

And configured with the plugin that extracts git info like this:
```
<plugin>
  <groupId>com.github.koraktor</groupId>
  <artifactId>mavanagaiata</artifactId>
  <version>0.9.0</version>
  <executions>
    <execution>
      <id>load-git-branch</id>
      <goals>
        <goal>commit</goal>
        <goal>branch</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <dateFormat>yyyy-MM-dd hh:mm a Z</dateFormat>
    <skipNoGit>true</skipNoGit>
  </configuration>
</plugin>
```

## Running tests pointing to TOOLS_HOST
For some tests or code to work, it assumes that a TOOLS_HOST env variable is set.
1) To override this in a junit test in eclipse, open the "Run Configurations" 
2) Click on the "Environment" tab
3) Click "New", enter in the name "TOOLS_HOST" and the value
4) Repeat for PROD_LOG_HOST and CORRECTED_JIRA_HOST. See `com.github.sellersj.artifactchecker.Constants`

## Checking for updates of plugins and dependencies
Run the maven command `versions:display-dependency-updates versions:display-plugin-updates versions:display-property-updates`

## Data Used to generate the "Deployment" columns
The code uses an env var called `APPLICATIONS_URL` where it pulls deployment info. Under the same host name there is also
* applications
* appServers
* dataSources
* deploys
* mailSourceData

## TODO not yet working Manual steps to regenerate the schema
Currently there are some manual steps for generating the model
Download the schema
https://github.com/jeremylong/DependencyCheck/tree/master/core/src/main/resources/schema
Pull the convertion tool
`mvn dependency:copy -Dartifact=org.hisrc.jsonix:jsonix-schema-compiler-full:2.3.9 -DoutputDirectory=. -Dmdep.stripVersion=true`
Generate the jsonFiles like this
`java -jar jsonix-schema-compiler-full.jar -generateJsonSchema dependency-check.2.1.xsd`
Copy the schema into the project

## Current horrible process for generating java model files
Copy a generated json file `src/main/resources/schema`
Uncomment the jsonschema2pojo plugin in pom.xml
Copy and paste the model classes in

