package net.htmlonline.domain.multiple.ontomany;

import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void run() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // 编写两个客户
        Customer customer1 = new Customer();
        customer1.setCust_name("王东");
        Customer customer2 = new Customer();
        customer2.setCust_name("赵洪");

        // 创建三个联系人
        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkm_name("风");
        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkm_name("东");
        LinkMan linkMan3 = new LinkMan();
        linkMan3.setLkm_name("西");

        // 设置关系
        linkMan1.setCustomer(customer1);
        linkMan2.setCustomer(customer1);
        linkMan3.setCustomer(customer2);
        // 此处是否有必要设置 ???
        customer1.getLinkMans().add(linkMan1);
        customer2.getLinkMans().add(linkMan2);
        customer2.getLinkMans().add(linkMan3);

        // 保存数据
        // 默认都要保存
        // 可以设置级联操作
        // 保存一方 cascade="save-update" : 几联操作  save(一方)
        session.save(linkMan1);
        session.save(linkMan2);
        session.save(linkMan3);
        session.save(customer1);
        session.save(customer2);

        transaction.commit();
        // session.close();
    }

    @Test
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        // 编写客户
        Customer customer = new Customer();
        customer.setCust_name("王东");
        //
        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("风");

        // 设置
        linkMan.setCustomer(customer);

        // 可以设置级联操作
        // 保存一方 cascade="save-update" : 几联操作  save(一方)
        // 如果两方都设置: 会产生好多条语句
        session.save(linkMan);

        transaction.commit();
        // session.close();
    }

    @Test
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // 默认删除时候 设置外键 null然后删除数据 操作
        // 几联删除设置: 删除干净相关数据 cascade="save-update, delete"
        Customer customer = session.get(Customer.class, 20L);
        System.out.println(customer);
        session.delete(customer);


        transaction.commit();
        // session.close();
    }
}
