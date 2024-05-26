package jm.task.core.jdbc.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    private static SessionFactory sessionFactory = null;

    public static Configuration getConfiguration() {
        return new Configuration()
                .setProperty("hibernate.driver_class", BD_DRIVER)
                .setProperty("hibernate.connection.url", BD_URL)
                .setProperty("hibernate.connection.username", BD_LOGIN)
                .setProperty("hibernate.connection.password", BD_PASSWORD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.current_session_context_class", "thread");

    }
    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }
    public static void close() throws HibernateException {
        getSession().close();
    }
}
