package com.weatherstack.hooks;

import com.weatherstack.api.cucumber.ScenarioStorage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @Before(order = 0)
    public void setScenarioNameToStorage(final Scenario scenario) {
        final String scenarioName = scenario.getName();
        ScenarioStorage.setCurrentScenarioName(scenarioName);
        LOGGER.info("Set scenario name to Scenario Storage: '{}'", scenarioName);
    }
}
