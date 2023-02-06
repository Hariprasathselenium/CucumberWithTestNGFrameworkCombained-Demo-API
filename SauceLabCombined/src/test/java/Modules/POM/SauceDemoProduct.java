package Modules.POM;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import project.Base.DriverManager;
import project.Base.TestBase;
import project.Utility.UtilsManager;


public class SauceDemoProduct extends TestBase {

		private String product1 ="";
		private String product2 ="";
    By img_SideMenuBurger = By.xpath(".//button[@id='react-burger-menu-btn']");
    By page_title = By.xpath(".//*[@class='header_secondary_container']//span");
    By item_SauceLabBackPack = By.xpath(".//*[@id='add-to-cart-sauce-labs-backpack']");
    By item_RedTshirt = By.xpath(".//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    By icon_ShoppingCart = By.xpath(".//*[@id='shopping_cart_container']");
    By txt_Cart_Item_SauceLabsBackpack = By.xpath(".//*[@id='item_4_title_link']");
    By txt_Cart_Item_RedTshirt = By.xpath(".//*[@id='item_3_title_link']");
    By btn_Checkout = By.xpath(".//*[@id='checkout']");
    By input_FirstName = By.xpath(".//input[@id='first-name']");
    By input_LastName = By.xpath(".//input[@id='last-name']");
    By input_PostalCode = By.xpath(".//input[@id='postal-code']");
    By btn_Continue = By.xpath(".//input[@id='continue']");
    By txt_ItemAmount1 = By.xpath("(.//*[@id='item_4_title_link']//following::div[@class='inventory_item_price'])[1]");
    By txt_ItemAmount2 = By.xpath(".//*[@id='item_3_title_link']//following::div[@class='inventory_item_price']");
    By txt_TotalItemsAmount_Before_Tax = By.xpath(".//div[@class='summary_subtotal_label']");
    By btn_Finish = By.xpath(".//button[@id='finish']");
    By txt_ThankyouOrder = By.xpath(".//*[@id='checkout_complete_container']//h2");
    By txt_OrderDispatched = By.xpath(".//*[@id='checkout_complete_container']//*[@class='complete-text']");
    By btn_Logout = By.xpath(".//*[@id='logout_sidebar_link']");
    
    
    
    public void verifyUserLoggedinSuccessfully() throws Exception {
        if(UtilsManager.waitForElementVisibility(img_SideMenuBurger)) {
        	UtilsManager.isElementDisplayed(img_SideMenuBurger);
        	UtilsManager.VerifyExpectedTextIsSameAsActual(page_title, "PRODUCTS");
        	UtilsManager.takeScreenshot();
        }else {
        	Assert.fail("User not able to login and unable to navigate to products page");
        }
    }

    public void addMostExpensiveProduct() throws Exception {
        if(UtilsManager.waitForElementVisibility(item_SauceLabBackPack)) {
        	product1 = UtilsManager.getText(txt_Cart_Item_SauceLabsBackpack);
        	UtilsManager.click(item_SauceLabBackPack);
        	UtilsManager.scrollToBottomOfPage();
        	product2 = UtilsManager.getText(txt_Cart_Item_RedTshirt);
        	UtilsManager.click(item_RedTshirt);
        }else {
        	Assert.fail("Unable to add expensive product");
        }
    }

    public void clickOnCartButton() throws Exception {
    	UtilsManager.scrollToTopOfPage();
        if(UtilsManager.waitForElementVisibility(icon_ShoppingCart)) {
        	UtilsManager.click(icon_ShoppingCart);
        }else {
        	Assert.fail("Unable to click on cart button");
        }
    }

    public void verifyUserNavigatedToCartPage() throws Exception {
         	UtilsManager.VerifyExpectedTextIsSameAsActual(page_title, "YOUR CART");
         	UtilsManager.takeScreenshot();
    }
    
    public void verifySelectedProductAdded() throws Exception {
    	UtilsManager.VerifyExpectedTextIsSameAsActual(txt_Cart_Item_SauceLabsBackpack, "Sauce Labs Backpack");
    	UtilsManager.VerifyExpectedTextIsSameAsActual(txt_Cart_Item_RedTshirt, "Test.allTheThings() T-Shirt (Red)");
    	UtilsManager.takeScreenshot();
    }

    public void clickOnCheckOutButton() throws InterruptedException {
    	UtilsManager.scrollToBottomOfPage();
    	UtilsManager.waitForElementVisibility(btn_Checkout);
    	UtilsManager.click(btn_Checkout);
    }
    
    public void verifyUserNavigatedToCheckoutPage() throws Exception {
    	UtilsManager.VerifyExpectedTextIsSameAsActual(page_title, "CHECKOUT: YOUR INFORMATION");
    	UtilsManager.takeScreenshot();
    }
    
    public void fillDetailsIntoForm(String firstName,String lastName,String pincode) throws IOException {
    	UtilsManager.sendText(input_FirstName, firstName);
    	UtilsManager.sendText(input_LastName, firstName);
    	UtilsManager.sendText(input_PostalCode, firstName);
    	UtilsManager.takeScreenshot();
    }
    
    public void clickContinueButton() {
    	UtilsManager.click(btn_Continue);
    }
    
    public void verifyUserNavigatedToOverviewPage() {
    	try {
			UtilsManager.VerifyExpectedTextIsSameAsActual(page_title, "CHECKOUT: OVERVIEW");
			UtilsManager.takeScreenshot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void verifyTotalAmountBeforeTax() {
    	String Amount1= UtilsManager.getText(txt_ItemAmount1).replace("$","").replace(" ","");
    	String Amount2= UtilsManager.getText(txt_ItemAmount2).replace("$","").replace(" ","");
    	float integerExpectedAmount = Float.parseFloat(Amount1)+Float.parseFloat(Amount2);
    	String arrNewString[] =UtilsManager.getText(txt_TotalItemsAmount_Before_Tax).split(":");
    	String ActualAmount = arrNewString[1].replace("$","").trim();
    	try {
    		if(Float.toString(integerExpectedAmount).contains(ActualAmount)) {
    			System.out.println("Amount before tax is same as expected");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Amount before tax is not same as expected");
    	}
    }
    
    public void verifygivenURLmatches(String ExpectedURL) {
    	try {
    		String currentURL = DriverManager.getWebDriver().getCurrentUrl();
    		if(ExpectedURL.equalsIgnoreCase(currentURL)) {
    			System.out.println("URL is matched as Expected");
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void clickFinishButton() {
    	try {
    	UtilsManager.click(btn_Finish);
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void verifyThankyouMessage() {
    	try {
        	String strThankYouMessage = UtilsManager.getText(txt_ThankyouOrder);
        	if(strThankYouMessage.equalsIgnoreCase("YOU FOR YOUR ORDER") ) {
        		System.out.println("Thank you message is displayed as Expected");
        	}
        	}catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    
    public void verifyOrderDispatchedMessage() {
    	try {
        	String strOrderDispatchedMessage = UtilsManager.getText(txt_OrderDispatched);
        	if(strOrderDispatchedMessage.equalsIgnoreCase("Your order has been dispatched, and will arrive just as fast as the pony can get there!") ) {
        		System.out.println("Order Dispatched message is displayed as Expected");
        		UtilsManager.takeScreenshot();
        	}
        	}catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    
    public void clickLogout() {
    	try {
    	UtilsManager.click(img_SideMenuBurger);
    	UtilsManager.waitForElementVisibility(btn_Logout);
    	UtilsManager.click(btn_Logout);
    	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
