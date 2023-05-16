package Runners;

import Utils.BaseDriver;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Smoke",
        features = {"src/test/java/FeatureFile"},
        glue = {"StepDefinition"}

)
@Listeners({ExtentITestListenerClassAdapter.class})
public class Smoke_ExtentReport extends AbstractTestNGCucumberTests {


        @BeforeClass(alwaysRun = true)
        @Parameters(value = "browser")
        public void beforeClass(String browserName){
            BaseDriver.getDriver(); // call the setThreadBrowserName method to set the browser

        }

        @AfterClass
        public static void writeExtentReport(){

            ExtentService.getInstance().setSystemInfo("Username", "Funda Akhan");
            ExtentService.getInstance().setSystemInfo("Application Name", "Campus App");
            ExtentService.getInstance().setSystemInfo("Operating System", System.getProperty("os.name").toString());
            ExtentService.getInstance().setSystemInfo("Department", "QA");
            ExtentService.getInstance().setSystemInfo("Additional Line", "Description");

        }
}
