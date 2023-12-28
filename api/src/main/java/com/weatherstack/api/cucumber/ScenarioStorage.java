package com.weatherstack.api.cucumber;

import java.util.List;

public class ScenarioStorage {

    private static String currentScenarioName;
    private static List<String> currentScenarioTags;

    private ScenarioStorage() {

    }

    public static String currentScenarioName() {
        return currentScenarioName;
    }

    public static void setCurrentScenarioName(String scenarioName) {
        currentScenarioName = scenarioName;
    }

    public static List<String> currentScenarioTags() {
        return currentScenarioTags;
    }

    public static void setCurrentScenarioTags(List<String> scenarioTags) {
        currentScenarioTags = scenarioTags;
    }
}
