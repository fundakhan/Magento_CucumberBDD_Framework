package StepDefinition;

import POM.PurchasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseSteps {

    PurchasePage purchasePage;



    @When("User select any product")
    public void userSelectAnyProduct() {
        purchasePage = new PurchasePage();
        purchasePage.selectPurchase();

    }

    @Then("User added message should be displayed")
    public void userAddedMessageShouldBeDisplayed() {

        purchasePage = new PurchasePage();
        purchasePage.validationAddToCartMessage();
    }

    @When("User complete checkout process")
    public void userCompleteCheckoutProcess()  {


        purchasePage = new PurchasePage();
        purchasePage.proceedToCheckout();
    }


    @Then("Success checkout message should be displayed")
    public void successCheckoutMessageShouldBeDisplayed() {

        purchasePage = new PurchasePage();

        purchasePage.successPurchaseMessage();

    }



}
