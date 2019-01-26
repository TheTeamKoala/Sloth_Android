package com.koala.sloth.TabOrder;

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

    Drawable getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    String getPriceUnit() {
        return priceUnit;
    }
    String getPhysicalUnit() {
        return physicalUnit;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    String getTotalPriceString() {
        return quantity*price +" "+ priceUnit;
    }
    String getTotalPricePerUnit() {
        return price +"/"+ physicalUnit;
    }

}
