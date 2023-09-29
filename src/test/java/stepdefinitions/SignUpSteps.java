package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.Exceptions.DefaultNameNotFoundAssertionError;
import org.Questions.ValidateAlertQuestion;
import org.tasks.OpenURLTask;
import org.tasks.SignUpTask;
import org.userInterface.LandingPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SignUpSteps {
    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that user already is on landing page")
    public void userAlreadyOnLandingPage() {
        OnStage.theActor("usuario").attemptsTo(OpenURLTask.click(),
                WaitUntil.the(LandingPage.PRODUCT_STORE_NAME, isPresent()),
                WaitUntil.the(LandingPage.PRODUCT_STORE_NAME, isVisible()),
                WaitUntil.the(LandingPage.CONTENEDOR, isPresent()),
                WaitUntil.the(LandingPage.CONTENEDOR, isVisible()));
    }

    @When("user does Sign up")
    public void userDoesSignUp() {
        OnStage.theActor("usuario").attemptsTo(SignUpTask.click());
    }

    @Then("^verify that a pop-up appears (.*) indicating successful registration$")
    public void verificationPopUpAppearsIndicatingSuccessfulRegistration(String text) {
        OnStage.theActor("usuario").should(GivenWhenThen.seeThat(ValidateAlertQuestion.verify(text))
                .orComplainWith(DefaultNameNotFoundAssertionError.class, DefaultNameNotFoundAssertionError.INVALID_NAME));
    }
}
