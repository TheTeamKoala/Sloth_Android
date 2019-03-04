package com.koala.sloth.ServerConnection;

public class Product {
    String type;
    String firstDate;
    Boolean bool;
    int price;

    public Product(String type,String firstDate,Boolean bool,int price){
        this.type = type;
        this.firstDate = firstDate;
        this.bool  = bool;
        this.price = price;
    }
    public Product(){

    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}