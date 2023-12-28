package com.weatherstack.steps;

import com.weatherstack.api.client.helpers.ResponseHelper;
import com.weatherstack.api.cucumber.ScenarioStorage;
import com.weatherstack.api.facades.WeatherstackFacade;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class SearchSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchSteps.class);
    private final String scenarioName = ScenarioStorage.currentScenarioName();
    private String conditions;
    private String location;
    private int fromDays;
    private int toDays;
    private String city;

    @Given("as a user")
    public void user() {
    }

    @And("user is going to make a request for weather podcast in {string}")
    public void userIsGoingToMakeARequestForWeatherPodcastIn(final String city) {
        this.city = city;
    }

    @When("user makes GET request for {string} endpoint")
    public void userMakesGetRequestForEndpoint(String search) {
        switch (search) {
            case "current":
                ResponseHelper.saveResponse(scenarioName, WeatherstackFacade.getWeatherForecast(this.city));
                break;
            default:
                throw new RuntimeException("Unexpected search name: " + location);
        }
    }

    @Then("Response code should be {int}")
    public void responseCodeShouldBe(int statusCode) throws Exception {
        Assert.assertEquals(statusCode, ResponseHelper.getSavedResponse(ScenarioStorage.currentScenarioName()).statusCode());
    }

//    @And("I want to search rents for {string} from current date + {int} days to current date + {int} days")
//    public void iWantToSearchRentsForFromCurrentDatePlusToCurrentDatePlus(String location, int fromDays, int toDays) {
//        this.location = location;
//        this.fromDays = fromDays;
//        this.toDays = toDays;
//        this.conditions = getConditionsValue(this.location, this.fromDays, this.toDays);
//        attachTableWithDatesToAllure(fromDays, toDays);
//    }
//
//    @When("I make GET request for {string}")
//    public void iMakeGetRequestFor(String search) {
//        switch (search) {
//            case "rent/api/partners/free2move/search":
//                ResponseHelper.saveResponse(scenarioName, PartnerRentFacade.getPartnerRentsSearch(this.conditions));
//                break;
//            case "rent/api/rents/search":
//                ResponseHelper.saveResponse(scenarioName, PartnerRentFacade.getRentsSearch(this.conditions));
//                break;
//            default:
//                throw new RuntimeException("Unexpected search name: " + location);
//        }
//    }
//
//    @Then("I validate that {string} Response size is greater than {int} else make a new search with more latter dates")
//    public void iValidateThatRentPartnersSearchResponseSizeIsGreaterThanElseMakeANewSearch(String arg, int size) throws Exception {
//        final boolean body_length = ResponseHelper.getSavedResponse(scenarioName).jsonPath().getInt("size()") == size;
//        String[] headers = {"#", "Actual", "Expected"};
//        String[] row = {"Response size:", String.valueOf(ResponseHelper.getSavedResponse(scenarioName).jsonPath().getInt("size()")), "> " + size};
//        String[][] table = {headers, row};
//        FileUtils.writeTableToCsv("build/response_size.csv", table);
//
//        getCsvFileBytes("build/response_size.csv")
//                .ifPresent(bytes -> Allure.getLifecycle()
//                        .addAttachment("Response size", "text/csv", "csv", bytes));
//
//        if (body_length) {
//            int retryNumber = 1;
//            while (retryNumber <= 3) {
//                try {
//                    sleep(MILLISECONDS.convert(Duration.ofSeconds(5)));
//                    this.fromDays += 1;
//                    this.toDays += 1;
//                    this.conditions = getConditionsValue(this.location, this.fromDays, this.toDays);
//                    switch (arg) {
//                        case "rent/api/partners/free2move/search":
//                            ResponseHelper.saveResponse(scenarioName, PartnerRentFacade.getPartnerRentsSearch(this.conditions));
//                            break;
//                        case "rent/api/rents/search":
//                            ResponseHelper.saveResponse(scenarioName, PartnerRentFacade.getRentsSearch(this.conditions));
//                            break;
//                        default:
//                            throw new RuntimeException("Unexpected search name: " + location);
//                    }
//                    retryNumber += 1;
//                    if (ResponseHelper.getSavedResponse(scenarioName).jsonPath().getInt("size()") > 0) {
//                        attachTableWithDatesToAllure(this.fromDays, this.toDays);
//                        break;
//                    }
//                } catch (InterruptedException e) {
//                    LOGGER.warn("Warning!");
//                    currentThread().interrupt();
//                }
//            }
//        }
//    }
//
//    @And("I validate that Response is matched for conditions:")
//    public void iValidateThatRentPartnersSearchResponseIsMatchedForConditions(Map<String, String> map) throws Exception {
//        Allure.getLifecycle().updateStep(step -> step.getAttachments().remove(0));
//        final int expected_status_code = Integer.parseInt(map.get("RESPONSE_CODE"));
//        final int expected_response_size = Integer.parseInt(map.get("RESPONSE_SIZE_GREATER_THAN"));
//        final long expected_response_time = Long.parseLong(map.get("RESPONSE_TIME_LESS_THAN"));
//        final Response response = ResponseHelper.getSavedResponse(scenarioName);
//        final List<Rent> rents = List.of(response.as(Rent[].class));
//        final String actual_status_code = String.valueOf(response.getStatusCode());
//        final String actual_response_size = String.valueOf(rents.size());
//        final String actual_response_time = String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS));
//
//        String[] headers = {"Response Info", "Actual", "Expected"};
//        String[] responseCode = {"Response code:", actual_status_code, String.valueOf(expected_status_code)};
//        String[] responseSize = {"Response size:", actual_response_size, "> " + expected_response_size};
//        String[] responseTime = {"Response time (mls):", actual_response_time, "< " + MILLISECONDS.convert(expected_response_time, SECONDS)};
//        String[][] table = {headers, responseCode, responseSize, responseTime};
//        FileUtils.writeTableToCsv("build/response_info.csv", table);
//
//        getCsvFileBytes("build/response_info.csv")
//                .ifPresent(bytes -> Allure.getLifecycle()
//                        .addAttachment("Response Info", "text/csv", "csv", bytes));
//        response
//                .then().statusCode(expected_status_code)
//                .and().body("size()", Matchers.greaterThan(expected_response_size))
//                .and().time(Matchers.lessThan(expected_response_time), TimeUnit.SECONDS);
//    }
//
//    private String getConditionsValue(String location, int fromDays, int toDays) {
//        String conditionsValue = "";
//        SearchCondition searchCondition = SearchConditionFactory.generateSearchCondition(location, fromDays, toDays);
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            conditionsValue = mapper.writeValueAsString(searchCondition);
//        } catch (JsonProcessingException e) {
//            LOGGER.error("Error during parsing RentSearchCondition.class to String.");
//        }
//        return conditionsValue;
//    }
//
//    private void attachTableWithDatesToAllure(int from, int to) {
//        String fromDate = DateUtil.getFutureDateInRequiredFormat(from, DateTimeFormatter.ofPattern("d MMM yyyy"));
//        String toDate = DateUtil.getFutureDateInRequiredFormat(to, DateTimeFormatter.ofPattern("d MMM yyyy"));
//        String[] headers = {"Date type", "Date format: 'd MMM yyyy'"};
//        String[] formattedFromDate = {"From:", fromDate};
//        String[] formattedToDate = {"To:", toDate};
//        String[][] table = {headers, formattedFromDate, formattedToDate};
//        FileUtils.writeTableToCsv("build/dates_for_search.csv", table);
//        getCsvFileBytes("build/dates_for_search.csv")
//                .ifPresent(bytes -> Allure.getLifecycle()
//                        .addAttachment("Dates for search", "text/csv", "csv", bytes));
//    }
//
//    private Optional<byte[]> getCsvFileBytes(String path) {
//        try {
//            return Optional.of(Files.readAllBytes(Paths.get(path)));
//        } catch (IOException e) {
//            LOGGER.warn("Couldn't find csv: [{}]", path);
//            return Optional.empty();
//        }
//    }
}