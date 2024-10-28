package com.github.sellersj.artifactchecker.model;

import org.sonatype.nexus.rest.model.ArtifactInfoResourceResponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * This is a work around since the original class sets the top level names which do not show up in the response that I
 * see from the server.
 *
 * We are using the class name instead of "artifact-info"
 */
@SuppressWarnings("all")
@XmlRootElement(name = "org.sonatype.nexus.rest.model.ArtifactInfoResourceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArtifactInfoResourceResponseWorkAround extends ArtifactInfoResourceResponse {

}
