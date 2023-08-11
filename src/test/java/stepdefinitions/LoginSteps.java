package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.Exceptions.DefaultNameNotFoundAssertionError;
import org.Questions.ValidateAlertQuestion;
import org.tasks.LoginSuccessVerification;
import org.tasks.LoginUserNameAndPassword;
import org.utils.EnumUserType;

public class LoginSteps {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("user login successfully")
    public void userLoginSuccessfully() {
        OnStage.theActor("usuario").attemptsTo(LoginSuccessVerification.verify());
    }

    @And("^user inputs registered username and registered password$")
    public void userInputsRegisteredUsernameAndpassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPassword.executeType(EnumUserType.REGISTERED));
    }

    @And("^user inputs wrong username and inputs password$")
    public void userInputsUsernameWrongAndInputsPassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPassword.executeType(EnumUserType.WRONG_USERNAME));
    }

    @And("^user inputs username and inputs wrong password$")
    public void userInputsUsernameAndInputsWrongPassword() {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPassword.executeType(EnumUserType.WRONG_PASSWORD));
    }

    @And("^pop up showed with message (.*)$")
    public void popUpShowedWithMessage(String text) {
        OnStage.theActor("usuario").should(GivenWhenThen.seeThat(ValidateAlertQuestion.verify(text))
                .orComplainWith(DefaultNameNotFoundAssertionError.class, DefaultNameNotFoundAssertionError.INVALID_NAME));
    }
}
