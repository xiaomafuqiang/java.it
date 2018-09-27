package net.htmlonline.tests;

import net.htmlonline.domain.GenerateStrategy;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class GenerateStrategyDemo {
    @Test
    public void run() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();

        GenerateStrategy strategy = new GenerateStrategy();
        strategy.setAge(20);
        strategy.setName("xiaoMa");
        session.save(strategy);

        transaction.commit();
        session.close();
    }
}
