package net.htmlonline.domain.multiple.ontomany.table.multiple.query;

import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HqlMultipleQueryTest {
    @Test
    public void run() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // select * from cst_customer c join cst_linkman cl on c.cust_id = cl.lkm_cust_id;
        List<Object[]> list = session.createQuery("from Customer c inner join c.linkMans").list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }

        // hql 迫切内连接, 就是在 普通内连接后加一个关键字 fetch
        // *** 返回的list 是个 customer 并且把 linkMans封装上
        List<Customer> lists = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans").list();
        for (Customer customer : lists) {
            System.out.println(customer);
        }

        transaction.commit();
    }
}
