package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.RoomDTO;
import javafx.collections.ObservableList;

import java.sql.*;


public class DALRoomManager {

    static Connection conn = DatabaseConnection.getConnection();
    public static void addRoom(RoomDTO room) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO ROOMS (roomNo, roomType, roomCapacity, roomFloor, roomAvb, roomStatus, roomFee, roomAssignedTo, roomBuilding) " +
                    "VALUES (" + room.getRoomNo() + ", '" + room.getRoomType() + "', '" + room.getRoomCapacity() + "', '" + room.getRoomFloor() + "', '" + room.getRoomAvb() + "', '" + room.getRoomStatus() + "', " +
                    room.getRoomFee() + ", '" + room.getRoomAssignedTo() + "', '" + room.getRoomBuilding() + "')";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into ROOMS table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteRoom(int roomNo) {
        try {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM ROOMS WHERE roomNo = " + roomNo;

            stmt.executeUpdate(query);

            System.out.println("Data has been deleted from ROOMS table.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
