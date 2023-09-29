@Cart
Feature: Validate Products in Cart

  Scenario: Sign up and login
    Given that user already is on landing page
    And user does Sign up
    Then verify that a pop-up appears Sign up successful. indicating successful registration

  Scenario: User wants to add to cart item after do valid login
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
    Then user verifies products in cart

