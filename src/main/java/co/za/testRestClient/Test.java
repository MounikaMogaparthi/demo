package co.za.testRestClient;

import co.za.ned.model.Currency;
import com.google.gson.Gson;

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
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.*;


public class Test {
    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("/home/mounika/Documents/CurrencyCode.json.odt")) {

            // Convert JSON File to Java Object
            Currency currency = gson.fromJson(reader, Currency.class);

            // print staff object
            System.out.println(currency);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




