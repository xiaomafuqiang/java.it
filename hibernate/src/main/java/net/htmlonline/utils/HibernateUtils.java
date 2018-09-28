package net.htmlonline.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateUtils {

    //
    Session session = sessionFactory.openSession();
    private static final Configuration configuration;
    private static final SessionFactory sessionFactory;

    static {
        // 1, 加载配置文件
        configuration = new Configuration().configure();
        // Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        // configure.addResource("hibernate.cfg.xml");

        // 2, 创建session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    // 3, 提供获取session方法
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // threadLocal 保证session一致...
    // 不能再调用session.close() 会报错, 已经内部调用了 *******************######
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void run() {
        // 4, 应用
        Session session = openSession();
        // 5, 开启事物 兼容 3.0
        Transaction transaction = session.beginTransaction();

        // 6 *** session code
        // session.save(Object);

        // 7, 释放资源
        transaction.commit();
        session.close();
    }


    @Test
    public void runCurrent() {
        // 4, 应用
        Session session = getCurrentSession();
        // 5, 开启事物 兼容 3.0
        Transaction transaction = session.beginTransaction();

        // 6 *** session code
        // session.save(Object);

        // 7, 释放资源
        transaction.commit();
        // ## session.close();
    }
}
