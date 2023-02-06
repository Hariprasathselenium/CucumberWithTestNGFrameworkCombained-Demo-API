package Modules.StepDefinitions;
import Modules.POM.Home;
import io.cucumber.java.en.And;
import project.Base.TestBase;

public class HomePage extends TestBase{
	public Home home;

	public HomePage(){
		home = new Home();
	}
	@And("^Open the Browser and Verify Site is launched$")
	public void validatingTheHomePageTitle() throws Exception {
		home.validatingTheHomePageTitle();
	}

	@And("^Enter the Username \"(.*)\" into sauce demo site$")
	public void enterUserName(String value) throws Exception {
		home.enterUserName(value);
	}
	
	@And("^Enter the invalid password \"(.*)\"into sauce demo site$")
	public void enterPassword(String value) throws Exception {
		home.enterPassword(value);
	}
	
	@And("^Click Login button under sauce demo site$")
	public void clickOnLoginButton() throws Exception {
		home.clickLoginButton();
	}

	@And("^Verify Validation error message for wrong credentials$")
	public void verifyValidationErrorMessage() throws Exception {
		home.verifyValidationErrorMessage();
	}
}
