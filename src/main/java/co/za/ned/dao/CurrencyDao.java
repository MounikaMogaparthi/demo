package co.za.ned.dao;

import co.za.ned.model.Currency;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;


public class CurrencyDao {

    @Inject
    @PersistenceContext(unitName = "forex")
    private  EntityManager entityManager;

    public Currency find(String code) {

        CurrencyDao currencyDao=new CurrencyDao();
        Currency currency = entityManager.find(Currency.class, code);
        return currency;
    }

   /* public static void main(String[] args) {
        find("AED");
    }


    public List<Currency> findAll() {
        List<Currency> currencies = entityManager.createNativeQuery("SELECT * FROM CURRENCY", Currency.class).getResultList();
        return currencies;
    }

*/
    /*public Currency update(Currency currency) {
        entityManager.merge(currency);
        return currency;
    }*/
}