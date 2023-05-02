package POM;

import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePOM {

    WebDriver driver = BaseDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void waitUntilClickable(WebElement element){


        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();


    }

    public void scrollToElement(WebElement element){

     JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
     js.executeScript("argument[0].scrollIntoView();",element);

    }

    public void waitUntilVisible(WebElement element,String value){

        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void verifySuccessMessage(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains("successfully".toLowerCase()));


    }

    public void verifySavedAddress(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains("saved".toLowerCase()));

    }

    public void verifyPage(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains("New Address".toLowerCase()));


    }

    public void actionMethod(WebElement element){


        Actions actions = new Actions(BaseDriver.getDriver());
        actions.release(element).build().perform();
    }


}
