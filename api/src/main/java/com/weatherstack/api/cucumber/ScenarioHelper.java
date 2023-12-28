package com.weatherstack.api.cucumber;

import java.util.List;

public class ScenarioHelper {

    private static final String ADMIN_USER_ID = "superAdminUserCredentials";

    private ScenarioHelper() {

    }

    public static String getUserID(final List<String> scenarioTags) {
        final String userID = scenarioTags.stream()
                .filter(scenario -> scenario.contains("api:auth"))
                .findFirst().orElse(ADMIN_USER_ID);
        if (userID.equals(ADMIN_USER_ID)) {
            return ADMIN_USER_ID;
        }
        final int from = 1 + userID.lastIndexOf(":");
        return userID.substring(from);
    }

    public static boolean doScenarioTagsContain(String tag) {
        return ScenarioStorage.currentScenarioTags().stream()
                .anyMatch(item -> item.contains(tag));
    }

    public static boolean isProd() {
        return doScenarioTagsContain("host:prod");
    }

    public static boolean isInt() {
        return doScenarioTagsContain("host:int");
    }
}
