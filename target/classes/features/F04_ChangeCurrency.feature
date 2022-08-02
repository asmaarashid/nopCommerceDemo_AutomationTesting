Feature: user could change currency

  Scenario: user could change currency from USD to Euro
    When user selects Euro as the currency
    Then all the below products' prices should be in euro