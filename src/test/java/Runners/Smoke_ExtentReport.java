package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",
        features = {"src/test/java/FeatureFile"},
        glue = {"StepDefinition"}

)

public class Smoke_ExtentReport extends AbstractTestNGCucumberTests {
}
