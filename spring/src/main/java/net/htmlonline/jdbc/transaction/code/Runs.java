package net.htmlonline.jdbc.transaction.code;

import net.htmlonline.jdbc.transaction.code.service.AccountService;
import net.htmlonline.jdbc.transaction.code.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runs {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    AccountService accountService = context.getBean("accountService", AccountServiceImpl.class);

    @Test
    public void run() {
        accountService.transfer("ma", "xiao", 100D);

    }
}
