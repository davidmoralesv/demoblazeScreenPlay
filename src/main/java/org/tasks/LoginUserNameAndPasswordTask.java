package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.model.User;
import org.userInterface.LoginPage;
import org.utils.EnumUserType;
import org.utils.Utilities;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginUserNameAndPasswordTask implements Task {

    private final String username;
    private final String password;

    private final EnumUserType userType;

    public LoginUserNameAndPasswordTask(EnumUserType userType, String username, String password) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public LoginUserNameAndPasswordTask(EnumUserType userType) {
        this.username = null;
        this.password = null;
        this.userType = userType;
    }

    public static LoginUserNameAndPasswordTask execute(EnumUserType userType, String username, String password) {
        return Tasks.instrumented(LoginUserNameAndPasswordTask.class, userType, username, password);
    }

    public static LoginUserNameAndPasswordTask executeType(EnumUserType userType) {
        return Tasks.instrumented(LoginUserNameAndPasswordTask.class, userType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()));
        final String WRONG = "wrong";
        switch (this.userType) {
            case NEW_USER:
                String username = Utilities.getRandomString(10);
                User.setUsername(username);
                User.setPassword(username);
                actor.attemptsTo(WaitUntil.the(LoginPage.USER_NAME_LOGIN_TEXTBOX, isVisible()),
                        SendKeys.of(User.getUsername()).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword()).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case REGISTERED:
                actor.attemptsTo(WaitUntil.the(LoginPage.USER_NAME_LOGIN_TEXTBOX, isVisible()),
                        SendKeys.of(User.getUsername()).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword()).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case BY_PARAMETERS:
                actor.attemptsTo(WaitUntil.the(LoginPage.USER_NAME_LOGIN_TEXTBOX, isVisible()),
                        SendKeys.of(this.username).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(this.password).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case WRONG_USERNAME:
                actor.attemptsTo(SendKeys.of(User.getUsername().concat(WRONG))
                                .into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword()).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case WRONG_PASSWORD:
                actor.attemptsTo(WaitUntil.the(LoginPage.USER_NAME_LOGIN_TEXTBOX, isVisible()),
                        SendKeys.of(User.getUsername()).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword().concat(WRONG)).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;
        }
    }
}
