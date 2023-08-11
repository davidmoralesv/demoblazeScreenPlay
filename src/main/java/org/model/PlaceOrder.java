package org.model;

public class PlaceOrder {
    private static final XPlaceOrder placeOrder = new XPlaceOrder();

    public static String getCardNumber() {
        return placeOrder.getCardNumber();
    }

    public static void setCardNumber(String cardNumber) {
        placeOrder.setCardNumber(cardNumber);
    }

    public static String getName() {
        return placeOrder.getName();
    }

    public static void setName(String name) {
        placeOrder.setName(name);
    }

}
