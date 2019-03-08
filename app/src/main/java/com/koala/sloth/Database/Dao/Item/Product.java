package com.koala.sloth.Database.Dao.Item;

import android.graphics.Bitmap;

public class Product {
    private final int id;
    private final String name;
    private final String brand;
    private final String category;
    private final float price;
    private final String priceUnit;
    private final String physicalUnit;
    private final long firstDate;
    private final int inFridge; //  0 = false    1 = true
    private final Bitmap picture;

    private int quantity;



    public Product(int idP, String nameP, String brandP, String categoryP, float priceP, String priceUnitP, String physicalUnitP,  long firstDateP,  int inFridgeP, Bitmap pictureP) {
        id = idP;
        name = nameP;
        brand = brandP;
        category = categoryP;
        price = priceP;
        priceUnit = priceUnitP;
        physicalUnit = physicalUnitP;
        firstDate = firstDateP;
        inFridge = inFridgeP;
        picture = pictureP;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public String getCategory() {
        return category;
    }
    public float getPrice() {
        return price;
    }
    public String getPriceUnit() {
        return priceUnit;
    }
    public String getPhysicalUnit() {
        return physicalUnit;
    }
    public long getFirstDate() {
        return firstDate;
    }
    public int isInFridge() {
        return inFridge;
    }
    public Bitmap getPicture() {
        return picture;
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
