package net.htmlonline.dao.impl;

import net.htmlonline.dao.CustomerDao;
import net.htmlonline.domain.Customer;
import net.htmlonline.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> find() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<Customer> customer = session.createQuery("from Customer").list();

        transaction.commit();

        return customer;
    }

}
