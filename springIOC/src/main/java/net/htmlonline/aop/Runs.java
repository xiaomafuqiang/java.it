package net.htmlonline.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runs {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

    org.aspectj.weaver.tools.JoinPointMatch match;
    @Test
    public void run() {
        ProductDaoImpl productDao = context.getBean("productDaoImpl", ProductDaoImpl.class);
        productDao.add();
        productDao.save();
        productDao.delete();
        productDao.update();
    }
}
