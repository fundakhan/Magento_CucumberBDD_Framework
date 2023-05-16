Feature: Purchase Functionality

  Background:
    Given User navigates to Luma website
    When User enter admin credentials
    Then User should login successfully
@Smoke
    Scenario: Purchase Functionality Test
      When User select any product
      Then User added message should be displayed

      Scenario: Checkout Process Test
         When User complete checkout process
         Then Success checkout message should be displayed
