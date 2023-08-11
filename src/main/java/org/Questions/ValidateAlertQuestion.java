package org.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.utils.WaitTimeUnit;

import java.util.concurrent.TimeUnit;

public class ValidateAlertQuestion implements Question<Boolean> {

    private final String text;

    public ValidateAlertQuestion(String text) {
        this.text = text;
    }

    public static ValidateAlertQuestion verify(String text)
    {
        return new ValidateAlertQuestion(text);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        new WaitTimeUnit(TimeUnit.SECONDS).waiting(3);
        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Boolean isEqualText = alertText.equals(this.text);
        alert.accept();
        return isEqualText;
    }
}
