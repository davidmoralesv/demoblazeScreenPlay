@Checkout
Feature: Fill Place Order

  Scenario: Sign up and login
    Given that user already is on landing page
    And user does Sign up
    Then verify that a pop-up appears Sign up successful. indicating successful registration

  Scenario Outline: User wants to add to cart item after do valid login
    Given that user already is on landing page
    When user inputs registered username and registered password and validate session
    And user clicks on item Samsung galaxy s6
    And user clicks 'add to cart' button
    And pop up is showed with message Product added.
    And user returns to landing page
    And user clicks on item Nokia lumia 1520
    And user clicks 'add to cart' button
    And pop up is showed with message Product added.
    And user clicks on Cart Menu
    And user verifies products in cart
    Then user clicks on Place Order button

    Given that user already is on Place Order
    When user fills the name field with the value <name>
    And user fills the country field with the value <country>
    And user fills the city field with the value <city>
    And user fills the card field with the value <card>
    And user fills the month field with the value <month>
    And user fills the year field with the value <year>
    And user clicks on Purchase button
    Then user validates the data in the successful popup
    And user clicks on OK button
    And user verifies page returns to landing page

    Examples:
      | name      | country  | city      | card   | month | year |
      | test user | Colombia | Marinilla | 123456 | 08    | 2023 |