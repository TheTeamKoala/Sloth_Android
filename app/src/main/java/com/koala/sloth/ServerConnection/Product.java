package com.koala.sloth.ServerConnection;

public class Product {
    private Integer id;
    private String name;


    private String brand;
    private String category;
    private double price;
    private String priceUnit;
    private String physicalUnit;
    private long firstDate;
    private int inFridge; //  0 = false    1 = true

    public Product() {
    }

    public Product(String name, String brand, String category, float price, String priceUnit, String physicalUnit, long firstDate, int inFridge) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.priceUnit = priceUnit;
        this.physicalUnit = physicalUnit;
        this.firstDate = firstDate;
        this.inFridge = inFridge;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhysicalUnit(String physicalUnit) {
        this.physicalUnit = physicalUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInFridge(int inFridge) {
        this.inFridge = inFridge;
    }

    public void setFirstDate(long firstDate) {
        this.firstDate = firstDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public double getPrice() {
        return price;
    }

    public String getPhysicalUnit() {
        return physicalUnit;
    }

    public String getName() {
        return name;
    }

    public int getInFridge() {
        return inFridge;
    }

    public long getFirstDate() {
        return firstDate;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }




}