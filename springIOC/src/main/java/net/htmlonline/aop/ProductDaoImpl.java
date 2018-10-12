package net.htmlonline.aop;

import org.springframework.stereotype.Component;

@Component("productDao")
public class ProductDaoImpl implements ProductDao {
    @Override
    public void save() {
        System.out.println("saved...");
    }

    @Override
    public String update() {
        System.out.println("update...");

        return "UPDATE";
    }

    @Override
    public String delete() {
        System.out.println("delete...");
        return "AFTER RETURNING...";
    }

    @Override
    public void find() {
        System.out.println("find...");
        // int i = 1 / 0;
    }

    @Override
    public void add() {
        System.out.println("add...");
    }
}
