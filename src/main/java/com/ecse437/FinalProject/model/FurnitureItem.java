package com.ecse437.FinalProject.model;

public class FurnitureItem extends InventoryItem{

    private String material;
    private String dimensions;

    public FurnitureItem(String pDescription, String pBrandName, String pProductName, double pPrice, String pMaterial, String pDimensions) {
        super(pDescription, pBrandName, pProductName, pPrice);
        material = pMaterial;
        dimensions = pDimensions;
    }

    public FurnitureIteem()
    {
        super()
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
