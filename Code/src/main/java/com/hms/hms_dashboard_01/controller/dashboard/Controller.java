package com.hms.hms_dashboard_01.controller.dashboard;

import com.hms.hms_dashboard_01.utility.path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class Controller implements Initializable {
Stage stage;
@FXML
    private Button logoutButton;
@FXML
Label greet;
@FXML
Button roomButton;
@FXML
    StackPane contentArea;

    @FXML
    private Button staffButton;

    @FXML
    private Button studentButton;
    @FXML
    private Button facilityButton;

    @FXML
    private Button feeButton;

    @FXML
    private Button homeButton;
@FXML
    Button wardenButton;
    @FXML
            Button messButton;

//Save all FXML buttons in a list
//    List has all the buttons for changing styles and scenes
    ArrayList<Button> buttons = new ArrayList<>();


// handle all the button clicks and change the scene accordingly

    public void logout(ActionEvent event) throws IOException {
        Alert logOutAlert = new Alert(Alert.AlertType.CONFIRMATION);
        logOutAlert.setTitle("Log Out");
        logOutAlert.setHeaderText("Are you sure you want to log out?");
        if(logOutAlert.showAndWait().get() == ButtonType.OK){

        Parent root = FXMLLoader.load(getClass().getResource(path.getPath("loginregister", "hms_login")));
        Stage stage = (Stage) logoutButton.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
        }

    }

    public void homeButton(ActionEvent event) throws IOException {
        activeButton(homeButton);
        changeScene("hms_home_tab");
    }

    public void greet(String username){
    greet.setText("Hi, "+username);

    }
//    public void notificationBtn(MouseEvent event) throws IOException {
//        System.out.println("Notification button clicked");
//    }


    public void roomButton(ActionEvent event) throws IOException {
        activeButton(roomButton);
        changeScene("hms_room_tab");
    };
    public void wardenButton(ActionEvent event) throws IOException {
        activeButton(wardenButton);
        changeScene("hms_wardens_tab");
    }
    public void messButton(ActionEvent event) throws IOException {
        activeButton(messButton);
        changeScene("hms_messmenu_tab");
    }
    public void studentButton(ActionEvent event) throws IOException {
        activeButton(studentButton);
        changeScene("hms_student_tab");
    }
    public void staffButton(ActionEvent event) throws IOException {
        activeButton(staffButton);
        changeScene("hms_staff_tab");
    }

    public void setHomeButton() throws IOException {
        activeButton(homeButton);
        changeScene("hms_home_tab");
    }

    public void feeButton(ActionEvent event) throws IOException {
        activeButton(feeButton);
        changeScene("hms_fee_tab");
    }
    public void facilityButton(ActionEvent event) throws IOException {
        activeButton(facilityButton);
        changeScene("hms_facilities_tab");
    }
    public void notificationBtn(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("hms_pendingRegistrations"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    buttons.addAll(Arrays.asList(messButton,homeButton, roomButton, staffButton, studentButton, facilityButton, feeButton, wardenButton));
        activeButton(homeButton);

// Doesn't work for some reason, intention was to load the home tab on login
//        try {
//            setHomeButton();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
//    resets the style of all buttons to default
    public void resetStyles() {
//        apply default style to all buttons
        for (Button button : buttons) {
            if (button != null) {
                button.setStyle("-fx-background-color: #449");
            }
        }
    }

//    changes the style of the button to indicate that it is active and deactivates the other buttons
    public void activeButton(Button button){
        resetStyles();
        if(button != null) button.setStyle("-fx-background-color: #66d457");
    }


    //Updated the stack pane (right hand content area) with the new fxml file passed as a parameter to the method
    public void changeScene(String fxml) throws IOException {
        Parent contentView = FXMLLoader.load(getClass().getResource(path.getPath("tab", fxml)));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(contentView);
    }
}
