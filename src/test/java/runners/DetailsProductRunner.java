package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/D_DetailsProduct.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class DetailsProductRunner {
}
