Feature: Luma Login Functionality
@Smoke
  Scenario: Login Functionality with valid credentials

    Given User navigates to Luma website
    When User enter admin credentials
    Then User should login successfully