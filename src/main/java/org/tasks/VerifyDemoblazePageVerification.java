package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.userInterface.LandingPage;

public class VerifyDemoblazePageVerification implements Task {
    public static VerifyDemoblazePageVerification verify() {
        return Tasks.instrumented(VerifyDemoblazePageVerification.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Ensure.that(theLandingPageIsVisible()).isTrue();
    }

    private Question<Boolean> theLandingPageIsVisible() {
        return actor -> LandingPage.DEMO_BLAZE_PAGE_VERIFICATION.resolveFor(actor).isCurrentlyVisible();
    }
}
