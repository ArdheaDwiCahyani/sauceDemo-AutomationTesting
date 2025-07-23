@All
  Feature: Cart and Checkout

  @Test11 @cartCheckout
  Scenario: Add product to the cart
    Given User is logged in and on the product page (cart)
    When User adds "Sauce Labs Backpack" to the cart
    Then "Sauce Labs Backpack" should appear in the cart


  @Test12 @cartCheckout
  Scenario: Delete product from cart
    Given User is logged in and has "Sauce Labs Backpack" in the cart
    When Product removes "Sauce Labs Backpack" from the cart
    Then "Sauce Labs Backpack" should no longer appear in the cart

  @Test13 @cartCheckout
  Scenario: Successfully product checkout
    Given User is logged in and on the product page
    And User adds "Sauce Labs Backpack" to the cart
    And User click cart icon
    When User click checkout
    And User fills in the required data
    And User click continue
    And User click finish
    Then the checkout process is complete
    And "Sauce Labs Backpack" should no longer appear in the cart

