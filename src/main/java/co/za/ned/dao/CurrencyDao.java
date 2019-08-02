package co.za.ned.dao;

import co.za.ned.model.Currency;

import javax.inject.Inject;
import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;

public class CurrencyDao {

    @PersistenceContext(unitName = "forex")
    private EntityManager entityManager;

    public void connection() {
        System.out.println(entityManager.isOpen());
        // Currency s=entityManager.find(Currency.class,"AED");
        List<Currency> currencies = entityManager.createQuery("Select c from CURRENCY c").getResultList();
        System.out.println(currencies);
        //System.out.println("Currency Name = "+s.getCurrencyName());
        //System.out.println("Currency Code = "+s.getCurrencyCode());
        /*try {

            System.out.println(entityManager.isOpen());
        } catch (Exception e) {
            System.out.println(e);
        }*/

    }


    public Currency find(String currencyCode) {
        Currency currency = entityManager.find(co.za.ned.model.Currency.class, currencyCode);
        return currency;
    }

    public static void main(String[] args) {
        CurrencyDao currencyDao = new CurrencyDao();
        currencyDao.connection();

        currencyDao.find("AED");

    }


    public List<Currency> findAll() {
        TypedQuery<Currency> currencyTypedQuery = entityManager.createQuery("Select * from CURRENCY", Currency.class);
        // List<Currency> currencies = entityManager.createNativeQuery("SELECT * FROM CURRENCY", co.za.ned.model.Currency.class).getResultList();
        return currencyTypedQuery.getResultList();
    }


    /*public Currency update(Currency currency) {
        entityManager.merge(currency);
        return currency;
    }*/
}