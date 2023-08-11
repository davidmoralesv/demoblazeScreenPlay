package org.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.model.User;
import org.userInterface.LoginPage;
import org.utils.EnumUserType;
import org.utils.Utilities;

public class LoginUserNameAndPassword implements Task {

    private final String username;
    private final String password;

    private final EnumUserType userType;


    public LoginUserNameAndPassword(EnumUserType userType, String username, String password) {
        this.username = username;
        this.password = password;
        this.userType = userType;

    }

    public LoginUserNameAndPassword(EnumUserType userType) {
        this.username = null;
        this.password = null;
        this.userType = userType;

    }

    public static LoginUserNameAndPassword execute(EnumUserType userType, String username, String password) {
        return Tasks.instrumented(LoginUserNameAndPassword.class, userType, username, password);
    }

    public static LoginUserNameAndPassword executeType(EnumUserType userType) {
        return Tasks.instrumented(LoginUserNameAndPassword.class, userType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        final String WRONG = "wrong";
        switch (this.userType) {
            case NEW_USER:
                String username = Utilities.getRandomString(10);
                User.setUsername(username);
                User.setPassword(username);
                actor.attemptsTo(SendKeys.of(username).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(username).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case REGISTERED:
                actor.attemptsTo(SendKeys.of(User.getUsername()).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword()).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case BY_PARAMETERS:
                actor.attemptsTo(SendKeys.of(this.username).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(this.password).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
                break;

            case WRONG_USERNAME:
                actor.attemptsTo(SendKeys.of(User.getUsername().concat(WRONG)).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword()).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));

                break;

            case WRONG_PASSWORD:
                actor.attemptsTo(SendKeys.of(User.getUsername()).into(LoginPage.USER_NAME_LOGIN_TEXTBOX),
                        SendKeys.of(User.getPassword().concat(WRONG)).into(LoginPage.PASSWORD_LOGIN_TEXTBOX));
        }

    }
}
