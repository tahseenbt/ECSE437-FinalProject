package com.ecse437.FinalProject.model;

import java.util.Date;

public class ComputerItem extends ElectronicItem {

    private int ram; // ram in GB


    public ComputerItem(String pDescription, String pBrandName, String pProductName, double pPrice,
                        Date pWarrantyExpiration, int pRam) {
        super(pDescription, pBrandName, pProductName, pPrice, pWarrantyExpiration);
        this.ram = pRam;
    }

    public ComputerItem()
    {
        super();
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

}