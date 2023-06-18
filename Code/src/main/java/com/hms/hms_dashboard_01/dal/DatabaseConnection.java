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

//   Get data from hmsdemo table
    public static void getTables(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hmsdemo");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    insert data into hmsdemo table
    public static void insertData(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("INSERT INTO ROOMS (roomNo, roomType, roomCapacity, roomFloor, roomAvb, roomStatus, roomFee, roomAssignedTo, roomBuilding)\n" +
                    "VALUES (1, 'Standard', '2', '1st Floor', 'Available', 'Vacant', 100, 'John Doe', 'Main Building')");
            while
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        Connection conn = getConnection();
        getTables(conn);
        insertData(conn);
        closeConnection(conn);
    }


}
