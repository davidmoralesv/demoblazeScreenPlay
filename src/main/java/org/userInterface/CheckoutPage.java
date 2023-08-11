package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage extends PageObject {
    public static Target SONY_VAIO_I5 = Target.the("Sony Vaio I5").located(By.xpath("//a[.='Sony vaio i5']"));
    public static Target CART_MENU_BUTTON = Target.the("Cart Menu Button").located(By.xpath("//a[@id='cartur']"));
    public static Target SAMSUNG_GALAXY_S6_BUTTON = Target.the("Samsung Galaxy S6 Button").located(By.xpath("//a[.='Samsung galaxy s6']"));


}
