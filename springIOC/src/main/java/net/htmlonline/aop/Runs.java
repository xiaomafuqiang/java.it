package net.htmlonline.aop;

import net.htmlonline.aop.annotation.OrderDaoImpl;
import net.htmlonline.aop.xml.ProductDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runs {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

    @Test
    public void runXml() {
        ProductDaoImpl productDao = context.getBean("productDaoImpl", ProductDaoImpl.class);
        productDao.add();
        productDao.save();
        productDao.delete();
        productDao.update();
        productDao.find();
    }


    @Test
    public void runAnnotation() {
        OrderDaoImpl orderDao = context.getBean("orderDaoImpl", OrderDaoImpl.class);
        orderDao.add();
        orderDao.save();
        orderDao.delete();
        orderDao.update();
        orderDao.find();
    }

}
