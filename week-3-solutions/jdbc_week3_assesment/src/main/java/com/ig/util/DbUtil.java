package com.ig.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DbUtil {
    private static Connection connection = null;

    static {
        try {
            Properties props = new Properties();
            InputStream input = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholar_db","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

