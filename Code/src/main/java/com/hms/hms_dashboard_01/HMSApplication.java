package com.hms.hms_dashboard_01;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import fx image
import javafx.scene.image.Image;

import java.io.IOException;


public class HMSApplication extends Application {

    public static void main(String[] args){
        launch(args);
    }


    //set the stage and loads up the login page
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hms_login.fxml"));
        primaryStage.setTitle("Hostel Management System");
        Image hms_icon = new Image(getClass().getResourceAsStream("icon.png"));
//        primaryStage.setResizable(false);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.getIcons().add(hms_icon);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


}