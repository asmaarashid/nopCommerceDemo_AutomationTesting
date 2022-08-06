@smoke
Feature: user should be able to select sub-category from the main categories

  Scenario: user hover on a main category and select a sub-category from it
    When user hovers on main category
    And user selects a sub-category
    Then this sub-category's page is opened