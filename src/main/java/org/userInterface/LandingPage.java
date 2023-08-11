package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LandingPage extends PageObject {

    public static Target DEMO_BLAZE_PAGE_VERIFICATION = Target.the("DemoBlaze Page Verification").located(By.xpath("//a[@id='nava']"));
    public static Target SIGN_UP_MENU_BUTTON = Target.the("Sign Up Menu Button").located(By.xpath("//a[.='Sign up']"));
    public static Target USERNAME_TEXTBOX = Target.the("Username Textbox").located(By.xpath("//input[@id='sign-username']"));
    public static Target PASSWORD_TEXTBOX = Target.the("Password Textbox").located(By.xpath("//input[@id='sign-password']"));
    public static Target SIGNUP_BUTTON = Target.the("Sign Up Button").located(By.xpath("//button[contains(text(),'Sign up')]"));
    public static Target CATEGORY_BUTTON = Target.the("Category Button").locatedBy("//a[.='{0}']");
    public static Target CATEGORY_VERIFICATION = Target.the("Category Verfication").located(By.cssSelector(".card-title"));
    public static Target LOGIN_TO_CART_VERIFICATION = Target.the("Login Popup verifications").located(By.xpath("//div[@id='logInModal']//label[.='Username:']"));
    public static Target CONTENEDOR = Target.the("Contenedor").located(By.xpath("//div[@id='contcont']"));


}
