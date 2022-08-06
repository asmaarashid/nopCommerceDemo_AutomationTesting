@smoke
  Feature: user could follow NOP E-commerce on multiple media sites

    Scenario: user could follow on facebook
      When user clicks on facebook icon
      Then user is directed to facebook "https://www.facebook.com/nopCommerce"

    Scenario: user could follow on twitter
      When user clicks on twitter icon
      Then user is directed to twitter "https://twitter.com/nopCommerce"

    Scenario: user could follow on ssr
      When user clicks on rss icon
      Then user is directed to rss "https://demo.nopcommerce.com/new-online-store-is-open"

    Scenario: user could follow on youtube
      When user clicks on youtube icon
      Then user is directed to youtube "https://www.youtube.com/user/nopCommerce"

