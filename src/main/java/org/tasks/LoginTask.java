package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.userInterface.LoginPage;
import org.utils.EnumUserType;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    public static LoginTask execute() {
        return Tasks.instrumented(LoginTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPage.LOGIN_MENU_BUTTON),
                WaitUntil.the(LoginPage.LOGIN_MENU_BUTTON, isVisible()),
                LoginUserNameAndPasswordTask.executeType(EnumUserType.REGISTERED),
                Click.on(LoginPage.LOGIN_BUTTON));
    }
}
