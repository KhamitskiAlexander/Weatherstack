package com.weatherstack.api.client.helpers;

import io.restassured.specification.RequestSpecification;

import static com.weatherstack.api.client.Api.getRequestSpecification;

public class RequestHelper {

    private RequestHelper() {

    }

    public static RequestSpecification getDefaultRequestSpecification(){
        return getRequestSpecification();
    }
}
