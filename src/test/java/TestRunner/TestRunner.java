package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/SuccessfulScenario.feature",
                glue = "stepDefinitions",
                dryRun = false,
                plugin = {"pretty", "html: target/test-output"}
        )
public class TestRunner {
}
