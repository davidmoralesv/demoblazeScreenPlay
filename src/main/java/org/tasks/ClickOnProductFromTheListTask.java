package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.userInterface.LandingPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnProductFromTheListTask implements Task {

    private final String item;

    public ClickOnProductFromTheListTask(String item) {
        this.item = item;
    }

    public static ClickOnProductFromTheListTask click(String item) {
        return Tasks.instrumented(ClickOnProductFromTheListTask.class, item);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LandingPage.CONTENEDOR, isVisible()),
                Click.on(LandingPage.ITEM.of(item)));
    }
}
