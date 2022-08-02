Feature: user could register to the webapp
  Scenario: new visitors could register with valid data
    Given user goes to register page
    When user chooses a gender "female"
    And user enters full name "Asmaa" and "Rashid"
    And user chooses date of  birth
    And user enters email "nopdemoprojectasmaa@gmail.com"
    And user enters company name
    And user enters password "123456" and confirmation "123456"
    And user clicks on register button
    Then webapp displays success message