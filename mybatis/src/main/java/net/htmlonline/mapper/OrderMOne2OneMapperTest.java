package net.htmlonline.mapper;

import net.htmlonline.domain.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static net.htmlonline.util.Utils.getSessionFactory;

public class OrderMOne2OneMapperTest {

    @Test
    public void runDynamicSqlList() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMOne2OneMapper mapper = sqlSession.getMapper(OrderMOne2OneMapper.class);

        List<Order> orders = mapper.selectOrder();
        System.out.println(orders);


        sqlSession.commit();
    }
}
