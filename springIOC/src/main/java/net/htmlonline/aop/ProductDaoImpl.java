package net.htmlonline.aop;

import org.springframework.stereotype.Component;

@Component("productDao")
public class ProductDaoImpl implements ProductDao {
    @Override
    public void save() {
        System.out.println("saved...");
    }

    @Override
    public void update() {
        System.out.println("update...");

    }

    @Override
    public void delete() {
        System.out.println("delete...");
    }

    @Override
    public void add() {
        System.out.println("add...");
    }
}
