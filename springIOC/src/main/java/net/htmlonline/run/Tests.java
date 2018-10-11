package net.htmlonline.run;

import net.htmlonline.components.UserServiceImpl;
import net.htmlonline.xml.config.Company;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    @Test
    public void run() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl user = context.getBean("user", UserServiceImpl.class);

        user.save();
        System.out.println(user.getName());
    }

    @Test
    public void run2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
    }


}
