package com.koala.sloth.Database.Dao.Item;

import android.graphics.Bitmap;

public class OrderProduct {
    private final Bitmap picture;
    private final String name;
    private final String category;
    private final double price;
    private final String priceUnit;
    private final String physicalUnit;

    private int quantity;



    public OrderProduct(String nameP, String categoryP, double priceP, String priceUnitP, String physicalUnitP, Bitmap pictureP) {
        picture = pictureP;
        name = nameP;
        category = categoryP;
        price = priceP;
        priceUnit = priceUnitP;
        physicalUnit = physicalUnitP;
    }

    public Bitmap getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
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

    public void setQuantity(int quantity) {
         this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getTotalPriceString() {
        return quantity*price +" "+ priceUnit;
    }
    public String getTotalPricePerUnit() {
        return price +"/"+ physicalUnit;
    }

}
