module com.hms.hms_dashboard_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;


    opens com.hms.hms_dashboard_01 to javafx.fxml;
    opens com.hms.hms_dashboard_01.ui to javafx.fxml;
    opens com.hms.hms_dashboard_01.model.registration to javafx.fxml;
    opens com.hms.hms_dashboard_01.model.entities to javafx.fxml;
    opens com.hms.hms_dashboard_01.DTO to javafx.base;
    exports com.hms.hms_dashboard_01;
    exports com.hms.hms_dashboard_01.ui;
    exports com.hms.hms_dashboard_01.model.registration;
    exports com.hms.hms_dashboard_01.model.entities;
    exports com.hms.hms_dashboard_01.ui.dashboard;
    opens com.hms.hms_dashboard_01.ui.dashboard to javafx.fxml;
    exports com.hms.hms_dashboard_01.ui.tab;
    opens com.hms.hms_dashboard_01.ui.tab to javafx.fxml;
}
