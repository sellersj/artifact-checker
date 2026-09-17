package com.github.sellersj.artifactchecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import com.github.sellersj.artifactchecker.model.inventory.AllEnvsDatasource;
import com.github.sellersj.artifactchecker.model.inventory.AllEnvsInventory;
import com.github.sellersj.artifactchecker.model.inventory.AllEnvsMailsource;

public class WasInventoryTest {

    @Test
    @EnabledIfEnvironmentVariable(named = Constants.TOOLS_HOST, matches = ".+")
    void readProdInventory() {
        List<AllEnvsInventory> prodInventory = WasInventory.readProdInventory();
        assertNotNull(prodInventory);
        assertFalse(prodInventory.isEmpty());

        for (AllEnvsInventory allEnvsInventory : prodInventory) {
            assertTrue(allEnvsInventory.getProd(),
                "should only be prod but found for : " + allEnvsInventory.getConsoleHost());

            assertTrue(allEnvsInventory.getNotWebsphereInternalApp(),
                "should not be WAS internal app but found for : " + allEnvsInventory.getName());
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = Constants.TOOLS_HOST, matches = ".+")
    void readProdDatasource() {
        List<AllEnvsDatasource> prodInventory = WasInventory.readProdDatasource();
        assertNotNull(prodInventory);
        assertFalse(prodInventory.isEmpty());

        for (AllEnvsDatasource allEnvsInventory : prodInventory) {
            assertTrue(allEnvsInventory.getProd(),
                "should only be prod but found for : " + allEnvsInventory.getConsoleHost());
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = Constants.TOOLS_HOST, matches = ".+")
    void readProdMailSource() {
        List<AllEnvsMailsource> prodInventory = WasInventory.readProdMailSource();
        assertNotNull(prodInventory);
        assertFalse(prodInventory.isEmpty());

        for (AllEnvsMailsource allEnvsInventory : prodInventory) {
            assertTrue(allEnvsInventory.getProd(),
                "should only be prod but found for : " + allEnvsInventory.getConsoleHost());
        }
    }
}
