package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.tasks.FillPlaceOrderTask;
import org.tasks.VerifyDataInThankYouForYourPurchaseTask;
import org.userInterface.CartPage;
import org.userInterface.CheckoutPage;
import org.userInterface.LandingPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckoutSteps {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that user already is on Place Order$")
    public void userAlreadyIsOnPlaceOrder() {
        OnStage.theActor("usuario").attemptsTo(WaitUntil.the(CheckoutPage.PURCHASE_BUTTON, isClickable()));
    }

    @And("^user clicks on Place Order button$")
    public void clicksOnPlaceOrderButton() {
        OnStage.theActor("usuario").attemptsTo(Click.on(CartPage.PLACE_ORDER_BUTTON));
    }

    @And("^user fills the (.*) field with the value (.*)$")
    public void fillInputTextInForm(String field, String value) {
        OnStage.theActor("usuario").attemptsTo(FillPlaceOrderTask.fill(field, value));
    }

    @And("^user clicks on Purchase button$")
    public void clickOnPurchaseButton() {
        OnStage.theActor("usuario").attemptsTo(Click.on(CheckoutPage.PURCHASE_BUTTON));
    }

    @And("^user validates the data in the successful popup$")
    public void userValidateConfirmationMessage() {
        OnStage.theActor("usuario").attemptsTo(VerifyDataInThankYouForYourPurchaseTask.verify());
    }

    @And("^user clicks on OK button$")
    public void clicksOnOKButton() {
        OnStage.theActor("usuario").attemptsTo(Click.on(CheckoutPage.OK_BUTTON));
    }

    @And("^user verifies page returns to landing page$")
    public void userVerifiesPageReturnsToLandingPage() {
        OnStage.theActor("usuario").attemptsTo(WaitUntil.the(LandingPage.PRODUCT_STORE_NAME, isVisible()));
    }
}



