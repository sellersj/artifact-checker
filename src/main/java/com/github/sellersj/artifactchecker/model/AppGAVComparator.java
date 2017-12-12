package com.github.sellersj.artifactchecker.model;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class AppGAVComparator implements Comparator<App> {

    @Override
    public int compare(App o1, App o2) {
        CompareToBuilder builder = new CompareToBuilder();

        builder.append(o1.getGroupId(), o2.getGroupId());
        builder.append(o1.getArtifactId(), o2.getArtifactId());
        builder.append(o1.getVersion(), o2.getVersion());
        builder.append(o1.getPackaging(), o2.getPackaging());

        return builder.toComparison();
    }

}
