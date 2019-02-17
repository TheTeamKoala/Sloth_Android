package com.koala.sloth.TabHistory;

import java.util.Date;

public class History_Item {
    private final String name;
    private final double price;
    private final String priceUnit;
    private final String physicalUnit;
    private final int quantity;
    private final Date date;



    public History_Item(String nameP, double priceP, String priceUnitP, String physicalUnitP, int quantityP, Date dateP) {
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
    public Date getDate() {
        return date;
    }

}
