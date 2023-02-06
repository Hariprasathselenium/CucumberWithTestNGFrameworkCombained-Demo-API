package Modules.StepDefinitions;

import java.util.List;

import Modules.POM.Home;
import Modules.POM.SauceDemoProduct;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class SauceDemoProductStepDefinition {
	public SauceDemoProduct sauceDemoProductPage;
	public Home home;

	public SauceDemoProductStepDefinition(){
		sauceDemoProductPage = new SauceDemoProduct();
		home = new Home();
	}

	@And("^Enter the password \"(.*)\"into sauce demo site$")
	public void enterPassword(String value) throws Exception {
		home.enterPassword(value);
	}

	@And("^Verify user is logged in successfully and navigated to products page$")
	public void verifyUserLoggedSuccessfully() throws Exception {
		sauceDemoProductPage.verifyUserLoggedinSuccessfully();
	}
	
	@And("^Add the most expensive product to cart$")
	public void addMostExpensiveProduct() throws Exception {
		sauceDemoProductPage.addMostExpensiveProduct();
	}
	
	@And("^Click on Cart button$")
	public void clickOnCartButton() throws Exception {
		sauceDemoProductPage.clickOnCartButton();
	}

	@And("^Verify user is navigated to Cart page$")
	public void verifyUserNavigatedToCartPage() throws Exception {
		sauceDemoProductPage.verifyUserNavigatedToCartPage();
	}
	
	@And("^Verify the selected products are added and displayed$")
	public void verifySelectedProductAdded() throws Exception {
		sauceDemoProductPage.verifySelectedProductAdded();
	}
	
	@And("^Click on Checkout button$")
	public void clickOnCheckOutButton() throws Exception {
		sauceDemoProductPage.clickOnCheckOutButton();
	}
	
	@And("^Verify user is navigated to checkout page$")
	public void verifyUserNavigatedToCheckoutPage() throws Exception {
		sauceDemoProductPage.verifyUserNavigatedToCheckoutPage();
	}
	
	@And("^Fill the details FirstName,LastName,Pincode into the form$")
	public void fillDetailsIntoForm(DataTable table) throws Exception {
		List<List<String>> value = table.asLists();
		List<String> list = value.get(0);
		String firstName = list.get(0);
		String lastName = list.get(1);
		String pincode = list.get(2);
		sauceDemoProductPage.fillDetailsIntoForm(firstName, lastName, pincode);
	}
	
	@And("^Click on continue button$")
	public void clickContinueButton() throws Exception {
		sauceDemoProductPage.clickContinueButton();
	}
	
	@And("^Verify user is navigated to Overview page$")
	public void verifyUserNavigatedToOverviewPage() throws Exception {
		sauceDemoProductPage.verifyUserNavigatedToOverviewPage();
	}
	
	@And("^Verify total items amount before tax$")
	public void verifyTotalAmountBeforeTax() throws Exception {
		sauceDemoProductPage.verifyTotalAmountBeforeTax();
	}
	
	@And("^Verify the given \"(.*)\" is matches with current page$")
	public void verifygivenURLmatches(String value) throws Exception {
		sauceDemoProductPage.verifygivenURLmatches(value);
	}
	
	@And("^Click on Finish button$")
	public void clickFinishButton() throws Exception {
		sauceDemoProductPage.clickFinishButton();
	}
	
	@And("^Verify Thank you message and order dispached message is displayed successfully$")
	public void verifyOrderPalcedMessage() throws Exception {
		sauceDemoProductPage.verifyThankyouMessage();
		sauceDemoProductPage.verifyOrderDispatchedMessage();
	}
	
	@And("^Click on Logout button$")
	public void clickLogout() throws Exception {
		sauceDemoProductPage.clickLogout();
	}
}
