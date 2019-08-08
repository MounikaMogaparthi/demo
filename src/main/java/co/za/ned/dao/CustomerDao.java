package co.za.ned.dao;

import co.za.ned.model.Currency;
import co.za.ned.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomerDao {
    @PersistenceContext(name = "forex")
    EntityManager entityManager;

    public Customer get(Integer id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public List<Customer> findAll() {
        List<Customer> customers = entityManager.createNativeQuery("SELECT e.* FROM Customer_Table e", co.za.ned.model.Customer.class).getResultList();
        return customers;
    }
    public Customer update(Customer customer) {
        entityManager.merge(customer);
        return customer;
    }
}
