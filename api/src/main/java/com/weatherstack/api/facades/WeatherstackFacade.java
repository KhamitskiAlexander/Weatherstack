package com.weatherstack.api.utils;

import com.weatherstack.api.client.helpers.RequestHelper;
import com.weatherstack.api.endpoints.Endpoints;
import com.weatherstack.utils.PropertiesManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.weatherstack.api.client.Api.doGetUntilSucceeded;

public class WeatherstackFacade {

    public static Response getWeatherForecast(String query) {
        PropertiesManager propertiesManager = new PropertiesManager();
        final RequestSpecification requestSpecification = RequestHelper.getDefaultRequestSpecification()
                .queryParams("access_key", propertiesManager.get("access_key"))
                .queryParams("query", query)
                .baseUri(Endpoints.BASE_URL)
                .basePath(Endpoints.CURRENT);
        return doGetUntilSucceeded(requestSpecification);
    }
}
