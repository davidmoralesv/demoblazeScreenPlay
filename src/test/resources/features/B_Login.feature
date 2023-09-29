#Autor: David Morales Valencia
#Email: davidmoralv@gmail.com
#language: en

@Login
Feature: Validate Login

  Scenario: Sign up
    Given that user already is on landing page
    And user does Sign up
    Then verify that a pop-up appears Sign up successful. indicating successful registration

  Scenario: User login with registered username and password
    Given that user already is on landing page
    When user clicks on the login menu
    And user inputs registered username and registered password
    And user clicks on the Log button
    Then user verifies the successful login

  Scenario Outline: User login with wrong password
    Given that user already is on landing page
    When user clicks on the login menu
    And user inputs username and inputs wrong password
    And user clicks on the Log button
    Then pop up is showed with message <message>
    Examples:
      | message         |
      | Wrong password. |

  Scenario Outline: User login with unregistered username
    Given that user already is on landing page
    When user clicks on the login menu
    And user inputs wrong username and inputs password
    And user clicks on the Log button
    Then pop up is showed with message <message>
    Examples:
      | message              |
      | User does not exist. |