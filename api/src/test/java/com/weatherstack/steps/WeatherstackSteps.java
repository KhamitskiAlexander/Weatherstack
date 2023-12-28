package com.weatherstack.steps;

import com.weatherstack.api.client.helpers.ResponseHelper;
import com.weatherstack.api.cucumber.ScenarioStorage;
import com.weatherstack.api.facades.WeatherstackFacade;
import com.weatherstack.api.models.WeatherForecast;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherstackSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherstackSteps.class);
    private final String scenarioName = ScenarioStorage.currentScenarioName();
    private WeatherForecast weatherForecast;
    private SoftAssertions softAssertions;

    @Given("user makes GET request for {string} endpoint in {string}")
    public void userMakesGetRequestForEndpointIn(final String endpoint, final String city) {
        switch (endpoint) {
            case "current" -> ResponseHelper.saveResponse(scenarioName, WeatherstackFacade.getWeatherForecast(city));
            default -> throw new RuntimeException("Unexpected search name: " + endpoint);
        }
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

    @Then("user softly asserts actual and expected {string} {string} value")
    public void userSoftlyAssertsActualAndExpectedValue(String expectedValue, String valueName) throws Exception {
        weatherForecast = ResponseHelper.getSavedResponse(ScenarioStorage.currentScenarioName()).as(WeatherForecast.class);
        switch (valueName) {
            case "uts_offset" ->
                    assertActualAndExpectedValues(valueName, weatherForecast.getLocation().getUtc_offset(), expectedValue);
            case "is_day" ->
                    assertActualAndExpectedValues(valueName, weatherForecast.getCurrent().getIs_day(), expectedValue);
            case "timezone_id" ->
                    assertActualAndExpectedValues(valueName, weatherForecast.getLocation().getTimezone_id(), expectedValue);
            default -> {
                LOGGER.error("Unexpected value name: '{}'", valueName);
                throw new IllegalArgumentException(String.format("Unexpected value name: '%s'", valueName));
            }
        }
    }

    private void assertActualAndExpectedValues(final String valueName, final String actualValue, final String expectedValue) {
        LOGGER.info("Actual '{}' is: '{}'", valueName, actualValue);
        LOGGER.info("Expected '{}' is: '{}'", valueName, expectedValue);
        softAssertions
                .assertThat(actualValue)
                .as(String.format("Actual '%s' should be '%s' instead of expected '%s'", valueName, expectedValue, actualValue))
                .isEqualTo(expectedValue);
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
}