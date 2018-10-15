package net.htmlonline.jdbc.transaction.aop.config.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void outMoney(String from, Double money) {
        getJdbcTemplate().update("update account set money = money - ? where name = ?", money, from);

    }

    @Override
    public void inMoney(String to, Double money) {
        getJdbcTemplate().update("update account set money = money + ? where name = ?", money, to);
    }
}
