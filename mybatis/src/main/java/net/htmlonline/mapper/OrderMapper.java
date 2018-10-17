package net.htmlonline.mapper;

import net.htmlonline.domain.Order;
import net.htmlonline.domain.OrderProxy;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderMapper {
    List<Order> selectOrder();

    List<Order> selectOrderByNameAndMoney1(@Param("name") String name, @Param("money") int money);

    List<Order> selectOrderByNameAndMoney2(@Param("order") Order order);
    List<Order> selectOrderByNameAndMoney3(@Param("order") Order order);

    List<Order> selectOrderByNameAndMoney4(@Param("orderProxy") OrderProxy orderProxy);

    List<Order> selectOrderByNameAndMoney5(@Param("lists") ArrayList<Integer> list);

    List<Order> selectOrderByNameAndMoney6(@Param("ints") Integer[] ints);
}
