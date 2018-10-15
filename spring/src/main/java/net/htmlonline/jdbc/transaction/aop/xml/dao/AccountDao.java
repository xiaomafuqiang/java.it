package net.htmlonline.jdbc.transaction.aop.xml.dao;

public interface AccountDao {
    void outMoney(String from, Double money);

    void inMoney(String to, Double money);
}
