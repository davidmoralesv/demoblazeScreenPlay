package org.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private static final XProduct product = new XProduct();

    public static String getName() {
        return product.getName();
    }

    public static void setName(String name) {
        product.setName(name);
    }


    public static Double getPrice() {
        return product.getPrice();
    }

    public static void setPrice(Double precio) {
        product.setPrice(precio);
    }

    public static List<XProduct> products = new ArrayList<>();

}
