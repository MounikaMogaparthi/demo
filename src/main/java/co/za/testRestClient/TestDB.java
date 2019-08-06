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
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement stmt = null;
        Connection con = null;

        try {
            DataSource ds1 = (DataSource) new InitialContext().lookup("jdbc/demo");
            con = ds1.getConnection();

            stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("select CURRENCY_CODE from CURRENCY where CURRENCY_NAME='DIRHAM'");
            //result.next();

            response.getWriter().print("</TITLE></HEAD><body bgcolor='#f8f7cd'>");
            response.getWriter().print("<h1><font color=green>Test connection successfull </font></h1>");
            response.getWriter().print("<br /><center><form><input type=\"button\" value=\"Go back\" onclick=\"history.back();return false;\"/></form></center>");


        } catch (SQLException e) {
            response.getWriter().print("<pre>");
            e.printStackTrace(response.getWriter());
            response.getWriter().print("</pre>");
        } catch (NamingException e) {
            response.getWriter().print("<pre>");
            e.printStackTrace(response.getWriter());
            response.getWriter().print("</pre>");
        } finally {
//            try {
//                // drop the table to clean up and to be able to rerun the test.
//                stmt.executeUpdate("drop table Currency5");
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//            }
            try {
                if (con != null) con.close();
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
