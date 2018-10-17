package net.htmlonline.mapper;

import net.htmlonline.domain.manytoone.Orderm;

import java.util.List;

public interface OrderMany2OneMapper {
    List<Orderm> selectOrder();
}
