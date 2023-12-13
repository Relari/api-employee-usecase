Feature: get demos
  Scenario: Test Create a New Demo
    Given url 'http://localhost:8081/api/v1/demos'
    When header 'Content-Type' = 'application/json'
    And request { description: 'Description'}
#    And request
#    """
#      { "description": "Description"}
#    """
    When method POST
    Then status 201

  Scenario: Test List of Demos Response
    Given url 'http://localhost:8081/api/v1/demos'
    When method GET
    Then status 200

    Given def idFirstPosition = response[0].id
    Then print 'The value of the list is: ', idFirstPosition

    Given path response[0].id
    When method GET
    And match response.description == '#string'
    And match response.description == 'Description'
    And match responseType == 'json'
    Then status 200

    Then print 'The value of the list is: ', idFirstPosition

    Given path response.id
    When method DELETE
    Then status 204

    Then print 'The value of the list is: ', idFirstPosition