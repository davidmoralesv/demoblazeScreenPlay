package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.userInterface.LoginPage;

public class VerifyLoginSuccessTask implements Task {

    public static VerifyLoginSuccessTask verify() {
        return Tasks.instrumented(VerifyLoginSuccessTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Ensure.that(theSuccessVerificationIsVisible()).isTrue();
    }

    private Question<Boolean> theSuccessVerificationIsVisible() {
        return actor -> LoginPage.WELCOME_ANCHOR.resolveFor(actor).isCurrentlyVisible();
    }
}
