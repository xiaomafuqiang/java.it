package net.htmlonline.aop.annotation;

public class OrderDaoImpl implements OrderDao {
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
