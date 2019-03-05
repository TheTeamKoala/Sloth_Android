package com.koala.sloth.TabFridge;

import android.graphics.drawable.Drawable;

public class Product_Item {
    private final Drawable picture;
    private final String name;
    private final double price;
    private final String priceUnit;
    private final String physicalUnit;
    private int quantity;



    public Product_Item(Drawable pictureP, String nameP, double priceP, String priceUnitP, String physicalUnitP) {
        picture = pictureP;
        name = nameP;
        price = priceP;
        priceUnit = priceUnitP;
        physicalUnit = physicalUnitP;
        quantity = 0;
    }

    public Drawable getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getPriceUnit() {
        return priceUnit;
    }
    public String getPhysicalUnit() {
        return physicalUnit;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTotalPriceString() {
        return quantity*price +" "+ priceUnit;
    }
    public String getTotalPricePerUnit() {
        return price +"/"+ physicalUnit;
    }

}
