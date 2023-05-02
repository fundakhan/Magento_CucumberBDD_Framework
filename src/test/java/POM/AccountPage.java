package POM;

import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePOM{


    public AccountPage(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(css = "[class=\"panel header\"] li:last-child")
    private WebElement createAccountMenuBtn;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirm;

    @FindBy(css = "[class=\"action submit primary\"]")
    private WebElement createAccountBtn;

    @FindBy(css = "div[data-bind^=html]")
    private WebElement successMessage;

    @FindBy(xpath = "(//button[@class=\"action switch\"])[1]")
    private WebElement dropdownBtn;

    @FindBy(xpath = "(//*[@class=\"authorization-link\"])[1]")
    private WebElement signOutBtn;


    public WebElement getCreateAccountMenuBtn() {
        return createAccountMenuBtn;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPasswordConfirm() {
        return passwordConfirm;
    }

    public WebElement getCreateAccountBtn() {
        return createAccountBtn;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getDropdownBtn() {
        return dropdownBtn;
    }

    public WebElement getSignOutBtn() {
        return signOutBtn;
    }

    @Override
    public String toString() {
        return "AccountPage{" +
                "createAccountMenuBtn=" + createAccountMenuBtn +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", password=" + password +
                ", passwordConfirm=" + passwordConfirm +
                ", createAccountBtn=" + createAccountBtn +
                ", successMessage=" + successMessage +
                ", dropdownBtn=" + dropdownBtn +
                ", signOutBtn=" + signOutBtn +
                '}';
    }
}
