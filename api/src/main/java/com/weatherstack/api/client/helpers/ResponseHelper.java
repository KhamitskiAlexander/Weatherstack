package io.automation.api.client.helpers;

import io.restassured.response.Response;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class ResponseHelper {
    private static final Map<String, Response> responseHolder = new HashedMap();

    public static void saveResponse(String scenarioName, Response response) {
        responseHolder.put(scenarioName, response);
    }

    public static Response getSavedResponse(String scenarioName) throws Exception {
        Response response = responseHolder.get(scenarioName);
        if (response != null) {
            return response;
        }
        throw new Exception(String.format("The key '%s' hasn't been found in the Scenarios Map.", scenarioName));
    }
}
