# TestSuite
Feature: Validating place API

  # Testcase
  Scenario: Verify if place is being Successfully added using AddPlaceAPI
    Given Add Place Payload
    When User calls "AddPlaceAPI" with Post http request
    Then the API call got success with statusCode 200
    And "status" in response body is "OK"