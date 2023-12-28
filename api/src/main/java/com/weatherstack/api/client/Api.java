package io.automation.api.client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static io.restassured.RestAssured.given;
import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;

public class Api {

    private Api() {

    }

    public static Response doGet(RequestSpecification request) {
        return doRequest(request, Method.GET);
    }

    public static Response doPut(RequestSpecification request) {
        return doRequest(request, Method.PUT);
    }

    public static Response doGetUntilSucceeded(RequestSpecification request) {
        return doRequestUntilSucceeded(request, Method.GET);
    }

    public static Response doPutUntilSucceeded(RequestSpecification request) {
        return doRequestUntilSucceeded(request, Method.PUT);
    }

    public static Response doPost(RequestSpecification request) {
        return doRequest(request, Method.POST);
    }

    public static Response doPostUntilSucceeded(RequestSpecification request) {
        return doRequestUntilSucceeded(request, Method.POST);
    }

    public static Response doDeleteUntilSucceeded(RequestSpecification request) {
        return doRequestUntilSucceeded(request, Method.DELETE);
    }

    public static Response doGetUntilSucceededForBigResponses(RequestSpecification spec) {
        return doRequestUntilSucceeded(spec, Method.GET, ofSeconds(110), ofSeconds(10));
    }

    private static Response doRequestUntilSucceeded(RequestSpecification request,
                                                    Method requestMethod,
                                                    Duration timeout,
                                                    Duration pollInterval) {
        AtomicReference<Response> responseAtomic = new AtomicReference<>();
        await().with()
                .timeout(timeout)
                .pollInterval(pollInterval)
                .untilAsserted(
                        () -> responseAtomic.set(doRequestWithAssertion(request, requestMethod))
                );
        return responseAtomic.get();
    }

    private static Response doRequestUntilSucceeded(RequestSpecification request, Method requestMethod) {
        AtomicReference<Response> responseAtomic = new AtomicReference<>();
        await().untilAsserted(
                () -> responseAtomic.set(doRequestWithAssertion(request, requestMethod))
        );
        return responseAtomic.get();
    }

    private static Response doRequestWithAssertion(RequestSpecification request, Method method) {
        final Response response = doRequest(request, method);
        Assertions.assertThat(response.getStatusCode())
                .as("\nExpected status code: 2**\nActual status code: %s\nResponse body is:\n%s",
                        response.statusCode(), response.body().prettyPrint())
                .isGreaterThanOrEqualTo(HttpStatus.SC_OK)
                .isLessThanOrEqualTo(HttpStatus.SC_PARTIAL_CONTENT);
        return response;
    }

    private static Response doRequest(RequestSpecification request, Method method) {
        Response response;
        switch (method) {
            case GET:
                response = request.log().all().get();
                break;
            case PUT:
                response = request.log().all().put();
                break;
            case POST:
                response = request.log().all().post();
                break;
            case DELETE:
                response = request.log().all().delete();
                break;
            default:
                throw new IllegalArgumentException(String.format("Request method %s is not supported at the moment", method));
        }
        return response;
    }

    public static RequestSpecification getRequestSpecification() {
        RestAssured.reset();
        return given()
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured());
    }
}