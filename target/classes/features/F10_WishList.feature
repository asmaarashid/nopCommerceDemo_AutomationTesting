@smoke
  Feature: user could add an item to the wishlist
    Background:
      When user clicks on add to wishlist icon

    Scenario: user could add item to wishlist and see success message
      Then a success message is displayed on top of the page

    Scenario: user could add item to wishlist and check the wish list
      And user goes to wishlist page
      Then the item is added to wishlist successfully
