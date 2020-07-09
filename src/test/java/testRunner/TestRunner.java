package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = {"pretty"},
        tags =  "@DeletePlace"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
