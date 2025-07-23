@All
Feature: Login

  @Test1 @Login @Positive
  Scenario: Login Successfull
    Given User is in login page
    When User fill username and password
    And User click login button
    Then User verify login result

  @Test2 @Login @Negative
  Scenario: Login with invalid username
    Given User is in login page
    When User fill invalid username
    And User fill password
    And User click login button
    Then User get error message

  @Test3 @Login @Negative
  Scenario: Login with invalid password
    Given User is in login page
    When User fill username
    And User fill invalid password
    And User click login button
    Then User get error message

  @Test4 @Login @Negative
  Scenario: Login with blank username and password
    Given User is in login page
    When User leave username blank
    And User leave password blank
    And User click login button
    Then User get error message "Username is required"

  @Test5 @Login @Negative
  Scenario: Login with blank password
    Given User is in login page
    When User fill username
    And User leave password blank
    And User click login button
    Then User get error message "Password is required"