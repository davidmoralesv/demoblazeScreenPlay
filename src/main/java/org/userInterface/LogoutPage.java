package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LogoutPage extends PageObject {

    public static Target LOGOUT_BUTTON = Target.the("LogOut Button").located(By.xpath("//a[.='Log out']"));
    public static Target LOGOUT_SUCCESS_VERIFICATION = Target.the("LogOut Success Verification").located(By.xpath("//a[@id='cat']"));
}
