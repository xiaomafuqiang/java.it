package net.htmlonline.dao;

import net.htmlonline.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountMapperTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");

    @Test
    public void run() {
        AccountMapper accountMapper = context.getBean(AccountMapper.class); // 方式二
        Account accoutById = accountMapper.selectAccount(14);
        System.out.println(accoutById);
    }
}