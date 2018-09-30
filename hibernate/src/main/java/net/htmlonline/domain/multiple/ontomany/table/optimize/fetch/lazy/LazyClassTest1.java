package net.htmlonline.domain.multiple.ontomany.table.optimize.fetch.lazy;


import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Hibernate的延迟加载
 *
 */
public class LazyClassTest1 {

	@Test
	/**
	 * 类级别的延迟加载
	 * * 在<class>的标签上配置的lazy
	 */
	public void run(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.load(Customer.class, 1l);
		Hibernate.initialize(customer);
		System.out.println(customer);
		
		tx.commit();
	}
}
