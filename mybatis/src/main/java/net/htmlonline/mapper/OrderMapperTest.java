package net.htmlonline.mapper;

import net.htmlonline.domain.Order;
import net.htmlonline.domain.OrderProxy;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    public void runDynamicSql() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders =null;
        orders = mapper.selectOrderByNameAndMoney1("ax", 454545);
        System.out.println(orders);

        Order order = new Order();
        order.setName("ax");
        order.setMoney(454545D);
//        orders = mapper.selectOrderByNameAndMoney2(order);
        orders = mapper.selectOrderByNameAndMoney3(order);
        System.out.println(orders);

        sqlSession.commit();
    }

    @Test
    public void runDynamicSql2() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders =null;
        OrderProxy orderProxy = new OrderProxy();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        orderProxy.setList(list);
        orders = mapper.selectOrderByNameAndMoney4(orderProxy);
        System.out.println(orders);


        sqlSession.commit();
    }
    @Test
    public void runDynamicSqlList() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);


        List<Order> orders;
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
        list.add(2);
        orders = mapper.selectOrderByNameAndMoney5(list);
        System.out.println(orders);


        sqlSession.commit();
    }
    @Test
    public void runDynamicSqlArray() {
        SqlSessionFactory sessionFactory = getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);


        List<Order> orders;
        Integer[] ints = {1};
        orders = mapper.selectOrderByNameAndMoney6(ints);
        System.out.println(orders);


        sqlSession.commit();
    }
}
