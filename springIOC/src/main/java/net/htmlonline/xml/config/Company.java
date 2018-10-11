package net.htmlonline.xml.config;

import org.springframework.beans.factory.annotation.Value;

public class Company {
    private int age;
    private String name;

    @Value("9000")
    public void setAge(int age) {
        this.age = age;
    }

    @Value("Aaa")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
