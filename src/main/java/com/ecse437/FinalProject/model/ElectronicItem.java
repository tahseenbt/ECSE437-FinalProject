package com.ecse437.FinalProject.model;

import java.util.Date;

public abstract class ElectronicItem extends InventoryItem {

    private Date warrantyExpiration;

    protected ElectronicItem(String pDescription, String pBrandName, String pProductName, double pPrice, Date pWarrantyExpiration) {
        super(pDescription, pBrandName, pProductName, pPrice);
        this.warrantyExpiration = pWarrantyExpiration;
    }
    protected ElectronicItem() // default constructor necessary for testing with Jackson
    {
        super();
    }

    public Date getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(Date warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }
}