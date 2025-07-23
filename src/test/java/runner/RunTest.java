package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import  io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDef", "hooks"},
        tags = "@All",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class RunTest {
}
