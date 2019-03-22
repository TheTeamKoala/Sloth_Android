package com.koala.sloth.Shared;

import com.koala.sloth.Database.Dao.Item.Product;

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
    public static ArrayList<Product> basket;

}
