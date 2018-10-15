package net.htmlonline.jdbc.transaction;

import net.htmlonline.jdbc.transaction.service.AccountService;
import net.htmlonline.jdbc.transaction.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class runs {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    AccountService accountService = context.getBean("accountService", AccountServiceImpl.class);

    @Test
    public void run() {
        accountService.transfer("ma", "xiao", 100D);

    }
}
