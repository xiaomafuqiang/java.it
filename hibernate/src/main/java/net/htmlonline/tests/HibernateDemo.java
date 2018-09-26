package net.htmlonline.tests;

import net.htmlonline.domain.Customer;
import net.htmlonline.utils.HIbernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateDemo {
    @Test
    public void run() {
        // 1, 加载配置文件
        Configuration configure = new Configuration().configure();
        // Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        // configure.addResource("hibernate.cfg.xml");
        // 2, 创建session factory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 3, 获取session
        Session session = sessionFactory.openSession();
        // 4, 开启食物
        Transaction transaction = session.beginTransaction();

        // 5, 编写代码
        Customer customer = new Customer();
        customer.setAge(20);
        customer.setName("xiaoMa");
        session.save(customer);

        // 6, 事物提交
        transaction.commit();
        // 7, 资源释放
        session.close();
    }

    @Test
    public void toolSession() {
        Session session = HIbernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("xiaoWang");
        customer.setAge(10);
        session.save(customer);

        transaction.commit();
        session.close();
    }
}
