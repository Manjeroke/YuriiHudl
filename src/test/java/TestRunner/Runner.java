package TestRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features/Login.feature",
        glue = "stepDefinitions"
)
public class Runner {

}
