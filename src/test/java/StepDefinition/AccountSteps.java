package StepDefinition;

import POM.AccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class AccountSteps {

    AccountPage accountPage = new AccountPage();

    @And("Click to Create Account Menu button")
    public void clickToCreateAccountMenuButton() {

        accountPage.waitUntilClickable(accountPage.getCreateAccountMenuBtn());

    }

    @And("Fill in the form with the following information")
    public void fillInTheFormWithTheFollowingInformation(DataTable formInfo) throws InterruptedException {

        List<List<String>> formInfoElements = formInfo.asLists(String.class);

        for (List<String> list : formInfoElements) {
            accountPage.getFirstName().sendKeys(list.get(1));
            accountPage.getLastName().sendKeys(list.get(3));
            accountPage.getEmail().sendKeys(list.get(5));
            accountPage.getPassword().sendKeys(list.get(7));
            accountPage.getPasswordConfirm().sendKeys(list.get(9));
            }
    }

        @When("Click to Create Account button")
        public void clickToCreateAccountButton () {
            accountPage.waitUntilClickable(accountPage.getCreateAccountBtn());


        }

        @When("Successfully message should be displayed")
        public void successfullyMessageShouldBeDisplayed () {

            accountPage.verifySuccessMessage(accountPage.getSuccessMessage());
        }

        @And("Click to sign out button")
        public void clickToSignOutButton () {

            accountPage.waitUntilClickable(accountPage.getDropdownBtn());
            accountPage.waitUntilClickable(accountPage.getSignOutBtn());
        }

}
