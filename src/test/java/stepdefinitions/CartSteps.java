package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.tasks.VerifyProductsOnCartTask;
import org.userInterface.LandingPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CartSteps {
    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("^user clicks on Cart Menu$")
    public void userClicksOnCartMenu() {
        OnStage.theActor("usuario").attemptsTo(Click.on(LandingPage.CART_MENU));
    }

    @Then("^user verifies products in cart$")
    public void verifyProductsInCart() {
        OnStage.theActor("usuario").attemptsTo(VerifyProductsOnCartTask.verify());
    }

    @And("^user returns to landing page$")
    public void clickOnProductStore() {
        OnStage.theActor("usuario").attemptsTo(Click.on(LandingPage.PRODUCT_STORE_NAME),
                WaitUntil.the(LandingPage.CONTENEDOR, isVisible()));
    }
}
