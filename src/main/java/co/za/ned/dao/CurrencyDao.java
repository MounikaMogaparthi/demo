package co.za.ned.dao;



import co.za.ned.model.Currency;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;


public class CurrencyDao {

//    @Inject
@PersistenceContext(unitName = "forex")
private EntityManager entityManager;

    DataSource dataSource = null;

    public void connection() {


        try {

            System.out.println(entityManager.isOpen());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void dbConnection(){

/*
        try {
            Context ctx = new InitialContext();
            UserTransaction tran = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
            tran.begin();

            EntityManager em = (EntityManager) ctx.lookup("jdbc/MyDataSource");
            Currency currency = new Currency();
            em.persist(currency);
            tran.commit();
        }
        catch (Exception e){
            System.out.println(e);
        }*/

        try {

        dataSource = (DataSource) new InitialContext().lookup("jdbc/MyDataSource");
            System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
            System.out.println(connection);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from CURRENCY");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("CURRENCY_CODE"));
        }
        preparedStatement.close();
        connection.close();
    } catch (NamingException e) {
            System.out.println(""+e);

    }
       catch (
    SQLException e) {
        e.printStackTrace();
    }

    }

   public Currency find(String currencyCode) {
        Currency currency = entityManager.find(co.za.ned.model.Currency.class, currencyCode);
        return currency;
    }

    public static void main(String[] args) {
        CurrencyDao currencyDao=new CurrencyDao();
        currencyDao.connection();
        currencyDao.dbConnection();
        //currencyDao.findAll();

    }


    public  List<Currency> findAll() {
        TypedQuery<Currency> currencyTypedQuery=entityManager.createQuery("Select c from CURRENCY c",Currency.class);
       // List<Currency> currencies = entityManager.createNativeQuery("SELECT * FROM CURRENCY", co.za.ned.model.Currency.class).getResultList();
        return currencyTypedQuery.getResultList();
    }


    /*public Currency update(Currency currency) {
        entityManager.merge(currency);
        return currency;
    }*/
}