Feature: Account Functionality

  Scenario:Account Create
    Given User navigates to Luma website
    And Click to Create Account Menu button

    And Fill in the form with the following information
      | firstName       | Sam                  |
      | lastName        | Smith                |
      | email           | samsmith55@gmail.com |
      | password        | Sam.5s               |
      | passwordConfirm | Sam.5s               |

    When Click to Create Account button

    When Successfully message should be displayed
    And Click to sign out button
