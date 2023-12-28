@api
Feature: Weatherstack - weather forecast

  Scenario Outline: <number> Get weather forecast info in "<city>"
    Given user makes GET request for "current" endpoint in "<city>"
    Then Response code should be 200
    And init soft assertion
    Then user softly asserts actual and expected "<utc_offset>" "uts_offset" value
    Then user softly asserts actual and expected "<is_day>" "is_day" value
    Then user softly asserts actual and expected "<timezone_id>" "timezone_id" value
    Then evaluate soft assertion
    Examples:
      | number | city   | utc_offset | is_day | timezone_id    |
      | 1      | Minsk  | 3.0        | yes    | Europe/Minsk   |
      | 2      | Madrid | 1.0        | yes    | Europe/Madrid  |
      | 3      | Paris  | 1.0        | yes    | Europe/Paris   |
      | 4      | Majuro | 12.0       | yes    | Pacific/Majuro |
