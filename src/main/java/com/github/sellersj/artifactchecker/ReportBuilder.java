/**
 *
 */
package com.github.sellersj.artifactchecker;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.github.sellersj.artifactchecker.model.AppInventory;

public class ReportBuilder {

    public static void buildJsonReport(String location, String targetLocation) {
        URL url;
        try {
            url = new URL(location);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Couldn't make a url from " + location, e);
        }

        AppInventory gavs = InventoryFileUtil.readMergedManifests(url);

        System.out.println("The number of apps is at least " + gavs.getApps().size());

        File outFile = new File(targetLocation);
        InventoryFileUtil.write(outFile, gavs);
    }

}
