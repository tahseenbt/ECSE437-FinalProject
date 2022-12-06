package com.ecse437.FinalProject.controller;

import com.ecse437.FinalProject.driver.Inventory;
import com.ecse437.FinalProject.model.InventoryItem;
import com.ecse437.FinalProject.model.Receipt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/buy")
public class BuyItemController {


    @GetMapping("/{brandName}/{productName}")
    public Receipt buyItem(@PathVariable String brandName, @PathVariable String productName)
    {
        // will give you a receipt
        // will indicate price of the item if it is available
        // if not available, the receipt will say "OUT OF STOCK" with a price of zero
        for (InventoryItem cur : Inventory.getInstance().getAvailableItems())
        {
            if (cur.getBrandName() .equals(brandName) && cur.getProductName().equals(productName))
            {
                // remove item from inventory and return the receipt
                Inventory.getInstance().getAvailableItems().remove(cur);
                String itemPrice = String.valueOf(cur.getPrice());
                Receipt rec = new Receipt(itemPrice);
                return rec;
            }
        }
        // didn't find the item available, so we need to return a receipt that indicates the item was out of stock
        return new Receipt("OUT OF STOCK");
    }




}
