package net.htmlonline.mapper;

import net.htmlonline.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> selectOrder();
}
