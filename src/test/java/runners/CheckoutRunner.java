package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/F_Checkout.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/report/cucumber-reports.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CheckoutRunner {
}
