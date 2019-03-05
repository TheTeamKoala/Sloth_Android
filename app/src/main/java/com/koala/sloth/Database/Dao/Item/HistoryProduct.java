package com.koala.sloth.Database.Dao.Item;

public class HistoryProduct {
    private final String name;
    private double price;
    private final String priceUnit;
    private final String physicalUnit;
    private final int quantity;
    private final long date;



    public HistoryProduct(String nameP, double priceP, String priceUnitP, String physicalUnitP, int quantityP, long dateP) {
        name = nameP;
        price = priceP;
        priceUnit = priceUnitP;
        physicalUnit = physicalUnitP;
        quantity = quantityP;
        date = dateP;
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
    public long getDate() {
        return date;
    }

}
