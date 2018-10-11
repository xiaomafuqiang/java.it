package net.htmlonline.di;

public class Car {
    private String name;
    private Double price;

    public int getInt() {
        return ((int) (Math.random() * 9000));
    }
    public Car() {
    }

    public Car(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
