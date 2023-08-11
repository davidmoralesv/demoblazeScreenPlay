package org.Questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.userInterface.LandingPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateCategoryQuestion implements Question<Boolean> {

    private final String category;

    public ValidateCategoryQuestion(String category) {

        this.category = category;
    }

    public static ValidateCategoryQuestion verify(String category) {

        return new ValidateCategoryQuestion(category);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String PHONE = "Samsung galaxy";
        String LAPTOP = "Dell";
        String MONITOR = "monitor";
        boolean isCategoryVisible = false;

        switch (category) {
            case "Phones":
                actor.attemptsTo(WaitUntil.the(LandingPage.CATEGORY_VERIFICATION, isVisible()));
                isCategoryVisible = LandingPage.CATEGORY_VERIFICATION.resolveAllFor(actor).map(WebElementFacade::getText).stream().anyMatch(p -> p.contains(PHONE));
                break;

            case "Laptops":
                actor.attemptsTo(WaitUntil.the(LandingPage.CATEGORY_VERIFICATION, isVisible()));
                isCategoryVisible = LandingPage.CATEGORY_VERIFICATION.resolveAllFor(actor).map(WebElementFacade::getText).stream().anyMatch(p -> p.contains(LAPTOP));
                break;

            case "Monitors":
                actor.attemptsTo(WaitUntil.the(LandingPage.CATEGORY_VERIFICATION, isVisible()));
                isCategoryVisible = LandingPage.CATEGORY_VERIFICATION.resolveAllFor(actor).map(WebElementFacade::getText).stream().anyMatch(p -> p.contains(MONITOR));
                break;
        }
        return isCategoryVisible;
    }
}