package com.ecse437.FinalProject.driver;

import com.ecse437.FinalProject.model.FoodItem;
import com.ecse437.FinalProject.model.InventoryItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// will be used to model the inventory as a whole
// will be a singleton class
public class Inventory {

    private ArrayList<InventoryItem> availableItems;
    private static Inventory INSTANCE; // singleton instance -- we only need one at a time

    private Inventory()
    {
        // add some sample items to the available items list
        String expiry1 = "31-Dec-2022";
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date expiryDate1;
        try
            {
                expiryDate1 = formatter.parse(expiry1);
            }
        catch (ParseException e)
        {
            // failed to parse date, just let it be null
            expiryDate1 = null; // unecessary and done for readability
        }
        FoodItem item1 = new FoodItem("Hellman's famous mayonnaise--a classic.", "Hellman's", "Mayonnaise",
                8.50, 400, expiryDate1);

        // Create a second item
        String expiry2 = "18-Nov-2023";
        Date expiryDate2;
        try
        {
            expiryDate2 = formatter.parse(expiry1);
        }
        catch (ParseException e)
        {
            // failed to parse date, just let it be null
            expiryDate2 = null; // unecessary and done for readability
        }
        FoodItem item2 = new FoodItem("Hellman's famous mayonnaise--a classic.", "Hellman's", "Mayonnaise",
                8.50, 400, expiryDate2);

        // create a third item

        String expiry3 = "12-Oct-2026";
        Date expiryDate3;
        try
        {
            expiryDate3 = formatter.parse(expiry1);
        }
        catch (ParseException e)
        {
            // failed to parse date, just let it be null
            expiryDate3 = null; // unecessary and done for readability
        }
        FoodItem item3 = new FoodItem("Delicious fig cookies", "Nabisco", "Fig Newtons",
                4.50, 100, expiryDate3);

        // add items to available inventory
        availableItems.add(item1);
        availableItems.add(item2);
        availableItems.add(item3);


    }


    public static Inventory getInstance()
    {
        if (INSTANCE == null)
        {
            return new Inventory();
        }
        else
        {
            return INSTANCE;
        }
    }

    public ArrayList<InventoryItem> getAvailableItems() {
        return availableItems;
    }
}
