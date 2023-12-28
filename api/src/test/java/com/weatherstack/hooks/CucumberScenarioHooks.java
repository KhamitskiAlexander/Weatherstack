package com.weatherstack.hooks;

import java.util.ArrayList;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AssumptionViolatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CucumberScenarioHooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberScenarioHooks.class);

    @Before(order = 0)
    public void before(final Scenario scenario) {
        final ArrayList<String> scenarioTags = new ArrayList<>(scenario.getSourceTagNames());

        if (checkForSkipScenario(scenarioTags)) {
            LOGGER.warn("This scenario: '{}' marked as @skipped", scenario.getName());
            throw new AssumptionViolatedException(String.format("This scenario: '%s' has been marked as @skipped", scenario.getName()));
        } else {
            LOGGER.info("This scenario: '{}' hasn't been marked as @skipped", scenario.getName());
        }
    }

    private boolean checkForSkipScenario(final ArrayList<String> scenarioTags) {
        return scenarioTags.stream()
                .anyMatch(tag -> tag.contains("skipped"));
    }
}
