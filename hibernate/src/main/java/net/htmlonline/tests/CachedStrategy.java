package net.htmlonline.tests;

import net.htmlonline.domain.Replay.Customer;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

public class CachedStrategy {
    @Test
    public void run() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 3); // 发送 sql
        Customer customer1 = session.get(Customer.class, 3); // 不发送sql 一级缓存
        System.out.println(customer == customer1); // true

        Customer customer2 = new Customer();
        Serializable id = session.save(customer2); // 发送增加sql
        Customer customer3 = session.get(Customer.class, id); // 不发送sql
        System.out.println(customer2 == customer3); // true

        transaction.commit();
        session.close();
    }

    @Test
    public void run2() {
        Session session = HibernateUtils.openSession();

        Customer customer = session.get(Customer.class, 4);
        System.out.println(customer);

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();

    }
}
