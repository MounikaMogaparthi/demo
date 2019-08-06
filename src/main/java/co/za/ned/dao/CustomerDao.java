package co.za.ned.dao;

import co.za.ned.model.Currency;
import co.za.ned.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDao {
    @PersistenceContext(name = "forex")
    EntityManager entityManager;

    public Customer get(String id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }


}
