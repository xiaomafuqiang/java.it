package net.htmlonline.jdbc.transaction.aop.config;

import net.htmlonline.jdbc.transaction.aop.config.service.AccountService;
import net.htmlonline.jdbc.transaction.aop.config.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runs2 {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    AccountService accountService = context.getBean("accountService3", AccountServiceImpl.class);

    @Test
    public void run() {
        accountService.transfer("ma", "xiao", 100D);

    }
}
