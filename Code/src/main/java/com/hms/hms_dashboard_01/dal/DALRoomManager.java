package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.model.entities.Room;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class DALRoomManager {

    static Connection conn = DatabaseConnection.getConnection();
    public static String addRoom(RoomDTO room) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO ROOMS (roomNo, roomType, roomCapacity, roomFloor, roomAvb, roomStatus, roomFee, roomAssignedTo, roomBuilding) " +
                    "VALUES (" + room.getRoomNo() + ", '" + room.getRoomType() + "', '" + room.getRoomCapacity() + "', '" + room.getRoomFloor() + "', '" + room.getRoomAvb() + "', '" + room.getRoomStatus() + "', " +
                    room.getRoomFee() + ", '" + room.getRoomAssignedTo() + "', '" + room.getRoomBuilding() + "')";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into ROOMS table.");
            return "success";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "fail";
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

//    Get a List of Room DTO That gets all Entries in room table
    public static List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Rooms");

            while (rs.next()) {
                Room room = new Room();
                room.setRoomNo(rs.getInt("roomNo"));
                room.setRoomType(rs.getString("roomType"));
                room.setRoomCapacity(rs.getString("roomCapacity"));
                room.setRoomFloor(rs.getString("roomFloor"));
                room.setRoomAvb(rs.getString("roomAvb"));
                room.setRoomStatus(rs.getString("roomStatus"));
                room.setRoomFee(rs.getInt("roomFee"));
                room.setRoomAssignedTo(rs.getString("roomAssignedTo"));
                room.setRoomBuilding(rs.getString("roomBuilding"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return rooms;
    }
}
