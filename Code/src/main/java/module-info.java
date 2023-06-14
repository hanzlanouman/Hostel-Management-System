module com.hms.hms_dashboard_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.hms.hms_dashboard_01 to javafx.fxml;
    opens com.hms.hms_dashboard_01.controller to javafx.fxml;
    opens com.hms.hms_dashboard_01.model.registration to javafx.fxml;
    opens com.hms.hms_dashboard_01.model.entities to javafx.fxml;

    exports com.hms.hms_dashboard_01;
    exports com.hms.hms_dashboard_01.controller;
    exports com.hms.hms_dashboard_01.model.registration;
    exports com.hms.hms_dashboard_01.model.entities;
    exports com.hms.hms_dashboard_01.controller.dashboard;
    opens com.hms.hms_dashboard_01.controller.dashboard to javafx.fxml;
    exports com.hms.hms_dashboard_01.controller.tab;
    opens com.hms.hms_dashboard_01.controller.tab to javafx.fxml;
}
