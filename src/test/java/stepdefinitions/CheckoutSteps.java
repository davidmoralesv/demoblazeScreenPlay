package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.tasks.LoginUserNameAndPassword;
import org.userInterface.LoginPage;
import org.utils.EnumUserType;

public class CheckoutSteps {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("user inputs (.*) as Username and inputs (.*) as Password on login field")
    public void userFillLoginBox(String username, String password) {
        OnStage.theActor("usuario").attemptsTo(LoginUserNameAndPassword.execute(EnumUserType.BY_PARAMETERS, username, password));
    }

    @And("user click Log in button")
    public void userClickLogInButton() throws InterruptedException {
        OnStage.theActor("usuario").attemptsTo(Click.on(LoginPage.LOGIN_BUTTON));
    }
}
