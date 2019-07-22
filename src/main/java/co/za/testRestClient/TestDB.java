package co.za.testRestClient;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {

   public static void main(String[] args) throws  Exception {
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Hr","manager");

 }
}
