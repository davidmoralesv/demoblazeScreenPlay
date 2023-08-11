package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage extends PageObject {
    public static Target PLACE_ORDER_TEXTBOX = Target.the("Place order Textbox").locatedBy("//input[@id='{0}']");

    public static Target SUCCESSFUL_POPUP_MESSAGE = Target.the("Successful Popup Message").located(By.xpath("//p[contains(@class,'lead text-muted')]"));

    public static Target PURCHASE_BUTTON = Target.the("Purchase Button").located(By.xpath("//button[@onclick='purchaseOrder()']"));

    public static Target OK_BUTTON = Target.the("Ok Button").located(By.xpath("//button[text()='OK']"));
}
