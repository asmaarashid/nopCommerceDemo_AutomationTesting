@smoke
  Feature: user navigates through home slider

    Scenario: user could navigate through first banner on the slider to specific location
      When user click on first banner
      Then user is directed to nokia page

    Scenario: user could go to second banner and navigate through it
      When user goes to second banner
      And user clicks on second banner
      Then user is directed to iphone page