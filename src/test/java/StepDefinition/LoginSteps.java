package StepDefinition;

import POM.DialogContent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

   DialogContent dialogContent;
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        dialogContent = new DialogContent();

        dialogContent.validateUserOnLoginPage();
    }

    @When("User enter admin credentials")
    public void userEnterAdminCredentials() {

        dialogContent = new DialogContent();

        dialogContent.userEnterAdminCredentials();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {

        dialogContent = new DialogContent();

        dialogContent.validateUserSuccessfullyLoggedIn();
    }
}
