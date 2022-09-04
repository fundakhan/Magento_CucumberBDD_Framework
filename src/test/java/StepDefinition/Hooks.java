package StepDefinition;

import Utils.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver = BaseDriver.getDriver();

    @Before  // this part before navigate is before each class
    public void setup(){

        driver.get("https://magento.softwaretestingboard.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Scenario Started!");

    }

    @After
    public void tearDown(){

        BaseDriver.quitDriver();


    }
}
