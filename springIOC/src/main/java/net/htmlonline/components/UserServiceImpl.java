package net.htmlonline.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class UserServiceImpl implements UserService {
    // @Value("中国人")
    private String name;

    public String getName() {
        return name;
    }

    @Value("中国人")
    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("saved");
    }


}
