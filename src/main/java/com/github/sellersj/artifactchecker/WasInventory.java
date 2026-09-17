package com.github.sellersj.artifactchecker;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sellersj.artifactchecker.model.inventory.AllEnvsDatasource;
import com.github.sellersj.artifactchecker.model.inventory.AllEnvsInventory;
import com.github.sellersj.artifactchecker.model.inventory.AllEnvsMailsource;

/**
 * This is for reading inventory files external to this app.
 */
public class WasInventory {

    private static final String INVENTORY_PATH = "/projectsites/websphere-inventory/";

    private static ObjectMapper MAPPER = new ObjectMapper();

    /**
     * @return only our apps that are in prod
     */
    public static List<AllEnvsInventory> readProdInventory() {
        String target = getInventoryUrl("all-envs-inventory.json");

        try (InputStream input = URI.create(target).toURL().openStream();) {
            List<AllEnvsInventory> result = MAPPER.readValue(input, new TypeReference<List<AllEnvsInventory>>() {
            });
            return result.stream().filter(i -> i.getProd() && i.getNotWebsphereInternalApp()).toList();
        } catch (Exception e) {
            throw new RuntimeException("Could not parse from url " + target, e);
        }
    }

    /**
     * @return only our datasources that are in prod
     */
    public static List<AllEnvsDatasource> readProdDatasource() {
        String target = getInventoryUrl("all-envs-datasources.json");

        try (InputStream input = URI.create(target).toURL().openStream();) {
            List<AllEnvsDatasource> result = MAPPER.readValue(input, new TypeReference<List<AllEnvsDatasource>>() {
            });
            return result.stream().filter(i -> i.getProd()).toList();
        } catch (Exception e) {
            throw new RuntimeException("Could not parse from url " + target, e);
        }
    }

    /**
     * @return only our datasources that are in prod
     */
    public static List<AllEnvsMailsource> readProdMailSource() {
        String target = getInventoryUrl("all-envs-mailsources.json");

        try (InputStream input = URI.create(target).toURL().openStream();) {
            List<AllEnvsMailsource> result = MAPPER.readValue(input, new TypeReference<List<AllEnvsMailsource>>() {
            });
            return result.stream().filter(i -> i.getProd()).toList();
        } catch (Exception e) {
            throw new RuntimeException("Could not parse from url " + target, e);
        }
    }

    /**
     * @param filename to get from the inventoy
     * @return the whole url
     */
    private static String getInventoryUrl(String filename) {
        return "https://" + Constants.getSysOrEnvVariable(Constants.TOOLS_HOST) + INVENTORY_PATH + filename;
    }

}
