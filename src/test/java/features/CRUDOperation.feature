Feature: To perform CRUD operation

  Background: 
    Given The base URI is "http://localhost:3000/employees"

  Scenario: To Perform the GET Operation on Employe DB
    When I perform the Get Operation
    Then Response code should be 200

  Scenario Outline: To Perform the POST Operation to create Employee
    When I Provide "<name>" and "<salary>" as input
    And I perform the POST operartion
    And Employee should be created
    Then Response code should be 201

    Examples: 
      | name    | salary |
      | shareen |   1200 |
      | Praveen |   1300 |
