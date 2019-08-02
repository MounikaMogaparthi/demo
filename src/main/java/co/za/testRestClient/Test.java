package co.za.testRestClient;

import co.za.ned.model.Currency;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.*;


public class Test {
    public static void main(String[] args) {
Test test=new Test();
test.findAll();
    }
        public List<Currency> findAll() {
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("forex");
            EntityManager em = emf.createEntityManager();
            List<Currency> result;

            try {
                em.getTransaction().begin();
                TypedQuery<Currency> query = em.createQuery("Select c from Currency c", Currency.class);
                result = query.getResultList();
                em.getTransaction().commit();
            } finally {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }

            return result;
        }
              /*  EntityManagerFactory emf=Persistence.createEntityManagerFactory("forex");
                EntityManager em=emf.createEntityManager();
                System.out.println(em.isOpen());
                Currency s=em.find(Currency.class,"AED");
                System.out.println("Currency Name = "+s.getCurrencyName());
                System.out.println("Currency Code = "+s.getCurrencyCode());
*/
            }




