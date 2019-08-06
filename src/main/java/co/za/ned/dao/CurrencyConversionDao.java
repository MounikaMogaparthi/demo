package co.za.ned.dao;

import co.za.ned.model.Currency;
import co.za.ned.model.CurrencyConversion;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CurrencyConversionDao {


    @PersistenceContext(name = "forex")
    EntityManager entityManager;

    public CurrencyConversion save(CurrencyConversion currencyConversion) {
        entityManager.persist(currencyConversion);
        return currencyConversion;
    }

    public CurrencyConversion get(String code) {
        CurrencyConversion cc = entityManager.find(CurrencyConversion.class, code);
        return cc;
    }

    public CurrencyConversion update(CurrencyConversion currencyConvertor) {
        entityManager.merge(currencyConvertor);
        return currencyConvertor;
    }


}
