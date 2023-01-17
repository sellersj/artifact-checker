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
    <Maven-Project-GroupId>${project.groupId}</Maven-Project-GroupId>
    <Maven-Project-ArtifactId>${project.artifactId}</Maven-Project-ArtifactId>
    <Maven-Project-Version>${project.version}</Maven-Project-Version>
  </manifestEntries>
</archive>
```

And configured with the plugin that extracts git info like this:
```
<plugin>
  <groupId>com.github.koraktor</groupId>
  <artifactId>mavanagaiata</artifactId>
  <version>1.0.0</version>
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
The code uses an env var called `WAS_INFO_HOST` where it pulls deployment info. Under the same host name there is also
* applications
* appServers
* dataSources
* deploys
* mailSourceData

## Data used to generate Deployment from other data center
The code uses an env var called `WAS_CIPO_HOST`

