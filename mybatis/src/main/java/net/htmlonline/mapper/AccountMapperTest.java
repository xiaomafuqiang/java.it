package net.htmlonline.mapper;

import net.htmlonline.domain.Account;
import net.htmlonline.domain.AccountProxy;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.htmlonline.util.Utils.getSessionFactory;

public class AccountMapperTest {

    @Test
    public void run() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.selectAccount(19);
        System.out.println(account);

        List<Account> accounts = mapper.selectList();
        System.out.println(accounts);

        sqlSession.commit();
    }

    @Test
    public void runProxy() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        AccountProxy accountProxy = new AccountProxy();
        Account account = new Account("x", 1700D);
        accountProxy.setAccount(account);

        List<Account> accounts = mapper.selectAccountProxyList(accountProxy);
        System.out.println(accounts);

        sqlSession.commit();
    }

    @Test
    public void runInsertAccount() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        Account account = new Account("shenxw", 9000D);

        Integer affectedCount = mapper.insertAccount(account);
        System.out.println(affectedCount);
        System.out.println(account.getId()); // id

        sqlSession.commit();
    }

    @Test
    public void runUpdateAccount() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        Account account = mapper.selectAccount(19);
        account.setName("maa");
        account.setMoney(90202D);
        System.out.println(account);

        Integer affectedCount = mapper.updateAccount(account.getName(), account.getMoney(), account.getId());
        System.out.println(affectedCount);

        sqlSession.commit();
    }

}
