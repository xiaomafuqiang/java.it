package net.htmlonline.domain.multiple.ontomany.table.one.query;

import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.domain.multiple.ontomany.LinkMan;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CriteriaQueryTest {
    @Test
    // 简单查询
    public void run() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<Customer> list = session.createCriteria(Customer.class).list();
        System.out.println(list);

        transaction.commit();
    }
    @Test
    // 排序查询
    public void run2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);
//        criteria.addOrder(Order.asc("cust_id")); // 生序
        criteria.addOrder(Order.desc("cust_id")); // 降序
        List<Customer> list = criteria.list();
        System.out.println(list);

        transaction.commit();
    }
    @Test
    // 分页查询
    public void run3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(LinkMan.class);

        criteria.setFirstResult(0);
        criteria.setMaxResults(10);
        List<LinkMan> list = criteria.list();
        System.out.println(list);

        transaction.commit();
    }
    @Test
    // 条件查询
    public void run4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);

        criteria.add(Restrictions.eq("cust_name", "黄昏"));
        criteria.add(Restrictions.gt("cust_id", 0L));

        List<Customer> list = criteria.list();
        System.out.println(list);

        transaction.commit();
    }
    @Test
    // 统计 查询
    public void run5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);

        // add 普通查询条件 where 后面的条件
        // addOrder 排序
        // setProjection 聚合函数 和 group by having
        criteria.setProjection(Projections.rowCount());
        Long aLong = (Long) criteria.uniqueResult();
        System.out.println(aLong);


        transaction.commit();
    }
}
