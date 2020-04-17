module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.GUI to javafx.fxml;
    exports org.GUI;
}