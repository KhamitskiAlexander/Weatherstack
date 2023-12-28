@api
Feature: Weatherstack - weather forecast

  Scenario Outline: <number> Get weather forecast in "<city>"
    Given as a user
    And user is going to make a request for weather podcast in "<city>"
    And user makes GET request for "current" endpoint
    Then Response code should be 200
    Examples:
      | number | city  |
      | 1      | Minsk |
