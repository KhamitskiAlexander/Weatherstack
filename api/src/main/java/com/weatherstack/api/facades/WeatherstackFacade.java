package com.weatherstack.api.facades;

import com.weatherstack.api.client.helpers.RequestHelper;
import com.weatherstack.api.endpoints.Endpoints;
import com.weatherstack.utils.PropertiesManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.weatherstack.api.client.Api.doGetUntilSucceeded;

public class WeatherstackFacade {

    public static Response getWeatherForecast(final String endpoint, final String accessKey, final String query) {
        PropertiesManager propertiesManager = new PropertiesManager();
        final String access_key = accessKey.equals("valid") ? propertiesManager.get("access_key") : propertiesManager.get("invalid_access_key");
        final RequestSpecification requestSpecification = RequestHelper.getDefaultRequestSpecification()
                .queryParams("access_key", access_key)
                .queryParams("query", query)
                .baseUri(Endpoints.BASE_URL)
                .basePath(endpoint);
        return doGetUntilSucceeded(requestSpecification);
    }
}
