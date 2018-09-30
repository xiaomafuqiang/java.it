package net.htmlonline.domain.multiple.ontomany.table.optimize.fetch.lazy;

import net.htmlonline.domain.multiple.ontomany.Customer;
import net.htmlonline.domain.multiple.ontomany.LinkMan;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;


/**
 * 批量抓取
 *
 */
public class LazyClassBatch3 {

	@SuppressWarnings("unchecked")
	@Test
	/**
	 * 获取客户的时候，批量抓取联系人
	 * 在Customer.hbm.xml中set上配置batch-size
	 */
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
			for (LinkMan linkMan : customer.getLinkMans()) {
				System.out.println(linkMan.getLkm_name());
			}
		}
		tx.commit();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	/**
	 * 获取联系人的时候，批量抓取客户
	 * * 在Customer.hbm.xml中<class>上配置
	 */
	public void demo2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<LinkMan> list = session.createQuery("from LinkMan").list();
		for (LinkMan linkMan : list) {
			System.out.println(linkMan.getLkm_name());
			System.out.println(linkMan.getCustomer().getCust_name());
		}
		tx.commit();
	}
}
