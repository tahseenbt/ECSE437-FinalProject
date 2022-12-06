package com.ecse437.FinalProject.model;

public class ToolItem extends InventoryItem{

    private String material;
    private int weight;

    public ToolItem(String pDescription, String pBrandName, String pProductName, double pPrice, String pMaterial, int pWeight) {
        super(pDescription, pBrandName, pProductName, pPrice);
        material = pMaterial;
        weight = pWeight;
    }

    public ToolItem()
    {
        super();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}