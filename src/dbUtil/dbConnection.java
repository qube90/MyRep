package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {


    private static final String CONN = "jdbc:sqlite:D:\\programowanie\\pliki programów nauka\\Kamil1\\shop_data.sqlite";

    public static Connection getConnection() throws SQLException {

        try{
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(CONN);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;

    }

}
