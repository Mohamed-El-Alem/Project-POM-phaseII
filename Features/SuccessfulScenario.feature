Feature: saucedemo

  Scenario: standard user
    Given User lunch chrome browser
    When User opens URL "https://www.saucedemo.com"
    And User enter email as "standard_user" and "secret_sauce"
    Then Click on login
    When User click on first item
    Then Add item to shopping cart
    And check item is correct
    Then Proceed checkout
    When Complete form
    And Logout
    Then  close the browser
