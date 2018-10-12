package net.htmlonline.jdbc.template;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    @Test
    public void run() {
        // 交给 spring 管理
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql:///store_40");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcTemplate.update("insert into account values(null, ?, ?)", "小马345", 1000);
    }
}
