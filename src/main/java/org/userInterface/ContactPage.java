package org.userInterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContactPage extends PageObject {

    public static Target CONTACT_BUTTON = Target.the("Contact Button").located(By.xpath("//a[.='Contact']"));
    public static Target POPUP_MESSAGE_VERIFICATION = Target.the("Popup Message Verification").located(By.xpath("//h5[@id='exampleModalLabel']"));
    public static Target EMAIL_NEW_MESSAGE_BOX = Target.the("Email New Message Box").located(By.xpath("//input[@id='recipient-email']"));
    public static Target NAME_NEW_MESSAGE_BOX = Target.the("Name New Message Box").located(By.xpath("//input[@id='recipient-name']"));
    public static Target MESSAGE_NEW_MESSAGEBOX = Target.the("Message New MessageBox").located(By.xpath("//textarea[@id='message-text']"));
    public static Target SEND_MESSAGE_BUTTON = Target.the("Send Message Button").located(By.xpath("//button[.='Send message']"));
    public static Target FAILED_SEND_MESSAGE_VERIFICATION = Target.the("Failed Send Message verification").located(By.xpath("//div[@id='logInModal']//button[@class='btn btn-secondary']"));


}
