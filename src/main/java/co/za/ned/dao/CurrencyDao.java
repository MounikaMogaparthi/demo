package co.za.ned.dao;

import co.za.ned.model.Currency;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;

@Stateless
public class CurrencyDao {

    @PersistenceContext(unitName = "forex")
    private EntityManager entityManager;

    public List<Currency> getAll() {
        List<Currency> currencies = entityManager.createNativeQuery("SELECT e.* FROM CURRENCY e", co.za.ned.model.Currency.class).getResultList();
        return currencies;
    }

    public Currency find(String currencyCode) {
        Currency currency = entityManager.find(co.za.ned.model.Currency.class, currencyCode);
        return currency;
    }


    public List<Currency> findAll() {
        List<Currency> currencies = entityManager.createNativeQuery("SELECT e.* FROM CURRENCY e", co.za.ned.model.Currency.class).getResultList();
        return currencies;
    }



    public Currency update(Currency currency) {
        entityManager.merge(currency);
        return currency;
    }
}