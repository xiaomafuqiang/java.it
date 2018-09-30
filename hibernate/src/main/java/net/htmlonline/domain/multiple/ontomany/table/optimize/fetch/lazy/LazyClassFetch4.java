package net.htmlonline.domain.multiple.ontomany.table.optimize.fetch.lazy;

import net.htmlonline.domain.multiple.ontomany.LinkMan;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * many-to-one上的fetch和lazy测试
 *
 */
public class LazyClassFetch4 {

	@Test
	/**
	 * 默认值
	 */
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		LinkMan linkMan = session.get(LinkMan.class, 1l);// 发送一条查询联系人语句
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());// 发送一条select语句查询联系人所关联的客户
		
		tx.commit();
	}
	
	@Test
	/**
	 * fetch="select" lazy="proxy"
	 */
	public void demo2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		LinkMan linkMan = session.get(LinkMan.class, 1l);// 发送一条查询联系人语句
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());// 发送一条select语句查询联系人所关联的客户
		
		tx.commit();
	}
	
	@Test
	/**
	 * fetch="select" lazy="false"
	 */
	public void demo3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		LinkMan linkMan = session.get(LinkMan.class, 1l);// 发送一条查询联系人语句,发送一条select语句查询联系人所关联的客户
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());// 
		
		tx.commit();
	}
	
	@Test
	/**
	 * fetch="join" lazy=失效
	 */
	public void demo4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		LinkMan linkMan = session.get(LinkMan.class, 1l);// 发送一条迫切左外连接查询联系人所关联的客户。
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());// 
		
		tx.commit();
	}
}
