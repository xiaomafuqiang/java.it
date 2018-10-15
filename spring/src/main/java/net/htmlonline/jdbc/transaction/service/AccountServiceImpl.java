package net.htmlonline.jdbc.transaction.service;

import net.htmlonline.jdbc.transaction.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    // from 转出账号
    // to 转入账号
    // money 转账金额
    public void transfer(String from, String to, Double money) {
        accountDao.outMoney(from, money);
        accountDao.inMoney(to, money);
    }
}
