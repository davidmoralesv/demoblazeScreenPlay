@Login
Feature: Login

  Scenario: Sign up
    Given The user has registered on the website

  Scenario: User login with registered username and password

    Given user already on landing page
    When user click on Log in menu button
    And user inputs registered username and registered password
    Then user click Log in button
    And user login successfully


  Scenario Outline: User login with wrong password

    Given user already on landing page
    When user click on Log in menu button
    And user inputs username and inputs wrong password
    Then user click Log in button
    And pop up showed with message <message>
    Examples:
      | message         |
      | Wrong password. |


  Scenario Outline: User login with unregistered username

    Given user already on landing page
    When user click on Log in menu button
    And user inputs wrong username and inputs password
    Then user click Log in button
    And pop up showed with message <message>
    Examples:
      | message              |
      | User does not exist. |