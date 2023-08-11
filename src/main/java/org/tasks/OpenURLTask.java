package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.userInterface.LandingPage;
import org.utils.AppConfiguration;

import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenURLTask implements Task {

    public static OpenURLTask click() {
        return Tasks.instrumented(OpenURLTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.wasAbleTo(Open.url(AppConfiguration.getURL()), WaitUntil.the(LandingPage.CONTENEDOR, isVisible()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
