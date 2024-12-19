/**
 * 
 */
/**
 * 
 */
module AimsProject {
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.swing;
    requires javafx.fxml;
    requires javafx.controls;
    opens hust.soict.ite6.aims.screen to javafx.fxml;
    opens hust.soict.ite6.aims.media to javafx.base;
    opens hust.soict.ite6.aims.screen.controller to javafx.fxml;
}