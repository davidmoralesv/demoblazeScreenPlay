package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.model.PlaceOrder;
import org.userInterface.CheckoutPage;

public class VerifyDataInThankYouForYourPurchaseTask implements Task {

    public static VerifyDataInThankYouForYourPurchaseTask verify() {
        return Tasks.instrumented(VerifyDataInThankYouForYourPurchaseTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String textInSucessfulPopup = CheckoutPage.SUCCESSFUL_POPUP_MESSAGE.resolveFor(actor).getText();
        Ensure.that(textInSucessfulPopup.contains(PlaceOrder.getName())).isTrue();
        Ensure.that(textInSucessfulPopup.contains(PlaceOrder.getCardNumber())).isTrue();
    }
}
