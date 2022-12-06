package com.ecse437.FinalProject.controller;

import com.ecse437.FinalProject.driver.Inventory;
import com.ecse437.FinalProject.model.InventoryItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/available")
public class AvailableInventoryController {

    /**
     *
     * @param brandName the brand name of the product we are looking for
     * @param productName the product name we are looking for
     * @return a list of available products with the indicated brand and product name
     */
    @GetMapping("/{brandName}/{productName}")
    public List<InventoryItem> getAvailableItems(@PathVariable String brandName, @PathVariable String productName)
    {
        ArrayList<InventoryItem> output = new ArrayList<>();
        // look through the inventory's available items
        for (InventoryItem item : Inventory.getInstance().getAvailableItems())
        {
            if (item.getBrandName().equals(brandName) && item.getProductName().equals(productName))
            {
                // we found an item that we want to return
                output.add(item);
            }
        }

        return output;
    }




}
