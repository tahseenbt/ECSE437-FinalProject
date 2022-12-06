package com.ecse437.FinalProject.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Receipt {

    private String content; // what would be printed on receipt
    private Date dateOfPurchase;

    public Receipt(String pContent, Date pDateOfPurchase)
    {
        content = pContent;
        dateOfPurchase = pDateOfPurchase;
    }

    public Receipt()
    {}

    public Receipt(String pContent)
    {
        content = pContent;
        dateOfPurchase = new Date(); // sets to current date
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
