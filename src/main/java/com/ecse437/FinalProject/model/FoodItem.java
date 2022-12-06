package com.ecse437.FinalProject.model;

import java.util.Date;

public class FoodItem extends InventoryItem{

    private int calories;
    private Date expirationDate;

    public FoodItem(String pDescription, String pBrandName, String pProductName, double pPrice, int pCalories, Date pExpirationDate) {
        super(pDescription, pBrandName, pProductName, pPrice);
        calories = pCalories;
        expirationDate = pExpirationDate;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
