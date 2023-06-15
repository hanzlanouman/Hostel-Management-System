package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Room;
import com.hms.hms_dashboard_01.utility.path;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomController implements Initializable  {

    @FXML
    private TableView<Room> roomTable;

    @FXML
    private TableColumn<Room, String> roomAllocatedTo;

    @FXML
    private TableColumn<Room, Integer> roomFee;

    @FXML
    private TableColumn<Room, String> roomLocation;

    @FXML
    private TableColumn<Room, Integer> roomNo;

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


    public void addRoom(ActionEvent e) throws IOException {
//       set the stage scene to add room
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource(path.getPath("tab", "add_room_form")));
        stage.setTitle("Add Room");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }
}
