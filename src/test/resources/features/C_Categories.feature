@Categories
Feature: Select Categories

  Scenario: User want to select phones on categories
    Given that user already is on landing page
    When click on Phones button on the category field
    Then The list of Phones will show up

  Scenario: User want to select laptops on categories
    Given that user already is on landing page
    When click on Laptops button on the category field
    Then The list of Laptops will show up

  Scenario: User want to select monitors on categories
    Given that user already is on landing page
    When click on Monitors button on the category field
    Then The list of Monitors will show up