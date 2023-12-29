@api
Feature: Weatherstack - weather forecast

  Scenario Outline: Get weather forecast in "<city>"
    Given user makes GET weather forecast request for "current" endpoint and "valid" access key in "<city>"
    Then Response code should be 200
    And init soft assertion
    Then user softly asserts "<utc_offset>" "utc_offset" value in weather forecast response
    Then user softly asserts "<country>" "country" value in weather forecast response
    Then user softly asserts "<timezone_id>" "timezone_id" value in weather forecast response
    Then evaluate soft assertion
    Examples:
      | city     | utc_offset | country   | timezone_id      |
      | Paris    | 1.0        | France    | Europe/Paris     |
      | Minsk    | 3.0        | Belarus   | Europe/Minsk     |
      | Beijing  | 8.0        | China     | Asia/Shanghai    |
      | Canberra | 11.0       | Australia | Australia/Sydney |

  Scenario Outline: [Negative case] Get weather forecast info with "<endpoint>" endpoint and "<access_key>" access key in "<city>"
    Given user makes GET weather forecast request for "<endpoint>" endpoint and "<access_key>" access key in "<city>"
    Then Response code should be 200
    And init soft assertion
    Then user softly asserts "<type>" "type" value in weather forecast response
    Then user softly asserts "<code>" "code" value in weather forecast response
    Then user softly asserts "<success>" "success" value in weather forecast response
    Then evaluate soft assertion
    Examples:
      | access_key | endpoint           | city           | type                 | code | success |
      | valid      | current            | UnexpectedCity | request_failed       | 615  | false   |
      | valid      | UnexpectedEndpoint | Minsk          | invalid_api_function | 103  | false   |
      | invalid    | current            | Minsk          | invalid_access_key   | 101  | false   |
      | valid      | current            |                | missing_query        | 601  | false   |
