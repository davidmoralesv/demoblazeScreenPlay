package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.model.User;
import org.userInterface.LandingPage;
import org.utils.Utilities;
import org.utils.WaitTimeUnit;

import java.util.concurrent.TimeUnit;

public class SignUpTask implements Task {

    public static SignUpTask click() {
        return Tasks.instrumented(SignUpTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String username = Utilities.getRandomString(10);

        actor.attemptsTo(Click.on(LandingPage.SIGN_UP_MENU_BUTTON));
        new WaitTimeUnit(TimeUnit.SECONDS).waiting(1);
        User.setUsername(username);
        User.setPassword(username);

        actor.attemptsTo(SendKeys.of(username).into(LandingPage.USERNAME_TEXTBOX),
                SendKeys.of(username).into(LandingPage.PASSWORD_TEXTBOX),
                Click.on(LandingPage.SIGNUP_BUTTON));


    }
}
