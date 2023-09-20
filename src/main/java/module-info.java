module com.tjelvargames.mathlogic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.tjelvargames.mathlogic to javafx.fxml;
    exports com.tjelvargames.mathlogic;
}