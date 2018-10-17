package net.htmlonline.domain.onetoone;

import java.util.Date;

public class Orderm {
    private int oid;
    private String name;
    private Date dates;
    private Double money;
    private Userm userm;

    @Override
    public String toString() {
        return "Orderm{" +
                "oid=" + oid +
                ", name='" + name + '\'' +
                ", dates=" + dates +
                ", money=" + money +
                ", userm=" + userm +
                '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public Userm getUserm() {
        return userm;
    }

    public void setUserm(Userm userm) {
        this.userm = userm;
    }
}
