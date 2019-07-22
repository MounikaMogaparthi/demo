package co.za.ned.dao;

import co.za.ned.model.Currency;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CurrencyDao {

    @PersistenceContext(name = "forex")
    EntityManager entityManager;
/*

    public Currency find(String code) {
        Currency currency = entityManager.find(Currency.class, code);
        return currency;
    }
*/

    public List<Currency> findAll() {
        List<Currency> currencies = entityManager.createNativeQuery("SELECT * FROM CURRENCY", Currency.class).getResultList();
        return currencies;
    }

    /*public Currency update(Currency currency) {
        entityManager.merge(currency);
        return currency;
    }*/
}