Feature: Address Functionality

  Background:
    Given User is on login page
    When User enter admin credentials
    Then User should login successfully

    Scenario Outline:
      When User navigate to My Account page
      Then User click on Manage address
      Then User add a new "<phoneNumber>" and "<streetAddress>" and "<city>" and "<state>" and "<zipCode>"
      Then Success message should be displayed

      Examples:
        | phoneNumber | streetAddress | city   | state   | zipCode |
        | 5458687972  | lakeview Dr.  | Weston | Florida | 33326   |
        | 5458687972  | lake Dr.      | Weston | Florida | 33326   |
        | 5458687972  | lestwake Dr.  | Weston | Florida | 35655   |
