package com.koala.sloth.ServerConnection;


public class Order {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private long date;

    private Product product;

    public Order(){

    }
    public Order(int productIdP, int quantityP, long dateP, Product productP) {
        productId = productIdP;
        quantity = quantityP;
        date = dateP;

        product = productP;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
