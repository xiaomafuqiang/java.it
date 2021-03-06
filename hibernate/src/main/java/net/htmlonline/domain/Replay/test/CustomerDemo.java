package net.htmlonline.domain.Replay.test;

import net.htmlonline.domain.Replay.CustomerMe;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * 增删改查
 * */
public class CustomerDemo {
    private static Logger log = Logger.getLogger(CustomerDemo.class.getName());
    @Test
    public void add() {

        // 3, 获取session
        Session session = HibernateUtils.openSession();
        // 4, 开启食物
        Transaction transaction = session.beginTransaction();

        // 5, 编写代码
        CustomerMe customer = new CustomerMe();
        customer.setAge(20);
        customer.setName("xiaoMa");
        session.save(customer);

        // 6, 事物提交
        transaction.commit();
        // 7, 资源释放
        session.close();
    }

    @Test
    public void getObj() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        CustomerMe customer = new CustomerMe();
        customer.setName("xiaoWang");
        customer.setAge(23);
        Serializable save = session.save(customer); // 保存
        log.info("save-- " + save);

        CustomerMe getCustomer = session.get(CustomerMe.class, 8); // 根据 id查询 获取实例
        log.info(getCustomer == null ? "null" : getCustomer.toString());

//        CustomerMe loadCustomer = session.load(CustomerMe.class, save);
//        log.info(loadCustomer.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void update() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        CustomerMe customer = session.get(CustomerMe.class, 8);
        customer.setAge(90);

        session.update(customer);


        transaction.commit();
        session.close();
    }

    @Test
    public void delete() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        CustomerMe customer = session.get(CustomerMe.class, 2);
        System.out.println(customer);

        session.delete(customer);
        System.out.println(customer);

        transaction.commit();
        session.close();
        System.out.println(customer);

    }

    @Test
    public void saveOrUpdate() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        CustomerMe customer = new CustomerMe();
        customer.setAge(77);
        customer.setName("xiaoXiao");
        session.saveOrUpdate(customer); // 根据 是否有id决定创建还是update


        transaction.commit();
        session.close();
    }

    @Test
    public void queryAll() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Customer"); // hbl
        List<CustomerMe> list = query.list();
        for (CustomerMe customer : list) {
            System.out.println(customer);
        }

        query = session.createSQLQuery("select * from customer");
        List<Object[]> list1 = query.list();
        for (Object[] objects : list1) {
            System.out.println(Arrays.toString(objects));
        }

        transaction.commit();
        session.close();
    }
}
