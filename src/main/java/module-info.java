module com.example.digitalwatchtest2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.digitalwatchtest2 to javafx.fxml;
    exports com.example.digitalwatchtest2;
}