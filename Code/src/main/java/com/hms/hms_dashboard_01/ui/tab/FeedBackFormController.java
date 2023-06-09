package com.hms.hms_dashboard_01.ui.tab;
import com.hms.hms_dashboard_01.Validators.FeedBackFormValidator;
import com.hms.hms_dashboard_01.DTO.FeedBackDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FeedBackFormController {

    @FXML
    private TextField Description;

    @FXML
    private TextField stu_Name;

    @FXML
    private TextField Contact_No;

    @FXML
    private TextField Feed_Sub;

    @FXML
    private TextField Feed_category;

    @FXML
    private TextField Stu_ID;

    @FXML
    private TextField feed_Des;

    @FXML
    private  TextField Room_No;

    public void addFeedBack(ActionEvent e){
        if (FeedBackFormValidator.validateFields(Stu_ID, stu_Name, Contact_No, Room_No, Feed_Sub, Feed_category, feed_Des)) {

            FeedBackDTO FeedBack = HMSFactory.getInstanceOfFeedBack();
            FeedBack.setStu_ID(Integer.parseInt(Stu_ID.getText()));
            FeedBack.setstu_Name(String.join(stu_Name.getText()));
            FeedBack.setContact_No(String.join(Contact_No.getText()));
            FeedBack.setRoom_No(Integer.parseInt(Room_No.getText()));
            FeedBack.setFeed_Sub(String.join(Feed_Sub.getText()));
            FeedBack.setFeed_category(String.join(Feed_category.getText()));
            FeedBack.setfeed_Des(String.join(feed_Des.getText()));
            //Response
            System.out.println(FeedBack.getStu_ID());
            System.out.println(FeedBack.getstu_Name());
            System.out.println(FeedBack.getContact_No());
            System.out.println(FeedBack.getRoom_No());
            System.out.println(FeedBack.getFeed_Sub());
            System.out.println(FeedBack.getFeed_category());
            System.out.println(FeedBack.getfeed_Des());
        }
    }


}
