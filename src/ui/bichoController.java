package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

public class bichoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField grammar;

    @FXML
    private TextField w;

    @FXML
    void generate(ActionEvent event) {
    	boolean is = false;
    	if(is) {
    		Alert info = new Alert(AlertType.CONFIRMATION);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("Si la genera");
			info.show();
    	}else {
    		Alert info = new Alert(AlertType.ERROR);
			info.setTitle("ERROR");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("No la genera");
			info.show();
    	}
    }

    @FXML
    void initialize() {

    }
}