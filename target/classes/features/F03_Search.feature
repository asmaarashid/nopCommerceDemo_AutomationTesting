Feature: logged user should be able to search for products either by name or SKU

  #Background:
   # Given user goes to log in page
    #And user enters registered email "nopdemoprojectasmaa@gmail.com" and password "123456"
    #And user clicks on log in button

  Scenario Outline:
    When user search for product using name "<name>"
    Then user is directed to right page
    And all products with the same name should be displayed with the "<name>"

    Examples:
    |name|
    |necklace|
    |laptop|
    |shoes|

  Scenario Outline:
    When user search for product using SKU "<sku>"
    Then user goes to the product page
    Then all products with the same SKU should be displayed with the "<sku>"

    Examples:
    |sku|
    |AD_C80_RS|
    |EG_GEM_NL|
    |NIGHT_VSN|