Feature: get demos

  Scenario Outline: Test Create a New Demo <nameCase>
    Given url 'http://localhost:8081/api/v1/demos'
    When header 'Content-Type' = 'application/json'
    And request { description: '<inputText>'}
#    And request
#    """
#      { "description": "<inputText>"}
#    """
    When method POST
    Then status <statusCode>
    Examples:
      | nameCase                             | inputText   | statusCode |
      | Case with description is Description | Description | 201        |
      | Case with description is Hello       | Hello       | 201        |
      | Case with description is World       | World       | 201        |
      | Case with description is Text        | Text        | 201        |
      | Case with description is Hello World | Hello World | 400        |

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