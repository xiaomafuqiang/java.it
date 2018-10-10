package net.htmlonline.test;

import net.htmlonline.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTests {
    @Test
    public void run() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl a = context.getBean("a", UserServiceImpl.class);
        System.out.println(a);
        a.save();
        System.out.println(a.getName());
    }
}
