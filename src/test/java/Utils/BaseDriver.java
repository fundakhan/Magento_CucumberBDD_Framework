package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        // if the driver object is equal to null (there is no active driver instance) then we'll create a new driver

        if (driver == null){


            // terminaldeki kirmizi uyari yazilarini kaldirmak icin yaptik
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY,"Error"); // terminalde ilk basta cikan kirmizi iki satirlik uyari yazisini kaldirmak icin kullandik
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {
            driver.quit();
            driver = null; // if we don't have this line next scenario will fail
            // after driver.quit we need to set driver object to null
        }
    }

    public static void wait(int second){

        try {
            Thread.sleep(second* 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
