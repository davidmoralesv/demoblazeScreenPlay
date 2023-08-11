package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.model.User;
import org.userInterface.LandingPage;
import org.utils.Utilities;

public class SignUpUserNameAndPassword implements Task {

    public static SignUpUserNameAndPassword signUp() {
        return Tasks.instrumented(SignUpUserNameAndPassword.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String username = Utilities.getRandomString(10);
        User.setUsername(username);
        User.setPassword(username);
        actor.attemptsTo(SendKeys.of(username).into(LandingPage.USERNAME_TEXTBOX),
                SendKeys.of(username).into(LandingPage.PASSWORD_TEXTBOX));
    }
}
