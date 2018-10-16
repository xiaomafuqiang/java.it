package net.htmlonline;

import net.htmlonline.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Run {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    public Run() throws IOException {
    }

    @Test
    public void runSelect() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Account> selectAccount = sqlSession.selectList("account.selectAccountList", "m");
        System.out.println(selectAccount);
        sqlSession.commit();

    }

    @Test
    public void runInsert() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Account account = new Account("shen", 9000D);

        int affectedCount = sqlSession.insert("account.insertAccount", account);

        int id = account.getId();
        System.out.println(id);
        sqlSession.commit();
    }

    @Test
    public void runUpdate() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Account account = new Account("shenxw", 9000D);
        account.setId(20);

        int affectedCount = sqlSession.update("account.updateAccount", account);

        System.out.println(affectedCount);
        sqlSession.commit();
    }
    @Test
    public void runDelete() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int affectedCount = sqlSession.delete("account.deleteAccount", 18);

        System.out.println(affectedCount);
        sqlSession.commit();
    }
}
