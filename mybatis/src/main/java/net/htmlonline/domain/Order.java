package net.htmlonline.domain;

import java.util.Date;

public class Order {
    private int OId;
    private String name;
    private Date dates;
    private Double money;

    @Override
    public String toString() {
        return "Order{" +
                "OId=" + OId +
                ", name='" + name + '\'' +
                ", dates=" + dates +
                ", money=" + money +
                '}';
    }

    public int getOId() {
        return OId;
    }

    public void setOId(int OId) {
        this.OId = OId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
