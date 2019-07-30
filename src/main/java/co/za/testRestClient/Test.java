package co.za.testRestClient;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    @PersistenceContext(unitName = "forex")
    private EntityManager entityManager;

    public static void main(String[] args) {
        Test test=new Test();
        test.dbConnection();
        test.connection();
    }


   private DataSource ds1;
    public void connection() {


        try {

            System.out.println(entityManager.isOpen());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void dbConnection() {
        Statement stmt = null;
        Connection con = null;


        try {
           // dirContext=new InitialDirContext(env);
            InitialContext ctx=new InitialContext();

            //Context context=(Context)ctx.lookup("java:comp/env");
            ds1 = (DataSource) ctx.lookup("jdbc/MyDataSource");
            con = ds1.getConnection();

            stmt = con.createStatement();
            // create a table
            stmt.executeUpdate("create table Currency5 (CODE varchar(50) not null primary key,  NAME varchar(30))");
            // insert a test record
            stmt.executeUpdate("insert into Currency5 values ('AED', 'DIRHAM')");
            // select a record
            ResultSet result = stmt.executeQuery("select NAME from Currency5 where name='DIRHAM'");
            result.next();

            System.out.println("</TITLE></HEAD><body bgcolor='#f8f7cd'>");
            System.out.println("<h1><font color=green>Test connection successfull </font></h1>");
            System.out.println("<br /><center><form><input type=\"button\" value=\"Go back\" onclick=\"history.back();return false;\"/></form></center>");


        }catch (NamingException e){
            System.out.println(e);
        }
        catch (SQLException e) {

            System.out.println("</TITLE></HEAD><body bgcolor='#f8f7cd'>");
            System.out.println("<h1><font color=green>Test connection Failed </font></h1>");
            System.out.println("<br /><center><form><input type=\"button\" value=\"Go back\" onclick=\"history.back();return false;\"/></form></center>");

            e.printStackTrace();

        }
    }
}