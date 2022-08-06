@smoke
Feature: registered user must be able to log in
  Background:
    Given user goes to log in page

  Scenario: user logs in with registered email and password
    When user enters registered email "nopdemoprojectasmaa@gmail.com" and password "123456"
    And user clicks on log in button
    Then user is logged in successfully

  Scenario: user log in with invalid account data
    When user enters invalid email "aaa@aaa.aaa" and password "111111"
    And user clicks on log in button
    Then user is not logged in successfully

  Scenario: user forgets password
    And user clicks on forgot password
    When user enters email for recovery
    And user clicks on recovery button
    Then recovery email is sent to the user
