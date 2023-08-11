package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.userInterface.LandingPage;

public class ClickOnSignUpMenuButton implements Task {

    public static ClickOnSignUpMenuButton click() {
        return Tasks.instrumented(ClickOnSignUpMenuButton.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LandingPage.SIGN_UP_MENU_BUTTON));
    }
}
