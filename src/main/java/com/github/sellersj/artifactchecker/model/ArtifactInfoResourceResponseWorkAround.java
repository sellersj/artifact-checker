package com.github.sellersj.artifactchecker.model;

import org.sonatype.nexus.rest.model.ArtifactInfoResourceResponse;

/**
 *
 * This is a work around since the original class sets the top level names which do not show up in the response that I
 * see from the server.
 *
 * We are using the class name instead of "artifact-info"
 */
@SuppressWarnings("all")
@javax.xml.bind.annotation.XmlRootElement(name = "org.sonatype.nexus.rest.model.ArtifactInfoResourceResponse")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class ArtifactInfoResourceResponseWorkAround extends ArtifactInfoResourceResponse {

}
