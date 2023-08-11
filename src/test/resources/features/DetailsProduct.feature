@DetailsProduct
Feature: Add Product to Cart

  Scenario: Sign up and login
    Given that user already is on landing page
    And user does Sign up
    And verify that a pop-up appears Sign up successful. indicating successful registration

  Scenario Outline: User wants to add to cart item after do valid login
    Given that user already is on landing page
    When user inputs registered username and registered password and validate session
    And user clicks on item <product>
    And user clicks 'add to cart' button
    Then pop up is showed with message <message>
    Examples:
      | product           | message        |
      | Samsung galaxy s6 | Product added. |

  Scenario Outline: User wants to add to cart items without login
    Given that user already is on landing page
    When user clicks on item <product>
    And user clicks 'add to cart' button
    Then pop up is showed with message <message>
    Examples:
      | product           | message       |
      | Samsung galaxy s6 | Product added |