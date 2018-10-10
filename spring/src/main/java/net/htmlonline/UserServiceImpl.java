package net.htmlonline;

public class UserServiceImpl implements UserService {
    private String name;

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
