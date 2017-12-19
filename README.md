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
  <version>0.8.2</version>
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