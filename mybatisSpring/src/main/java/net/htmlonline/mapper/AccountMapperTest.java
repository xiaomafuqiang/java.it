package net.htmlonline.mapper;

import net.htmlonline.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountMapperTest {

    @Test
    public void run() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // AccountMapper accountMapper = context.getBean("accountMapper", AccountMapper.class); // 方式 一
         AccountMapper accountMapper = context.getBean(AccountMapper.class); // 方式二
        Account accoutById = accountMapper.getAccountById(14);
        System.out.println(accoutById);
    }
}
