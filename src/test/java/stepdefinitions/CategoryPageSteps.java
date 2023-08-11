package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.Exceptions.DefaultNameNotFoundAssertionError;
import org.Questions.ValidateCategoryQuestion;
import org.tasks.ClickOnProductFromTheListTask;
import org.tasks.VerifyItemInProductDetailsTask;
import org.userInterface.LandingPage;

public class CategoryPageSteps {
    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^click on (.*) button on the category field$")
    public void clickOnCategoryField(String category) {
        OnStage.theActor("usuario").attemptsTo(Click.on(LandingPage.CATEGORY_BUTTON.of(category)));
    }

    @And("^The list of (.*) will show up$")
    public void productsWillShowedUp(String category) {
        OnStage.theActor("usuario").attemptsTo(Click.on(LandingPage.CATEGORY_BUTTON.of(category)));
        OnStage.theActor("usuario").should(GivenWhenThen.seeThat(ValidateCategoryQuestion.verify(category))
                .orComplainWith(DefaultNameNotFoundAssertionError.class, DefaultNameNotFoundAssertionError.INVALID_NAME));
    }

    @And("^user clicks on item (.*)$")
    public void userClickOnItem(String item) {
        OnStage.theActor("usuario").attemptsTo(ClickOnProductFromTheListTask.click(item),
                VerifyItemInProductDetailsTask.verify(item));
    }
}
