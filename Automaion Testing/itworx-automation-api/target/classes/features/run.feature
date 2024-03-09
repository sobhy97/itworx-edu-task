Feature: Verify activity API response

  Scenario: Verify API response code and schema
    Given I call the activity API
    Then the response code should be 200
    And the response schema should match the expected schema