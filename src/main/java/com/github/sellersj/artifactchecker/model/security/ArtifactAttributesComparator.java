package com.github.sellersj.artifactchecker.model.security;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.github.sellersj.artifactchecker.model.ArtifactAttributes;

/**
 * So we can have specific sorting. Would not be needed if we do this in the UI.
 *
 * @author sellersj
 */
public class ArtifactAttributesComparator implements Comparator<ArtifactAttributes> {

    @Override
    public int compare(ArtifactAttributes lhs, ArtifactAttributes rhs) {
        CompareToBuilder builder = new CompareToBuilder();

        // reverse the order so it does public before internal
        builder.append(rhs.isPublic(), lhs.isPublic());

        builder.append(lhs.getArtifactId(), rhs.getArtifactId());
        builder.append(lhs.getGroupId(), rhs.getGroupId());
        builder.append(lhs.getVersion(), rhs.getVersion());

        return builder.toComparison();
    }

}
