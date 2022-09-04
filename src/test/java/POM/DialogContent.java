package POM;

import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DialogContent extends BasePOM{

    public DialogContent(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInBtn;

    @FindBy(xpath = "//input[@name='login[username]']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement passwordInput;

    @FindBy(xpath = "(//button[@id='send2'])[1]")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[text()='Customer Login']")
    private WebElement validationLoginPage;

    @FindBy(xpath = "//span[text()='Welcome, Toffee Akhan!']")
    private WebElement validationHomePage;

    @FindBy(xpath = "(//button[@class='action switch'])[1]")
    private WebElement welcomeBtn;

    @FindBy(linkText = "My Account")
    private WebElement myAccountBtn;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountValidation;

    @FindBy(xpath = "(//a[@class='action edit'])[3]")
    private WebElement manageAddressBtn;

    @FindBy(css = "button[class='action primary add']")
    private WebElement addNewAddressBtn;

    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement validationAddNewAddressPage;


    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id='street_1']")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//select[@id='region_id']")
    private WebElement selectState;

    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement selectCountry;

    @FindBy(css = "button[class='action save primary']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[text()='You saved the address.']")
    private WebElement successMessage;




    private String username = "toffee@gmail.com";
    private String password = "Tof1234tof";




    public void validateUserOnLoginPage(){

        waitUntilVisibleAndClickableThenClick(signInBtn);
        wait.until(ExpectedConditions.urlContains("customer/account/login"));
        Assert.assertTrue(usernameInput.isDisplayed());

    }

    public void userClickOnManageAddress(){

        manageAddressBtn.click();


    }

    public void userEnterAdminCredentials(){


        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
        passwordInput.sendKeys(password);
        waitUntilVisibleAndClickableThenClick(loginBtn);
    }

    public void validateUserSuccessfullyLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(validationHomePage));
        Assert.assertTrue(validationHomePage.isDisplayed());
        String expectedResult = "Welcome, Toffee Akhan!";
        Assert.assertEquals(validationHomePage.getText(),expectedResult);
    }

    public void ValidateToMyAccountPage(){

        welcomeBtn.click();
        myAccountBtn.click();
        waitUntilVisibleAndClickableThenClick(myAccountValidation);
        Assert.assertTrue(myAccountValidation.isDisplayed());
        String expectedResult = "My Account";
        Assert.assertEquals(myAccountValidation.getText(),expectedResult);
    }

    public void validationAddNewAddressPage(){

        manageAddressBtn.click();
      //  Assert.assertTrue(validationAddNewAddressPage.isDisplayed());
        addNewAddressBtn.click();


    }

    public void userAddNewAddress(String phoneNumber,String streetAddress,String city,String state,String zipCode){

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
        streetAddressInput.clear();
        streetAddressInput.sendKeys(streetAddress);
        cityInput.clear();
        cityInput.sendKeys(city);

        selectState.click();
        Select select = new Select(selectState);
        select.selectByVisibleText(state);

        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
        saveButton.click();

    }

    public void validationSuccessMessage(){
        String expectedResult = "You saved the address.";
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(successMessage.getText(),expectedResult);
    }

}
