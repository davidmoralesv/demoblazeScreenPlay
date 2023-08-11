package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.model.XProduct;
import org.userInterface.DetailsProductPage;

import static org.model.Product.products;

public class AddProductToCartTask implements Task {

    public static AddProductToCartTask add() {
        return Tasks.instrumented(AddProductToCartTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        XProduct product = new XProduct();

        String name = DetailsProductPage.PRODUCT_NAME.resolveFor(actor).getText();
        product.setName(name);

        double price = Double.parseDouble(DetailsProductPage.PRODUCT_VALUE.resolveFor(actor).getText().replaceAll("[^0-9]", ""));
        product.setPrice(price);

        products.add(product);

        actor.attemptsTo(Click.on(DetailsProductPage.ADD_TO_CART_BUTTON));
    }
}
