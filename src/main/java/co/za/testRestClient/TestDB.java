package co.za.testRestClient;



import java.io.IOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.annotation.sql.*;
import javax.annotation.Resource.AuthenticationType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class JdbcServlet
 */

@WebServlet("/testDB")
public class TestDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDB() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Resource(name = "jdbc/MyDataSource", type = javax.sql.DataSource.class, shareable = true, authenticationType = AuthenticationType.CONTAINER)

    DataSource ds1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement stmt = null;
        Connection con = null;

        try {
            con = ds1.getConnection();

            stmt = con.createStatement();
            // create a table
            stmt.executeUpdate("create table Currency5 (CODE varchar(50) not null primary key,  NAME varchar(30))");
            // insert a test record
            stmt.executeUpdate("insert into Currency5 values ('AED', 'DIRHAM')");
            // select a record
            ResultSet result = stmt.executeQuery("select NAME from Currency5 where name='DIRHAM'");
            result.next();

            response.getWriter().print("</TITLE></HEAD><body bgcolor='#f8f7cd'>");
            response.getWriter().print("<h1><font color=green>Test connection successfull </font></h1>");
            response.getWriter().print("<br /><center><form><input type=\"button\" value=\"Go back\" onclick=\"history.back();return false;\"/></form></center>");


        }
        catch (SQLException e) {

            response.getWriter().print("</TITLE></HEAD><body bgcolor='#f8f7cd'>");
            response.getWriter().print("<h1><font color=green>Test connection Failed </font></h1>");
            response.getWriter().print("<br /><center><form><input type=\"button\" value=\"Go back\" onclick=\"history.back();return false;\"/></form></center>");

            e.printStackTrace();

        }
        finally {
            try {
                // drop the table to clean up and to be able to rerun the test.
                stmt.executeUpdate("drop table Currency5");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
        // TODO Auto-generated method stub
    }

}

