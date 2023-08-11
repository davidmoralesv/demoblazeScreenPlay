package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductDescriptionPage extends PageObject {
    public static Target SONY_VAIO_I5_ADD_TO_CART_BUTTON = Target.the("Sony VAIO I5 Add to Cart Button").located(By.xpath("//a[@id='nava']"));
}
