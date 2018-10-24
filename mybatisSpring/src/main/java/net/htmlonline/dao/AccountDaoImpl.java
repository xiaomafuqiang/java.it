package net.htmlonline.dao;

import net.htmlonline.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao {
    @Override
    public Account findUserById(int id) {
        // 继承 SqlSessionDaoSupport 类，通过 this.getSqlSession() 得到 sqlSession
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectOne("account.selectAccount", id);
    }
}