package co.za.testRestClient;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {


    public static void main(String[] args) throws  Exception {
       String q="create table currency589(id int(6), name varchar(56));";
     /*  Class.forName("com.mysql.jdbc.Driver");*/
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FOREX","root","root");
       Statement s=con.createStatement();
       s.executeUpdate(q);
       System.out.println("Table created");
 }
}
