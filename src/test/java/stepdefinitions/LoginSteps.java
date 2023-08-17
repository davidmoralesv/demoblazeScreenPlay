package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.Exceptions.DefaultNameNotFoundAssertionError;
import org.Questions.ValidateAlertQuestion;
import org.tasks.LoginTask;
import org.tasks.LoginUserNameAndPasswordTask;
import org.tasks.VerifyLoginSuccessTask;
import org.userInterface.LoginPage;
import org.utils.EnumUserType;

public class LoginSteps {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    @When("^user clicks on the login menu$")
    public void userClicksOnTheLoginMenu() {
        OnStage.theActor("usuario").attemptsTo(Click.on(LoginPage.LOGIN_MENU_BUTTON));
    }

    @And("^user clicks on the Log button$")
    public void userClicksOnTheLogbutton() {
        OnStage.theActor("usuario").attemptsTo(Click.on(LoginPage.LOGIN_BUTTON));
    }

    @And("user verifies the successful login")
    public void userLoginSuccessfully() {
        OnStage.theActor("usuario").attemptsTo(VerifyLoginSuccessTask.verify());
    }

    @And("^user inputs registered username and registered password$")
    public void userInputsRegisteredUsernameAndpassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPasswordTask.executeType(EnumUserType.REGISTERED));
    }

    @When("^user inputs registered username and registered password and validate session$")
    public void userInputsRegisteredCredentialsAndValidateSession() {
        OnStage.theActor("usuario").attemptsTo(LoginTask.execute());
    }

    @And("^user inputs wrong username and inputs password$")
    public void userInputsUsernameWrongAndInputsPassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPasswordTask.executeType(EnumUserType.WRONG_USERNAME));
    }

    @And("^user inputs username and inputs wrong password$")
    public void userInputsUsernameAndInputsWrongPassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPasswordTask.executeType(EnumUserType.WRONG_PASSWORD));
    }

    @And("^pop up is showed with message (.*)$")
    public void popUpShowedWithMessage(String text) {
        OnStage.theActor("usuario").should(GivenWhenThen.seeThat(ValidateAlertQuestion.verify(text))
                .orComplainWith(DefaultNameNotFoundAssertionError.class, DefaultNameNotFoundAssertionError.INVALID_NAME));
    }


}
