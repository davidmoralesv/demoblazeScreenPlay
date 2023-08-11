package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage extends PageObject {
    public static Target PLACE_ORDER_BUTTON = Target.the("Place Order Button").located(By.xpath("//button[@class='btn btn-success']"));
    public static Target PLACE_ORDER_POPUP = Target.the("Place Order Popup").located(By.xpath("//h5[@id='orderModalLabel']"));
    public static Target NAME_PLACE_ORDER_BOX = Target.the("Name Place Order Box").located(By.xpath("//input[@id='name']"));
    public static Target CREDIT_CARD_PLACE_ORDER_BOX = Target.the("Credit Card Place Order Box").located(By.xpath("//input[@id='card']"));
    public static Target PURCHASE_BUTTON = Target.the("Purchase Button").located(By.xpath("//h2[.='Thank you for your purchase!']"));
    public static Target THANK_YOU_PURCHASE_POPUP = Target.the("Thank You Purchase Popup").located(By.xpath("#"));
    public static Target DELETE_ITEM_BUTTON = Target.the("Delete Item Button").located(By.xpath("//a[.='Delete']"));

}
