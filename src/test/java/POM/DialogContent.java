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

    @FindBy(partialLinkText = "Sign In")
    private WebElement signInBtn;

    @FindBy(id = "email")
    private WebElement usernameInput;

    @FindBy(id = "pass")
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

    @FindBy(xpath = "(//a[@class='action edit'])[2]")
    private WebElement changeShippingAddress;

    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement validationAddNewAddressPage;


    @FindBy(css = "#telephone")
    private WebElement phoneNumberInput;

    @FindBy(css = "#street_1")
    private WebElement streetAddressInput;

    @FindBy(css = "#city")
    private WebElement cityInput;

    @FindBy(css = "#region_id")
    private WebElement selectState;

    @FindBy(css = "#zip")
    private WebElement zipCodeInput;

    @FindBy(css = "#country")
    private WebElement selectCountry;

    @FindBy(css = "button[class='action save primary']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[text()='You saved the address.']")
    private WebElement successMessage;

    @FindBy(xpath = "//div[text()='You saved the address.']")
    private WebElement verifySavedAddressMessage;




    private String username = "toffee@gmail.com";
    private String password = "Tof1234tof";




    public void validateUserOnLoginPage(){

        waitUntilClickable(signInBtn);
        wait.until(ExpectedConditions.urlContains("customer/account/login"));
        Assert.assertTrue(usernameInput.isDisplayed());

    }

    public void userClickOnManageAddress(){

        manageAddressBtn.click();


    }

    public void userEnterAdminCredentials(){


        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
        passwordInput.sendKeys(password);
        waitUntilClickable(loginBtn);
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
        waitUntilClickable(myAccountValidation);
        Assert.assertTrue(myAccountValidation.isDisplayed());
        String expectedResult = "My Account";
        Assert.assertEquals(myAccountValidation.getText(),expectedResult);
    }

    public void validationAddNewAddressPage(){

        manageAddressBtn.click();

        verifyPage(validationAddNewAddressPage);


    }

    public void userAddNewAddress(String phoneNumber,String streetAddress,String city,String state,String zipCode){

        phoneNumberInput.clear();
       waitUntilVisible(phoneNumberInput,phoneNumber);
        streetAddressInput.clear();
        waitUntilVisible(streetAddressInput,streetAddress);
        cityInput.clear();
        waitUntilVisible(cityInput,city);

        waitUntilClickable(selectState);
        Select select = new Select(selectState);
        select.selectByVisibleText(state);

        zipCodeInput.clear();
        waitUntilVisible(zipCodeInput,zipCode);
        waitUntilClickable(saveButton);

    }

    public void  verifySavedAddress(){

        verifySavedAddress(verifySavedAddressMessage);

    }

    public void userChangeAddress(String phoneNumber,String streetAddress,String city,String state,String zipCode){

        waitUntilClickable(changeShippingAddress);

        phoneNumberInput.clear();
        waitUntilVisible(phoneNumberInput,phoneNumber);
        streetAddressInput.clear();
        waitUntilVisible(streetAddressInput,streetAddress);
        cityInput.clear();
        waitUntilVisible(cityInput,city);

        waitUntilClickable(selectState);
        Select select = new Select(selectState);
        select.selectByVisibleText(state);

        zipCodeInput.clear();
        waitUntilVisible(zipCodeInput,zipCode);
        waitUntilClickable(saveButton);

    }

}
