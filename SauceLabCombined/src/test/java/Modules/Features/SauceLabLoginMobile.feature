Feature: Sauce Lab Demo Site Login

Background:
    Given I launch the application

@ValidLoginMobile
Scenario Outline: Verify user is able to login successfully in SauceLab Application
  When Enter Username "<UserName>" under sauce Lab
  Then Enter Password "<Password>" Under Sauce Lab
  Then Click Login button
  And Verify user is able to enter into homepage successfully

Examples:
  | UserName | Password |
  | standard_user|secret_sauce|

@InValidLoginMobile
Scenario Outline: Verify validation message when user provide wrong credential in SauceLab Application
    When Enter Username "<UserName>" under sauce Lab
    Then Enter Password "<Password>" Under Sauce Lab
    Then Click Login button
    And Verify Validation message displayed in login page

Examples:
| UserName | Password |
| standard_user|secretsauce|