package org.model;

public class User {
    private static final XUser user = new XUser();


    public static String getUsername() {
        return user.getUsername();
    }

    public static String getPassword() {
        return user.getPassword();
    }


    public static void setUsername(String username) {
        user.setUsername(username);
    }

    public static void setPassword(String password) {
        user.setPassword(password);
    }


}
