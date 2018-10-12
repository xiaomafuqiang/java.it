package net.htmlonline.jdbc.template;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void run() {
        // 交给 spring 管理
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql:///store_40");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");

        // jdbcTemplate.update("insert into account values(null, ?, ?)", "小马345", 10000);
        // jdbcTemplate.update("update account set name=?, count=? where id=?", "小王", 10000, 4);
        // jdbcTemplate.update("delete from account where id=?", 6);
    }

    @Test
    public void query() {
        String s = jdbcTemplate.queryForObject("select name from account where id=?", String.class, 7);
        System.out.println("return query string is :::: " + s);

        // map
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(), 8);
        System.out.println(account);

        // list
        List<Account> query = jdbcTemplate.query("select * from account", new MyRowMapper());
        System.out.println(query);
    }

    private static class MyRowMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setCount(resultSet.getInt("count"));

            return account;
        }
    }

    private static class Account {
        private int id;
        private String name;
        private int count;

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
