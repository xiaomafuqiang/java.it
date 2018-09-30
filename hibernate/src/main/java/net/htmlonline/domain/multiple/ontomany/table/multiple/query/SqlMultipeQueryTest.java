package net.htmlonline.domain.multiple.ontomany.table.multiple.query;

import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SqlMultipeQueryTest {

    @Test
    public void run() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
        // 默认数组类型
        List<Object[]> list = sqlQuery.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }

        // 封装成 某种类型
        sqlQuery.addEntity(Customer.class);
        List<Customer> list1 = sqlQuery.list();
        for (Customer customer : list1) {
            System.out.println(customer);
        }

        String sql = "select * from cst_customer c left join cst_linkman cl on c.cust_id = cl.lkm_cust_id";
        List<Object[]> list2 = session.createSQLQuery(sql).list();
        for (Object[] objects : list2) {
            System.out.println(Arrays.toString(objects));
        }


        transaction.commit();
    }
}
