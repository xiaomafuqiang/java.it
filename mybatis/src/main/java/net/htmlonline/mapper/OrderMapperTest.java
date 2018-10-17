package net.htmlonline.mapper;

import net.htmlonline.domain.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.htmlonline.util.Utils.getSessionFactory;

public class OrderMapperTest {

    @Test
    public void run() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = mapper.selectOrder();
        System.out.println(orders);

        sqlSession.commit();
    }
}
