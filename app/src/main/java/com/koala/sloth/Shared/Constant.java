package com.koala.sloth.Shared;

import com.koala.sloth.Database.Dao.Item.OrderProduct;

import java.util.ArrayList;

public class Constant {

    public static final String ORDER_CATEGORY_FRUIT = "Fruit";
    public static final String ORDER_CATEGORY_VEGETABLE= "Vegetable";
    public static final String ORDER_CATEGORY_MEAT = "Meat";
    public static final String ORDER_CATEGORY_DRINK = "Drink";
    public static final String ORDER_CATEGORY_NUT = "Nut";
    public static final String ORDER_CATEGORY_SPICE = "Spice";
    public static final String ORDER_CATEGORY_JUNK_FOOD = "Junk Food";
    public static final String ORDER_CATEGORY_CLEANING = "Cleaning";

    public static String currentOrderCategory = "";

    public static ArrayList<OrderProduct> basket;
    public static void addItemToBasket(OrderProduct newItem) {
        for (OrderProduct item: basket) {
            if (item.getName().equals(newItem.getName())) {
                item.setQuantity(newItem.getQuantity());
                return;
            }
        }

        basket.add(newItem);
    }
    public static void removeItemToBasket(String itemName) {
        OrderProduct item = null;
        for (OrderProduct product_item: basket) {
            if (product_item.getName().equals(itemName)) {
                item = product_item;
                break;
            }
        }

        if (item!=null)
            basket.remove(item);
    }
    public static int getTotalQuantity() {
        int totalQuantity = 0;
        for (OrderProduct product_item: basket) {
            totalQuantity = totalQuantity + product_item.getQuantity();
        }

        return totalQuantity;
    }
    public static double getTotalPrice() {
        double totalPrice = 0;
        for (OrderProduct product_item: basket) {
            totalPrice = totalPrice + product_item.getQuantity()*product_item.getPrice();
        }

        return totalPrice;
    }

}
