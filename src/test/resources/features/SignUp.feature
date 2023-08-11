@SignUp
Feature: Sign Up

  Scenario Outline: User registers with unregistered username and password
    Given user already on landing page
    When user click on Sign up menu button
    And user inputs a new user as Username and inputs a Password
    Then user click Sign up button
    And verification pop-up appears <message> indicating successful registration
    Examples:
      | message             |
      | Sign up successful. |