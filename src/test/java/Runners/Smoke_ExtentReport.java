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
        glue = {"StepDefinition"},
        plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}

)
//@Listeners({ExtentITestListenerClassAdapter.class})
public class Smoke_ExtentReport extends AbstractTestNGCucumberTests {



}
