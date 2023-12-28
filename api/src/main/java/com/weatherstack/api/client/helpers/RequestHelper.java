package io.automation.api.client.helpers;

import io.restassured.specification.RequestSpecification;

import static io.automation.api.client.Api.getRequestSpecification;
import static io.automation.api.constants.HeaderConstants.*;

public class RequestHelper {

    private RequestHelper() {

    }

    public static RequestSpecification getDefaultRequestSpecification(){
        return getRequestSpecification();
    }

    public static RequestSpecification getAdminRequestSpecification() {
        return getRequestSpecification().header(AUTHORIZATION, BEARER + TokenStorage.getNullCheckedSavedToken(NIMDA_ADMIN_TOKEN).getValue());
    }

    public static RequestSpecification getUserRequestSpecification(String userName) {
        return getRequestSpecification().header(AUTHORIZATION, BEARER + TokenStorage.getNullCheckedSavedToken(userName).getValue());
    }
}
