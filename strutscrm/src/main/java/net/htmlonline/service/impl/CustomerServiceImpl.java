package net.htmlonline.service.impl;

import net.htmlonline.dao.impl.CustomerDaoImpl;
import net.htmlonline.domain.Customer;
import net.htmlonline.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> find() {
        return new CustomerDaoImpl().find();
    }
}
