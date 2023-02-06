Feature: Verify Invalid Login Error Message in Sauce Demo website

  Background:
    Given Open the Browser and Verify Site is launched
    
  @InvalidLogin
  Scenario Outline: Verify Invalid Login for Sauce demo site
  When Enter the Username "<UserName>" into sauce demo site
  Then Enter the invalid password "<Password>"into sauce demo site
  And Click Login button under sauce demo site
  Then Verify Validation error message for wrong credentials
  
    Examples:
    |UserName|Password|
    |standard_user|test1234|
