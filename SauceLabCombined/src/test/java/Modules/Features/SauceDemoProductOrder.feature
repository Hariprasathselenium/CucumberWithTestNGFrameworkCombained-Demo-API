Feature: Sauce Demo website - product Order

  Background:
    Given Open the Browser and Verify Site is launched
    
	@SauceDemoProduct
  Scenario Outline: Verify user able to add and Order sauce product successfully
  When Enter the Username "<UserName>" into sauce demo site
  Then Enter the password "<Password>"into sauce demo site
  And Click Login button under sauce demo site
  Then Verify user is logged in successfully and navigated to products page
  And Add the most expensive product to cart
  When Click on Cart button
  Then Verify user is navigated to Cart page
  And Verify the selected products are added and displayed
  When Click on Checkout button
  Then Verify user is navigated to checkout page
  And Fill the details FirstName,LastName,Pincode into the form
  		|TestUser |LastUser|123456 |
  When Click on continue button
  Then Verify user is navigated to Overview page
  Then Verify total items amount before tax
  Then Verify the given "<URL>" is matches with current page
  When Click on Finish button
  Then Verify Thank you message and order dispached message is displayed successfully
  Then Click on Logout button
  
  Examples:
    |UserName     |Password    |URL|
    |standard_user|secret_sauce|https://www.saucedemo.com/checkout-step-two.html|