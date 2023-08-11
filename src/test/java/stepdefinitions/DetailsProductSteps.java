package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.tasks.AddProductToCartTask;

public class DetailsProductSteps {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("^user clicks 'add to cart' button$")
    public void clickAddToCartButton() {
        OnStage.theActor("usuario").attemptsTo(AddProductToCartTask.add());
    }
}
