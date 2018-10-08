package net.htmlonline.dao;

import net.htmlonline.domain.Customer;
import net.htmlonline.service.CustomerService;

import java.util.List;

public interface CustomerDao {
    List<Customer> find();
}
