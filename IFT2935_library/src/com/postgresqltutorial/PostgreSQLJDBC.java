package com.postgresqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {

    public static Connection connection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "admin";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return connection;
    }
}