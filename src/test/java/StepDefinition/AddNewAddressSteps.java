package StepDefinition;

import POM.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewAddressSteps {

    DialogContent dialogContent;

    @When("User navigate to My Account page")
    public void userNavigateToMyAccountPage() {

        dialogContent = new DialogContent();
        dialogContent.ValidateToMyAccountPage();

    }

    @Then("User click on Manage address")
    public void userClickOnManageAddress() {

        dialogContent = new DialogContent();
        dialogContent.validationAddNewAddressPage();
    }

    @Then("User add a new {string} and {string} and {string} and {string} and {string}")
    public void userAddANewAndAndAndAnd(String phoneNumber, String streetAddress, String city, String state, String zipCode) {

        dialogContent = new DialogContent();
        dialogContent.userAddNewAddress(phoneNumber,streetAddress,city,state,zipCode);

    }

    @And("User change shipping address a new {string} and {string} and {string} and {string} and {string} with exist information")
    public void userEditAndAndAndAndWithExistInformation(String phoneNumber, String streetAddress, String city, String state, String zipCode) {
        dialogContent = new DialogContent();
        dialogContent.userChangeAddress(phoneNumber, streetAddress, city, state, zipCode);
    }

    @Then("Successfully saved message should be displayed")
    public void successMessageShouldBeDisplayed() {

        dialogContent = new DialogContent();
        dialogContent.verifySavedAddress();

    }



}
