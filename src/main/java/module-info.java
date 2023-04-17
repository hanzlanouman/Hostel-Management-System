module com.hms.hms_dashboard_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.hms.hms_dashboard_01 to javafx.fxml;
    exports com.hms.hms_dashboard_01;
}