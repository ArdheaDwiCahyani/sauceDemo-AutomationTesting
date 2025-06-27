@All
Feature: Login

  @Test1 @Login
  Scenario: Login Successfull
    Given User is in login page
    When User fill username and password
    And User click login button
    Then User verify login result

  @Test2 @Login
  Scenario: Login with invalid username and password
    Given User is in login page
    When User fill invalid username and password
    And User click login button
    Then User get error message
