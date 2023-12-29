package com.weatherstack.steps;

import com.weatherstack.api.client.helpers.ResponseHelper;
import com.weatherstack.api.cucumber.ScenarioStorage;
import com.weatherstack.api.facades.WeatherstackFacade;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONObject;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherstackSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherstackSteps.class);
    private final String scenarioName = ScenarioStorage.currentScenarioName();
    private JSONObject jsonResponse;
    private SoftAssertions softAssertions;

    @Given("user makes GET weather forecast request for {string} endpoint and {string} access key in {string}")
    public void userMakesGetWeatherForecastRequestForEndpointInAndAccessKey(String endpoint, String accessKey, String city) throws Exception {
        ResponseHelper.saveResponse(scenarioName, WeatherstackFacade.getWeatherForecast(endpoint, accessKey, city));
        jsonResponse = new JSONObject(ResponseHelper.getSavedResponse(ScenarioStorage.currentScenarioName()).getBody().asString());
    }

    @Then("Response code should be {int}")
    public void responseCodeShouldBe(int statusCode) throws Exception {
        Assertions.assertThat(statusCode).isEqualTo(ResponseHelper.getSavedResponse(ScenarioStorage.currentScenarioName()).statusCode());
        LOGGER.info("Actual response status: {}", ResponseHelper.getSavedResponse(ScenarioStorage.currentScenarioName()).statusCode());
    }

    @And("init soft assertion")
    public void initSoftAssertion() {
        softAssertions = new SoftAssertions();
    }

    @Then("user softly asserts {string} {string} value in weather forecast response")
    public void userSoftlyAssertsValueInWeatherForecastResponse(String expectedValue, String valueName) {
        switch (valueName) {
            case "utc_offset", "country", "timezone_id" -> assertActualAndExpectedValues(
                    valueName,
                    String.valueOf(jsonResponse.getJSONObject("location").getString(valueName)),
                    expectedValue);
            case "type" -> assertActualAndExpectedValues(
                    valueName,
                    jsonResponse.getJSONObject("error").getString("type"),
                    expectedValue);
            case "code" -> assertActualAndExpectedValues(
                    valueName,
                    String.valueOf(jsonResponse.getJSONObject("error").getInt("code")),
                    expectedValue);
            case "success" -> assertActualAndExpectedValues(
                    valueName,
                    String.valueOf(jsonResponse.getBoolean("success")),
                    expectedValue);
            default -> {
                LOGGER.error("Unexpected value name: '{}'", valueName);
                throw new IllegalArgumentException(String.format("Unexpected value name: '%s'", valueName));
            }
        }

    }

    @Then("evaluate soft assertion")
    public void evaluateSoftAssertion() {
        if (softAssertions == null) {
            LOGGER.info("There is nothing to assert, because softAssertions is null");
        } else {
            softAssertions.assertAll();
            softAssertions = null;
        }
    }

    private void assertActualAndExpectedValues(final String valueName, final String actualValue, final String expectedValue) {
        LOGGER.info("Actual '{}' is: '{}'", valueName, actualValue);
        LOGGER.info("Expected '{}' is: '{}'", valueName, expectedValue);
        softAssertions
                .assertThat(actualValue)
                .as(String.format("Actual '%s' is '%s' instead of expected '%s'", valueName, actualValue, expectedValue))
                .isEqualTo(expectedValue);
    }
}