@All
Feature: Product

  @Test6 @Product
  Scenario: View product details
    Given User is logged in and on the product page
    When User clicks on a product with name "Sauce Labs Backpack"
    Then User is redirected to the product detail page
    And Product title is displayed as "Sauce Labs Backpack"
    And Product description is visible
    And Product price is visible

  @Test7 @Product
  Scenario: Filter product by name (A to Z)
    Given User is logged in and on the product page
    When User click on the filter feature
    And User selects the "Name (A to Z)" option
    Then Products are displayed according to the name filter from A to Z

  @Test8 @Product
  Scenario: Filter product by name (Z to A)
    Given User is logged in and on the product page
    When User click on the filter feature
    And User selects the "Name (Z to A)" option
    Then Products are displayed according to the name filter from Z to A

  @Test9 @Product
  Scenario: Filter product by price (low to high)
    Given User is logged in and on the product page
    When User click on the filter feature
    And User selects the "Price (low to high)" option
    Then Products are displayed according to the price filter from low to high

  @Test10 @Product
  Scenario: Filter product by price (high to low)
    Given User is logged in and on the product page
    When User click on the filter feature
    And User selects the "Price (high to low)" option
    Then Products are displayed according to the price filter from high to low