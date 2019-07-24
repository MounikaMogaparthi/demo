package co.za.testRestClient;

import java.io.Serializable;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class TestDB implements Serializable {
    private DataSource dataSource;

    public TestDB() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)
                    initContext.lookup("java:/comp/TestDB");
            dataSource = (DataSource) envContext.lookup("jdbc/demo");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {
        TestDB testDB=new TestDB();
        testDB.isConnectedOK();

    }
        public boolean isConnectedOK () {
            try (Connection conn = dataSource.getConnection()) {
                return !conn.isClosed();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}