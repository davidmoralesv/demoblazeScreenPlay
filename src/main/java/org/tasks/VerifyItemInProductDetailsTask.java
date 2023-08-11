package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.userInterface.DetailsProductPage;

public class VerifyItemInProductDetailsTask implements Task {

    private final String itemName;

    public VerifyItemInProductDetailsTask(String itemName) {
        this.itemName = itemName;
    }

    public static VerifyItemInProductDetailsTask verify(String itemName) {
        return Tasks.instrumented(VerifyItemInProductDetailsTask.class, itemName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Ensure.that(theItemNameIsVisible()).isTrue());
    }

    private Question<Boolean> theItemNameIsVisible() {
        return actor -> DetailsProductPage.ITEM_NAME.of(itemName).resolveFor(actor).isCurrentlyVisible();
    }

}
