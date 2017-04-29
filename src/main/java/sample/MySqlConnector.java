package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jaizm on 26/04/2017.
 */
public class MySqlConnector {


    private static final String DB = "jdbc:mysql://5.135.218.27:3306/pawelD?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "pawelD";
    private static final String USERPW = "jaizm";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static MySqlConnector ourInstance = new MySqlConnector();

    public static MySqlConnector getInstance() {
        return ourInstance;
    }

    private Connection connection;

    private MySqlConnector() {
        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB, USER, USERPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected");
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getNewStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
