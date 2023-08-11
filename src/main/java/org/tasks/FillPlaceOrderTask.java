package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.model.PlaceOrder;
import org.userInterface.CheckoutPage;

public class FillPlaceOrderTask implements Task {
    private String field;
    private String value;

    public FillPlaceOrderTask(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public static FillPlaceOrderTask fill(String field, String value) {
        return Tasks.instrumented(FillPlaceOrderTask.class, field, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (field) {
            case "name":
                PlaceOrder.setName(value);
                break;
            case "card":
                PlaceOrder.setCardNumber(value);
                break;
        }

        actor.attemptsTo(Enter.theValue(value).into(CheckoutPage.PLACE_ORDER_TEXTBOX.of(field)));
    }
}
