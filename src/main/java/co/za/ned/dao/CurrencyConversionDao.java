package co.za.ned.dao;

import co.za.ned.model.Currency;
import co.za.ned.model.CurrencyConversion;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

public class CurrencyConversionDao {
    private static final Logger LOGGER = Logger.getLogger(CurrencyConversionDao.class.getName());

    @PersistenceContext(name = "forex")
    EntityManager entityManager;

    public CurrencyConversion find(String pKey) {
        CurrencyConversion currencyConversion = entityManager.find(CurrencyConversion.class, pKey);
        return currencyConversion;
    }

    public CurrencyConversion update(CurrencyConversion currencyConversion) {
        entityManager.merge(currencyConversion);
        return currencyConversion;
    }

    public CurrencyConversion save(CurrencyConversion currencyConversion) {
        entityManager.persist(currencyConversion);
        return currencyConversion;
    }


}

