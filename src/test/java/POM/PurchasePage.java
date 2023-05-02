package POM;

import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PurchasePage extends BasePOM{

    public PurchasePage(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(id = "ui-id-4")
    private WebElement womenBtn;

    @FindBy(id = "ui-id-14")
    private WebElement brasAndTanksBtn;

    @FindAll(@FindBy(xpath = "//li[@class='item product product-item']"))
    private List<WebElement> selectItem;

    @FindAll(@FindBy(css = "div[class='swatch-attribute size']>div>div"))
    private List<WebElement> selectSize;

    @FindBy(id = "option-label-color-93-item-57")
    private WebElement selectColor;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "(//div[@class='messages']//div)[2]")
    private WebElement validationAddToCart;

    @FindBy(xpath = "//div[@data-block='minicart']")
    private WebElement cartBtn;

    @FindBy(xpath = "//div[@class='primary']//button[1]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    private WebElement radioBtnOne;

    @FindBy(xpath = "//button[@data-role='opc-continue']")
    private WebElement nextBtn;

    @FindBy(css = "body[class='checkout-index-index page-layout-checkout']")
    private WebElement mainBoyd;

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")
    private WebElement placeOrderBtn;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    private WebElement purchaseMessage;







    public void selectPurchase() {

        womenBtn.click();
        actionMethod(brasAndTanksBtn);

        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("window.scrollBy(0,500)");

        waitUntilClickable(selectItem.get(6));
        waitUntilClickable(selectSize.get(1));
        selectColor.click();
        waitUntilClickable(addToCartBtn);
    }
    public void validationAddToCartMessage(){

        waitUntilClickable(validationAddToCart);
        Assert.assertTrue(validationAddToCart.isDisplayed());
        Assert.assertTrue(validationAddToCart.getText().contains("added".toLowerCase()));

    }


    public void proceedToCheckout()  {

        cartBtn.click();
        proceedToCheckoutBtn.click();
        radioBtnOne.click();
        nextBtn.click();


        wait.until(ExpectedConditions.attributeContains(mainBoyd,"aria-busy","false"));

        BaseDriver.wait(3);
        Actions actions = new Actions(BaseDriver.getDriver());
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn))).click().build().perform();



    }

    public void successPurchaseMessage(){

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertTrue(purchaseMessage.isDisplayed());
        Assert.assertTrue(purchaseMessage.getText().toLowerCase().contains("Thank you".toLowerCase()));
    }
}
