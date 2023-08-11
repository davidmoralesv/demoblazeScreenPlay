package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.userInterface.LandingPage;

public class ClickOnSignUpButton implements Task {
    public static ClickOnSignUpButton click() {
        return Tasks.instrumented(ClickOnSignUpButton.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(LandingPage.SIGNUP_BUTTON));
    }
}
