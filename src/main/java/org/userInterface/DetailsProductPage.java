package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DetailsProductPage extends PageObject {
    public static Target ITEM_NAME = Target.the("{0} name in Details Product").locatedBy("//div[@id='tbodyid']/h2[contains(text(),'{0}')]");
    public static Target ADD_TO_CART_BUTTON = Target.the("Add to cart button").located(By.xpath("//a[contains(@onclick,'addToCart')]"));
    public static Target PRODUCT_NAME = Target.the("Product name").located(By.xpath("//h2[@class='name']"));
    public static Target PRODUCT_VALUE = Target.the("Product value").located(By.xpath("//h3[@class='price-container']"));
}
