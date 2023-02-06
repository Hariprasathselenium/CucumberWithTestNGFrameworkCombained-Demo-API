package Modules.StepDefinitions;

import Modules.POM.SauceLabDemoLoginPageMobile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.Base.TestBase;

public class SauceLabDemoStepsMobile extends TestBase {

    SauceLabDemoLoginPageMobile sauceLabLoginPage = new SauceLabDemoLoginPageMobile();
    @Given("^I launch the application$")
    public void launchApplication() throws Exception {
			sauceLabLoginPage.launchApp();
    }

    @When("^Enter Username \"([^\"]*)\" under sauce Lab$")
    public void enterUsername(String username) throws Exception {
        sauceLabLoginPage.enterUserName(username);
    }

    @Then("^Enter Password \"([^\"]*)\" Under Sauce Lab$")
    public void enterPasswordUnderSauceLab(String password) throws Exception  {
        sauceLabLoginPage.enterPassword(password);
    }

    @Then("^Click Login button$")
    public void clickLoginButton() throws Exception {
        sauceLabLoginPage.clickLogin();
    }

    @And("^Verify user is able to enter into homepage successfully$")
    public void verifyUserIsAbleToEnterIntoHomepageSuccessfully() throws Exception {
        sauceLabLoginPage.verifyUserEnteredIntoAppSuccessfully();
    }

    @And("^Verify Validation message displayed in login page$")
    public void verifyValidationMessageDisplayedInLoginPage() throws Exception {
    	sauceLabLoginPage.verifyValidationMessage();
    }
}