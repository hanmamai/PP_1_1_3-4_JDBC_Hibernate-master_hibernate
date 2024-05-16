package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String BD_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BD_URL = "jdbc:mysql://localhost:3306/mybd";
    private static final String BD_LOGIN = "root";
    private static final String BD_PASSWORD = "root";

    public static Connection getConnection() {

        Connection connection = null;
        try {

            Class.forName(BD_DRIVER);
            connection = DriverManager.getConnection(BD_URL, BD_LOGIN, BD_PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }
}
