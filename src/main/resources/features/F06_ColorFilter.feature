@smoke
  Feature: user should be able to filter products by color
    Scenario: user filters shoes by color
      Given user goes to shoes page
      When user select a color filter
      Then filter should be applied and only products of this color are displayed