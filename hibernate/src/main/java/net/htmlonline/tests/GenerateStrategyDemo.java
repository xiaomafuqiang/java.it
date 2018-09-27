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
        strategy.setName("xiaoMa");
        strategy.setAge(20);
        System.out.println(strategy); // 瞬时态 {没有 id 没有被session管理}

        session.save(strategy);
        System.out.println(strategy); // 托管态 { 有 id 有session管理 }

        transaction.commit();
        session.close();
        System.out.println(strategy); // 游离态 { 有 id 没有被session管理 }
    }
}
