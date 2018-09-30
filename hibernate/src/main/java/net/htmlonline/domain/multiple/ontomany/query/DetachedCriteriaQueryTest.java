package net.htmlonline.domain.multiple.ontomany.query;

import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.domain.multiple.ontomany.LinkMan;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import java.util.List;

// 离线条件查询
public class DetachedCriteriaQueryTest {
    @Test
    // 离线条件查询
    public void run() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.like("cust_name", "黄%"));

        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria executableCriteria = detachedCriteria.getExecutableCriteria(session);
        List<Customer> list = executableCriteria.list();
        System.out.println(list);

        transaction.commit();
    }
}
