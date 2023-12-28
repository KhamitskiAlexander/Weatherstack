package io.automation.api.cucumber;

import org.apache.commons.collections.map.HashedMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioContextHelper {
    private static final Map<String, Object> SCENARION_CONTEXT = new HashedMap();
    private static final String UPDATED_SCENARIO_PREFIX = ScenarioStorage.currentScenarioName() + "__";

    public static void save(String key, Object object) {
        SCENARION_CONTEXT.put(UPDATED_SCENARIO_PREFIX + key, object);
    }

    public static Object get(String key) {
        return SCENARION_CONTEXT.get(UPDATED_SCENARIO_PREFIX + key);
    }

    public static Map<String, Object> getMapForCurrentScenario() {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> currentScenarioContext : SCENARION_CONTEXT.entrySet()) {
            if (currentScenarioContext.getKey().contains(ScenarioStorage.currentScenarioName())) {
                linkedHashMap.put(currentScenarioContext.getKey(), currentScenarioContext.getValue());
            }
        }

        return linkedHashMap;
    }
}
