@smoke
  Feature: user could select different tags
    Scenario: user could select any tag for a product
      When user selects a category
      When user goes to tags page
      And user selects a tag
      Then all products with this tag are displayed