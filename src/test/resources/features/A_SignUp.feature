@SignUp
Feature: Sign Up

  Scenario Outline: Validate the user registration process on the site
    Given that user already is on landing page
    When user does Sign up
    Then verify that a pop-up appears <message> indicating successful registration
    Examples:
      | message             |
      | Sign up successful. |