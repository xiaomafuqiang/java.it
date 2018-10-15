package net.htmlonline.jdbc.transaction.aop.config.service;

public interface AccountService {

    // from 转出账号
    // to 转入账号
    // money 转账金额
    void transfer(String from, String to, Double money);
}
