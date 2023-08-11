package org.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.model.XProduct;
import org.userInterface.CartPage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.model.Product.products;

public class VerifyProductsOnCartTask implements Task {

    public static VerifyProductsOnCartTask verify() {
        return Tasks.instrumented(VerifyProductsOnCartTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> productNamesInCart = CartPage.PRODUCTNAMES.resolveAllFor(actor)
                .stream().map(WebElementFacade::getText).collect(Collectors.toList());

        List<String> productNamesAdded = products.stream().map(XProduct::getName)
                .collect(Collectors.toList());

        Ensure.that(validateLists(productNamesInCart, productNamesAdded)).isTrue();

        Double totalInCart = Double.parseDouble(CartPage.TOTAL.resolveFor(actor).getText());
        Double sumProducts = products.stream().mapToDouble(XProduct::getPrice).sum();

        Ensure.that(totalInCart).isEqualTo(sumProducts);
    }

    private static <T> boolean validateLists(List<T> lista1, List<T> lista2) {
        Set<T> setLista1 = new HashSet<>(lista1);
        Set<T> setLista2 = new HashSet<>(lista2);
        return setLista1.containsAll(setLista2) && setLista2.containsAll(setLista1);
    }
}
