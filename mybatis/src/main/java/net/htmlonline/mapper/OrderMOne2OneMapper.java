package net.htmlonline.mapper;

import net.htmlonline.domain.Order;
import net.htmlonline.domain.OrderProxy;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderMOne2OneMapper {
    List<Order> selectOrder();
}
