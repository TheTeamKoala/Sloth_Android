package com.koala.sloth.TabOrder;

import android.graphics.drawable.Drawable;

public class Product_ListView_Item {
    private final Drawable picture;
    private final String name;
    private final double price;
    private final String priceUnit;
    private final String physicalUnit;
    private int number;



    public Product_ListView_Item(Drawable pictureP, String nameP, double priceP,  String priceUnitP, String physicalUnitP) {
        picture = pictureP;
        name = nameP;
        price = priceP;
        priceUnit = priceUnitP;
        physicalUnit = physicalUnitP;
        number = 0;
    }

    Drawable getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }
    double getPrice() {
        return price;
    }
    String priceUnitP() {
        return priceUnit;
    }
    String getPhysicalUnit() {
        return physicalUnit;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
