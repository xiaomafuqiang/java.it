package net.htmlonline;

import net.htmlonline.dao.AccountDao;
import net.htmlonline.domain.Account;
import net.htmlonline.util.Utils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    @Test
    public void run() {
        SqlSessionFactory sessionFactory = Utils.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        System.out.println(111);
        System.out.println(sqlSession);
        sqlSession.commit();
    }
    @Test
    public void run2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        // ##  // 不可这么获取 error accountDao方式获取调用
        // error: actually of type 'org.apache.ibatis.session.defaults.DefaultSqlSessionFactory'
        // context.getBean("sqlSessionFactory", SqlSessionFactoryBean.class);
        // SqlSessionFactoryBean factory = (SqlSessionFactoryBean) context.getBean("sqlSessionFactory");

        // accountDao方式获取调用 ok
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        // 调用 UserDAO 的方法
        Account account = accountDao.findUserById(14);
        // 输出用户信息
        System.out.println(account);
    }


}


