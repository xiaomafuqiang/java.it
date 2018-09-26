package net.htmlonline.tests;

import com.sun.xml.bind.v2.ContextFactory;
import net.htmlonline.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class HibernateDemo {
    @Test
    public void run() {
       // 1, 加载配置文件
        Configuration configure = new Configuration().configure();
        // 2, 创建session factory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 3, 获取session
        Session session = sessionFactory.openSession();
        // 4, 开启食物
        Transaction transaction = session.beginTransaction();

        // 5, 编写代码
        User user = new User();
        user.setUid("sdfsdfsdfsdfsdf234234");
        user.setName("xiaoma");

        session.save(user);

        // 6, 事物提交
        transaction.commit();
        // 7, 资源释放
        session.close();
    }
}
