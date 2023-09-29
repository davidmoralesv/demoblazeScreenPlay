package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/A_SignUp.feature",
                "src/test/resources/features/B_Login.feature",
                "src/test/resources/features/C_Categories.feature",
                "src/test/resources/features/D_DetailsProduct.feature",
                "src/test/resources/features/E_Cart.feature",
                "src/test/resources/features/F_Checkout.feature"
        },
        glue = "stepdefinitions",

        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class AllRunner {
}
