module com.yrhacks.apps.yrschool {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.web;

    opens com.yrhacks.apps.yrschool to javafx.fxml;
    exports com.yrhacks.apps.yrschool;
}
