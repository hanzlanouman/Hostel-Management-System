package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.Alert.*;

public class RoomController implements Initializable {

    @FXML
    private TableView<Room> roomTable;
    @FXML
    private Button deleteRoom;

    @FXML
    private TableColumn<Room, String> roomAllocatedTo;

    @FXML
    private TableColumn<Room, Integer> roomFee;

    @FXML
    private TableColumn<Room, String> roomLocation;

    @FXML
    private TableColumn<Room, Integer> roomNo;
    @FXML
    private TextField searchBar;

    @FXML
    private TableColumn<Room, String> roomStatus;


//    Holds the data for the table view in the room tab of the admin/warden
    ObservableList<Room> roomList = FXCollections.observableArrayList(
            new Room(1, "Available", 1000, "None", "1st Floor"),
            new Room(2, "Available", 1000, "Ahmed", "1st Floor"),
            new Room(3, "Available", 1000, "St2", "1st Floor"),
            new Room(4, "Unavailable", 1000, "St8", "1st Floor")
    );
// Assign the values to the columns of the table view in the room tab of the admin/warden
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
//        roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomFee.setCellValueFactory(new PropertyValueFactory<>("roomFee"));
        roomStatus.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        roomAllocatedTo.setCellValueFactory(new PropertyValueFactory<>("roomAssignedTo"));
        roomLocation.setCellValueFactory(new PropertyValueFactory<>("roomLocation"));
        roomTable.setItems(roomList);

    }
    public void deleteRoom(ActionEvent e){
        Alert deleteRoomAlert = new Alert(AlertType.CONFIRMATION);
        deleteRoomAlert.setTitle("Delete Room");
        deleteRoomAlert.setHeaderText("Are you sure you want to delete this room?");
        if (deleteRoomAlert.showAndWait().get().equals(ButtonType.CANCEL)) {
            return;
        }
        roomTable.getItems().removeAll(roomTable.getSelectionModel().getSelectedItem());

    }


    public void addRoom(ActionEvent e){
//pop up an alert and ask for room details to add
        TextInputDialog addRoomDialog = new TextInputDialog();
        addRoomDialog.setTitle("Add Room");
        addRoomDialog.setHeaderText("Enter the room details");
        addRoomDialog.setContentText("Enter the room number:");
        addRoomDialog.showAndWait();
        int roomNo = Integer.parseInt(addRoomDialog.getEditor().getText());
        addRoomDialog.setContentText("Enter the room fee:");
        addRoomDialog.showAndWait();
        int roomFee = Integer.parseInt(addRoomDialog.getEditor().getText());
        addRoomDialog.setContentText("Enter the room location:");
        addRoomDialog.showAndWait();
        String roomLocation = addRoomDialog.getEditor().getText();
//        display a dropdown to select the room status
        ChoiceDialog<String> roomStatusDialog = new ChoiceDialog<>("Available", "Unavailable");
        roomStatusDialog.setTitle("Room Status");
        roomStatusDialog.setHeaderText("Select the room status");
        roomStatusDialog.setContentText("Room Status:");
        roomStatusDialog.showAndWait();

        String roomStatus = addRoomDialog.getEditor().getText();
        if(roomStatus.equals("Available")) {
            ChoiceDialog<String> roomAllocatedToDialog = new ChoiceDialog<>("None", "Ahmed", "Ali", "St2", "St8", "St9");
            roomAllocatedToDialog.setTitle("Room Allocated To");
            roomAllocatedToDialog.setHeaderText("Select the room allocated to");
            roomAllocatedToDialog.setContentText("Room Allocated To:");
            roomAllocatedToDialog.showAndWait();
            addRoomDialog.showAndWait();
            String roomAllocatedTo = addRoomDialog.getEditor().getText();

            roomTable.getItems().add(new Room(roomNo, roomStatus, roomFee, roomAllocatedTo, roomLocation));
        }
        else{
            roomTable.getItems().add(new Room(roomNo, roomStatus, roomFee, "None", roomLocation));
        }

    }
    public void search(ActionEvent e) {
//        filter out table view based on the search bar
        refresh();
        String search = searchBar.getText().toLowerCase();
        ObservableList<Room> filteredList = FXCollections.observableArrayList();
        for (Room room : roomList) {
            if (room.getRoomAssignedTo().toLowerCase().contains(search)) {
                filteredList.add(room);
            }
        }
        roomTable.setItems(filteredList);

    }
    public void refresh(){
//        refresh the table view
        roomTable.setItems(roomList);
    }
//    list down javaFx events
//    action event
//    mouse event
//    key event

    public void searchOnType() {
        String search = searchBar.getText().toLowerCase();
        ObservableList<Room> filteredList = FXCollections.observableArrayList();

        for (Room room : roomList) {
            if (room.getRoomAssignedTo().toLowerCase().contains(search)) {
                filteredList.add(room);
            }
        }

        roomTable.setItems(filteredList);
    }

}
