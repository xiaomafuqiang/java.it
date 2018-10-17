package net.htmlonline.mapper;

import net.htmlonline.domain.manytoone.Orderm;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.htmlonline.util.Utils.getSessionFactory;

public class OrderMany2OneMapperTest {
    @Test
    public void runDynamicSqlList() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMany2OneMapper mapper = sqlSession.getMapper(OrderMany2OneMapper.class);

        List<Orderm> orders = mapper.selectOrder();
        System.out.println(orders);


        sqlSession.commit();
    }
}
