module com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic to javafx.fxml;
    exports com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic;
    exports com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;
    opens com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller to javafx.fxml;
}