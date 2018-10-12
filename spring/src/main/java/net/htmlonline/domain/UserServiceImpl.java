package net.htmlonline.domain;

public class UserServiceImpl implements UserService {
    private String name;

    public void initMethod() {
        System.out.println("init method invoked...");
    }


    public void destroyed() {
        System.out.println("destroyed method invoked...");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void save() {
        System.out.println("saved...");
    }

}
