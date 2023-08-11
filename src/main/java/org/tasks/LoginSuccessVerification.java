package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.userInterface.LoginPage;

public class LoginSuccessVerification implements Task {

    public static LoginSuccessVerification verify() {
        return Tasks.instrumented(LoginSuccessVerification.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Ensure.that(theSuccessVerificationIsVisible()).isTrue();
    }

    private Question<Boolean> theSuccessVerificationIsVisible() {
        return actor -> LoginPage.LOGIN_SUCCESS_VERIFICATION.resolveFor(actor).isCurrentlyVisible();
    }
}
