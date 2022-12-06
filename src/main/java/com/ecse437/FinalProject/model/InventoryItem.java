package com.ecse437.FinalProject.model;

public abstract class InventoryItem {

    private String description;
    private String brandName; // e.g. Heinz
    private String productName; // e.g. Ketchup
    private double price;
    // private int id; // this, in theory, is unique, but we are not really enforcing this. we should be careful with how we use it

    protected InventoryItem(String pDescription, String pBrandName, String pProductName, double pPrice)
    {
        description = pDescription;
        brandName = pBrandName;
        productName = pProductName;
        price = pPrice;
    }

    protected InventoryItem()
    {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
