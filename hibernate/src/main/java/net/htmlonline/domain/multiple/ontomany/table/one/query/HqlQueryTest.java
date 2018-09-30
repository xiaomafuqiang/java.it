package net.htmlonline.domain.multiple.ontomany.table.one.query;

import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.domain.multiple.ontomany.LinkMan;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HqlQueryTest {

    // 初始化数据
    public void run() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("黄昏");
        for (int i = 0; i < 10; i++) {
            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("刘亦菲 " + i);
            linkMan.setCustomer(customer);
            customer.getLinkMans().add(linkMan);
            session.save(linkMan);
        }
        session.save(customer);

        transaction.commit();

    }

    @Test
    // HQL
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        String sql = "from Customer ";
        sql = "from net.htmlonline.domain.multiple.ontomany.Customer ";
        sql = "from Customer c"; // 别名查询 不支持 * 匹配
        sql = "select c from Customer  c";
        sql = "from Customer order by cust_id"; // 默认升序
        sql = "from Customer order by cust_id desc "; // 降序


        List<Customer> customers = session.createQuery(sql).list();
        // System.out.println(customers);


        // 条件查询
        // ① : 按照位置绑定
        // 一个条件
        Query query = session.createQuery("from Customer where cust_name = ?3 and cust_id = ?4");
        query.setParameter(3, "黄昏"); // 设置对应位置参数
        query.setParameter(4, 3L); // 设置对应位置参数
        customers = query.list();
        // System.out.println(customers);

        // ② : 按照名称绑定
        // 一个条件
        query = session.createQuery("from Customer where cust_name = :aaa and cust_id = :bbb");
        query.setParameter("aaa", "黄昏"); // 设置对应位置参数
        query.setParameter("bbb", 3L); // 设置对应位置参数
        customers = query.list();
        System.out.println(customers);

        transaction.commit();
    }

    @Test
    // 投影查询
    // 单个或者某些
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<Object> list = session.createQuery("select c.cust_name from Customer c ").list();// 一个数据
        System.out.println(list);
        List<Object[]> lists = session.createQuery("select c.cust_name, c.cust_id from Customer c ").list(); // 多条数据
        for (Object[] objects : lists) {
            System.out.println(Arrays.toString(objects));
        }

        List<Customer> list1 = session.createQuery("select new Customer(cust_id, cust_name) from Customer ").list(); // 构造方式查询
        System.out.println(list1);

        transaction.commit();
    }

    @Test
    // 分页查询
    public void run4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from LinkMan ");
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<LinkMan> list = query.list();
        System.out.println(list);
    }

    @Test
    // 分组查询
    public void run5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Object o = session.createQuery("select count(*) from Customer ").uniqueResult(); // 唯一结果可以用
        System.out.println(o);

        List<Object[]> list = session.createQuery("select cust_name, count (*) from Customer group by cust_name ").list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }

    }
}
