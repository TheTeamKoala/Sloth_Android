package com.koala.sloth.Database.Dao.Item;

public class Order {
    private final int productId;
    private int quantity;
    private final long date;

    private final Product product;



    public Order(int productIdP, int quantityP, long dateP, Product productP) {
        productId = productIdP;
        quantity = quantityP;
        date = dateP;
        product = productP;
    }

    public int getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public long getDate() {
        return date;
    }
    public Product getProduct() {
        return product;
    }

}
