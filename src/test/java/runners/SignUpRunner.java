package runners;

import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;


public class SignUpRunner {
    @Before
    public void test() {
        switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "ie":
            case "iexplorer":
                WebDriverManager.iedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
        }
    }

    @Test
    public void testRunner() {
        JUnitCore.runClasses(Runner.class);
    }

    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(features = "src/test/resources/features/A_SignUp.feature",
            glue = "stepdefinitions",
            plugin = {"pretty", "html:target/cucumber-reports.html"},
            monochrome = true,
            snippets = CucumberOptions.SnippetType.CAMELCASE)
    public class Runner {
    }
}