package co.za.ned.dao;

import co.za.ned.model.Currency;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;


public class CurrencyDao {
    private static final Logger LOGGER = Logger.getLogger(CurrencyDao.class.getName());
    @PersistenceContext(name = "forex")
   private static EntityManager entityManager;


    public static Currency find(String code) {
        Currency currency = entityManager.find(Currency.class, code);
        return currency;
    }

    public static void main(String[] args) {
        find("AED");
    }
    /*

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