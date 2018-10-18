package net.htmlonline;

import net.htmlonline.util.Utils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
