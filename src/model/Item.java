package model;

import java.util.Date;

public class Item {

    public Item(int count, String itemName, double price, Date dealTime, String dealId) {
        this.count = count;
        this.itemName = itemName;
        this.price = price;
        this.dealTime = dealTime;
        this.dealId = dealId;
    }

    public int getCount() {
        return count;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    String dealId;

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    int count;
    String itemName;

    double price;

    Date dealTime;
}
