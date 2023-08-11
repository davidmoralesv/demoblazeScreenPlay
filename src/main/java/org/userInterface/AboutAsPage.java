package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AboutAsPage extends PageObject {
    public static Target ABOUT_US_BUTTON = Target.the("About Us Button").located(By.xpath("//a[.='About us']"));
    public static Target VIDEOS_BUTTON = Target.the("Videos Button").located(By.xpath("//div[@class='vjs-poster']"));
    public static Target VIDEOS_PLAYED_VERIFICATION = Target.the("Videos Played Verification").located(By.xpath("//video[@class='vjs-tech']"));


}
