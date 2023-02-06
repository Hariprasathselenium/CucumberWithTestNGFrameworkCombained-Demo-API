package Modules.POM;

import org.openqa.selenium.By;
import org.testng.Assert;

import project.Base.DriverManager;
import project.Base.TestBase;
import project.Utility.UtilsManager;


public class Home extends TestBase {
    By input_Username = By.xpath(".//input[@id='user-name']");
    By input_Password = By.xpath(".//input[@id='password']");
    By btn_Login = By.xpath(".//input[@id='login-button']");
    By errMsg_InvalidCredential = By.xpath(".//*[contains(@class,'error-message-container error')]//*[@data-test='error']");
    
    public void validatingTheHomePageTitle() throws Exception {
        String title = DriverManager.getWebDriver().getTitle();
        Assert.assertEquals(title, "Swag Labs");
        UtilsManager.takeScreenshot();
    }
    
    public void enterUserName(String username) throws Exception {
    	if(UtilsManager.waitForElementVisibility(input_Username)) {
    		UtilsManager.sendText(input_Username, username);
    		System.out.println("UserName is Entered");
    	}else {
    		Assert.fail("Unable to Enter UserName");
    	}
    }

    public void enterPassword(String password) throws Exception {
    	if(UtilsManager.waitForElementVisibility(input_Password)) {
    		UtilsManager.sendText(input_Password, password);
    		System.out.println("Password is Entered");
    	}else {
    		Assert.fail("Unable to Enter Password");
    	}
    }

    public void clickLoginButton() throws Exception {
    	if(UtilsManager.waitForElementVisibility(btn_Login)) {
    		UtilsManager.click(btn_Login);
    	}else {
    		Assert.fail("Unable to click Login");
    	}
    	
    }
    
    public void verifyValidationErrorMessage() throws Exception {
    	if(UtilsManager.waitForElementVisibility(errMsg_InvalidCredential)) {
    		String strInvalidMessage = UtilsManager.getText(errMsg_InvalidCredential);
    		Assert.assertEquals(strInvalidMessage, "Epic sadface: Username and password do not match any user in this service");
    		UtilsManager.takeScreenshot();
    	}else {
    		Assert.fail("No Validation Error Message is displayed");
    	}
    }
}
