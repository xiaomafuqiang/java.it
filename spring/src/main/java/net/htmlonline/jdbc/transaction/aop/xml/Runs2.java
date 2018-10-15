package net.htmlonline.jdbc.transaction.aop.xml;

import net.htmlonline.jdbc.transaction.aop.xml.service.AccountService;
import net.htmlonline.jdbc.transaction.aop.xml.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runs2 {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    AccountService accountService = context.getBean("accountService2", AccountServiceImpl.class);

    @Test
    public void run() {
        accountService.transfer("ma", "xiao", 100D);

    }
}
