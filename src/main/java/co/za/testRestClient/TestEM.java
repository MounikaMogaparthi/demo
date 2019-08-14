package co.za.testRestClient;


import co.za.ned.model.Currency;

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.sql.*;
import javax.annotation.Resource.AuthenticationType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Servlet implementation class JdbcServlet
 */

@WebServlet("/testEM")
public class TestEM extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEM() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            Context ctx = new InitialContext();
            // Before getting an EntityManager, start a global transaction
           /* UserTransaction tran = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
            tran.begin();*/

            // Now get the EntityManager from JNDI
            EntityManager em = (EntityManager) ctx.lookup("jdbc/demo");
            response.getWriter().println("Adding Currency ");
            response.getWriter().print("Adding Currency " + em.getDelegate().getClass());

            // Create a Thing object and persist it to the database
            Currency currency = new Currency();
            em.persist(currency);
            String query = "SELECT c FROM CURRENCY c";
            Query q = em.createQuery(query);

            // Execute the query
            List<Currency> currencies = q.getResultList();
            response.getWriter().println("Query returned " + currencies.size() + " currencies");

            // Let's see what we got back!
            for (Currency currency1 : currencies) {
                response.getWriter().println("Thing in list " + currency);
                // Commit the transaction
                // tran.commit();
                String s = currency.getCurrencyCode();
                response.getWriter().print("Created Thing: " + currency);
            }
        } catch (Exception e) {
            response.getWriter().print(e);
        }
    }

      /*  @SuppressWarnings("unchecked")
        public void retrieveThing(PrintWriter writer) throws SystemException, NamingException {
            // Look up the EntityManager in JNDI
            Context ctx = new InitialContext();
            EntityManager em = (EntityManager) ctx.lookup("jdbc/demo");
            // Compose a JPQL query
            String query = "SELECT c FROM CURRENCY c";
            Query q = em.createQuery(query);

            // Execute the query
            List<Currency> currencies = q.getResultList();
            writer.println("Query returned " + currencies.size() + " currencies");

            // Let's see what we got back!
            for (Currency currency : currencies) {
                writer.println("Thing in list " + currency);
            }
        }*/
}
