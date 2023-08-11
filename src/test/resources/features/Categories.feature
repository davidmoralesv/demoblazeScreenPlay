@Categories
Feature: Categories

  Scenario: Sign up
    Given The user has registered on the website

  Scenario: User login with registered username and password

    Given user already on landing page
    When user click on Log in menu button
    And user inputs registered username and registered password
    Then user click Log in button
    And user login successfully

  Scenario: User want to select phones on categories
    Given user already on landing page
    When click on Phones button on the category field
    And Phones products will showed up

  Scenario: User want to select laptops on categories
    Given user already on landing page
    When click on Laptops button on the category field
    And Laptops products will showed up

  Scenario: User want to select monitors on categories
    Given user already on landing page
    When click on Monitors button on the category field
    And Monitors products will showed up