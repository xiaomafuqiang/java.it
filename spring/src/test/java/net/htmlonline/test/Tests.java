package net.htmlonline.test;

import net.htmlonline.domain.UserServiceImpl;
import net.htmlonline.di.Car;
import net.htmlonline.di.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

    @Test
    public void run() {

        UserServiceImpl userservice = context.getBean("userservice", UserServiceImpl.class);
        System.out.println(userservice);
        userservice.save();
        System.out.println(userservice.getName());

        UserServiceImpl userService2 = context.getBean("userservice", UserServiceImpl.class);
        System.out.println(userService2 == userservice);

        // ((ClassPathXmlApplicationContext) context).close();


    }

    @Test
    public void di() {

        Car car = context.getBean("car", Car.class);
        System.out.println(car);

        Car car2 = context.getBean("car2", Car.class);
        System.out.println(car2);

        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);

        // spring expression languarge
        Employee employee2 = context.getBean("employee2", Employee.class);
        System.out.println(employee2);
    }

}
