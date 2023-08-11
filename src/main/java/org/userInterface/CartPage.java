package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage extends PageObject {
    public static Target PRODUCTNAMES = Target.the("Purchase Button").located(By.xpath("//tbody[@id='tbodyid']/tr/td[2]"));
    public static Target TOTAL = Target.the("Suma de valores de artículos").located(By.xpath("//h3[@id='totalp']"));
    public static Target PLACE_ORDER_BUTTON = Target.the("Place Holder Button").located(By.xpath("//button[@data-target='#orderModal']"));
}


