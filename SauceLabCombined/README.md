ABOUT FRAMEWORK :

This Framework is the combination of WEB automation and Mobile Automation

TECHNIQUES USED:

TestNG, Cucumber, Java, Selenium, Git,Page Object Model,appium.

HOW TO RUN WEB AUTOMATION:

1.Navigate to congiguration property file under Test Data folder.
2.Change BrowserType = CHROME and Execution Type = WEB
3.Navigate to feature file and copy the tag( Example:@ValidLogin) and go to this path "/SauceLabCombined/src/test/java/Modules/Runner/SauceDemoProductRunner.java"
4.Change the Tag name as which scenario it needs to be ran.
3.Now Navigate to /SauceLabCombined/src/test/java/Modules/Suites/test.xml and Run this xml file as TestNG

HOW TO RUN MOBILE AUTOMATION:

1.Navigate to congiguration property file under Test Data folder.
2.Change Automation Platform = Emulator and Execution Type = MOBILE
3.Navigate to feature file and copy the tag( Example:@ValidLoginMobile) and go to this path "/SauceLabCombined/src/test/java/Modules/Runner/SauceDemoProductRunner.java"
4.Change the Tag name as which scenario it needs to be ran.
3.Now Navigate to /SauceLabCombined/src/test/java/Modules/Suites/test.xml and Run this xml file as TestNG

Report is avaibale under the path :

/SauceLabCombined/test report

Screenshot will be captured under :

/SauceLabCombined/TestReport/Screenshots
