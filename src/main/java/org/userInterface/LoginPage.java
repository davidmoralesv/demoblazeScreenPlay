package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {
    public static Target LOGIN_MENU_BUTTON = Target.the("Login Menu Button").located(By.xpath("//a[.='Log in']"));
    public static Target USER_NAME_LOGIN_TEXTBOX = Target.the("Username Login Textbox").located(By.xpath("//input[@id='loginusername']"));
    public static Target PASSWORD_LOGIN_TEXTBOX = Target.the("Password Login Textbox").located(By.xpath("//input[@id='loginpassword']"));
    public static Target LOGIN_BUTTON = Target.the("Login Button").located(By.xpath("//button[.='Log in']"));
    public static Target LOGIN_SUCCESS_VERIFICATION = Target.the("Login Success Verification").located(By.xpath("//a[@id='cat']"));


}
