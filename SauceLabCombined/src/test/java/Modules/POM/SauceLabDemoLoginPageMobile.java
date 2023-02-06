package Modules.POM;
import org.openqa.selenium.By;
import org.testng.Assert;

import project.Base.DriverManager;
import project.Base.TestBase;
import project.Utility.UtilsManager;


public class SauceLabDemoLoginPageMobile extends TestBase{

    /* Page Objects */
    private static final By input_UserName = By.xpath("//*[@content-desc='test-Username']");
    private static final By input_Password = By.xpath("//*[@content-desc='test-Password']");
    private static final By btn_Login = By.xpath("//*[@content-desc='test-LOGIN']");
    private static final By errMsg_LoginPage = By.xpath("//*[@content-desc='test-Error message']");
    private static final By txt_HomePage = By.xpath("//*[@text='PRODUCTS']");
   
    
    public void launchApp() throws Exception{
            if(UtilsManager.waitForElementVisibility(input_UserName)){
                System.out.println("Application Launched!");
                Assert.assertTrue(true,"Application Launched Successfully!");
            }else{
                Assert.assertTrue(false,"Unable to launch application!");
            }

    }

    public void enterUserName(String username) throws Exception{
        if(UtilsManager.isElementDisplayed(input_UserName)){
        	UtilsManager.sendText(input_UserName,username);
            Assert.assertTrue(true,"UserName is Entered successfully");
        }else{
            Assert.assertTrue(false,"unable to enter UserName");
        }
    }

    public void enterPassword(String password) throws Exception{
        if(UtilsManager.isElementDisplayed(input_Password)){
        	UtilsManager.sendText(input_Password,password);
            Assert.assertTrue(true,"Password is Entered successfully");
        }else{
            Assert.assertTrue(false,"unable to enter Password");
        }
    }

    public void clickLogin() throws Exception{
        if(UtilsManager.isElementDisplayed(btn_Login)){
            DriverManager.getDriver().findElement(btn_Login).click();
            Assert.assertTrue(true,"Login Button is clicked successfully");
        }else{
            Assert.assertTrue(false,"unable to click Login button");
        }
    }

    public void verifyUserEnteredIntoAppSuccessfully() throws Exception{
        if(UtilsManager.waitForElementVisibility(txt_HomePage)){
            System.out.println("HomePage is displayed");
            Assert.assertTrue(true,"HomePage is displayed successfully Successfully!");
        }else{
            Assert.assertTrue(false,"Unable to display homepage");
        }
    }

    public void verifyValidationMessage() throws Exception{
        if(UtilsManager.waitForElementVisibility(errMsg_LoginPage)){
            DriverManager.getDriver().findElement(errMsg_LoginPage).isDisplayed();
            Assert.assertTrue(true,"Error Message is displayed successfully Successfully!");
        }else{
            Assert.assertTrue(false,"Validation Error Message is not displayed");
        }
    }
}