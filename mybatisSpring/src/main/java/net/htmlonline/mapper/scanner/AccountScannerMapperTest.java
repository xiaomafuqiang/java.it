package net.htmlonline.mapper.scanner;

import net.htmlonline.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountScannerMapperTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

    @Test
    public void run() {
        AccountScannerMapper accountMapper = context.getBean(AccountScannerMapper.class); // 方式二
        Account accoutById = accountMapper.getAccountById(14);
        System.out.println(accoutById);
    }
}
