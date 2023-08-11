package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.Exceptions.DefaultNameNotFoundAssertionError;
import org.Questions.ValidateAlertQuestion;
import org.tasks.*;
import org.userInterface.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.utils.EnumUserType.NEW_USER;

public class SignUpSteps {
    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("^verification pop-up appears (.*) indicating successful registration$")
    public void verificationPopUpAppearsIndicatingSuccessfulRegistration(String text) {
        OnStage.theActor("usuario").should(GivenWhenThen.seeThat(ValidateAlertQuestion.verify(text))
                .orComplainWith(DefaultNameNotFoundAssertionError.class, DefaultNameNotFoundAssertionError.INVALID_NAME));
    }

    @And("^verification pop-up appears (.*) indicating failed registration$")
    public void verificationPopUpAppearsIndicatingFailedRegistration(String text) {
        OnStage.theActor("usuario").should(GivenWhenThen.seeThat(ValidateAlertQuestion.verify(text))
                .orComplainWith(DefaultNameNotFoundAssertionError.class, DefaultNameNotFoundAssertionError.INVALID_NAME));
    }

    @And("^user inputs a new user as Username and inputs a Password$")
    public void inputAsUsernameAndInputAsPassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPassword.executeType(NEW_USER));
    }


    @And("^The user has registered on the website$")
    public void inputUserRegisteredCredentialsOnLoginFields() {
        OnStage.theActor("usuario").attemptsTo(SignUp.click());
    }

    @Given("user already on landing page")
    public void userAlreadyOnLandingPage() {
        OnStage.theActor("usuario").attemptsTo(AbrirURL.click(), VerifyDemoblazePageVerification.verify());
    }

    @When("user click on Sign up menu button")
    public void userClickOnSignUpMenuButton() {
        OnStage.theActor("usuario").attemptsTo(ClickOnSignUpMenuButton.click());
    }

    @Then("user click Sign up button")
    public void userClickSignUpButton() {
        OnStage.theActor("usuario").attemptsTo(ClickOnSignUpButton.click());
    }

    @When("user click on Log in menu button")
    public void userClickOnLogInMenuButton() {
        OnStage.theActor("usuario").attemptsTo(Click.on(LoginPage.LOGIN_MENU_BUTTON),
                WaitUntil.the(LoginPage.LOGIN_MENU_BUTTON, isVisible()));
    }
}
