package net.htmlonline.xml;

import net.htmlonline.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.htmlonline.util.Utils.getSessionFactory;

public class Run {

    @Test
    public void runSelect() {
        SqlSession sqlSession = getSessionFactory().openSession();

        List<Account> selectAccount = sqlSession.selectList("account.selectAccountList", "m");
        System.out.println(selectAccount);
        sqlSession.commit();

    }

    @Test
    public void runInsert() {
        SqlSession sqlSession = getSessionFactory().openSession();

        Account account = new Account("shen3456", 9000D);

        int affectedCount = sqlSession.insert("account.insertAccount", account);

        int id = account.getId();
        System.out.println(id);
        sqlSession.commit();
    }

    @Test
    public void runUpdate() {
        SqlSession sqlSession = getSessionFactory().openSession();

        Account account = new Account("shenxw", 9000D);
        account.setId(20);

        int affectedCount = sqlSession.update("account.updateAccount", account);

        System.out.println(affectedCount);
        sqlSession.commit();
    }
    @Test
    public void runDelete() {
        SqlSession sqlSession = getSessionFactory().openSession();

        int affectedCount = sqlSession.delete("account.deleteAccount", 18);

        System.out.println(affectedCount);
        sqlSession.commit();
    }
}
