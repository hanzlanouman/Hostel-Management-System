package com.hms.hms_dashboard_01.dal;
import java.sql.*;
public class DatabaseConnection {
// Connect to database using JDBC

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:oracle:thin:@//localhost:1521/hmspdb";
            // create a connection to the database
            conn = DriverManager.getConnection(url, "hms_dba", "hms123");

            System.out.println("Connection to hmspdb has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
            System.out.println("Connection to hmspdb has been closed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
