package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.Exceptions.DefaultNameNotFoundAssertionError;
import org.Questions.ValidateAlertQuestion;

public class SignUp implements Task {

    public static SignUp click() {
        return Tasks.instrumented(SignUp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String text = "Sign up successful.";

        actor.attemptsTo(AbrirURL.click(), VerifyDemoblazePageVerification.verify(),
                ClickOnSignUpMenuButton.click(), SignUpUserNameAndPassword.signUp(),
                ClickOnSignUpButton.click());

        actor.should(GivenWhenThen.seeThat(ValidateAlertQuestion.verify(text))
                .orComplainWith(DefaultNameNotFoundAssertionError.class,
                        DefaultNameNotFoundAssertionError.INVALID_NAME));
    }
}
