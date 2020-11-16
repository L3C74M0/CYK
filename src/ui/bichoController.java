package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import model.CYK;

public class bichoController {
	protected CYK cyk;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea grammar;

    @FXML
    private TextField w;

    @FXML
    void generate(ActionEvent event) throws FileNotFoundException {   	
    	saveGrammar();
    	boolean is = CYK.doSteps(w.getText());
    	if(is) {
    		Alert info = new Alert(AlertType.CONFIRMATION);
			info.setTitle("VOJABES QUE VOJABES");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("──────────────────────────────────\r\n" + 
					"────────────██████████────────────\r\n" + 
					"────────███████████████████───────\r\n" + 
					"──────███████████████████████─────\r\n" + 
					"────██████████████████████████────\r\n" + 
					"───█████████████▀──────────▀███───\r\n" + 
					"──█████████████──────────────███──\r\n" + 
					"─████████████────────────────████─\r\n" + 
					"─██████████───────────────────███─\r\n" + 
					"██████████▀───────────────────████\r\n" + 
					"████████▀─────────────────────████\r\n" + 
					"██████▀────────────────────────███\r\n" + 
					"█████──▄▀▀▀▀▀▀▀▄────▄▀▀▀▀▀▀▀▄──███\r\n" + 
					"█████────▄▄▄▄▄────────▄▄▄▄▄────███\r\n" + 
					"█████──▄▀───▄██▄────▄▀───▄██▄──███\r\n" + 
					"█████──▀▄───▀▀█▀────▀▄───▀▀█▀──███\r\n" + 
					"█▀──█────▀▀▀▀▀────────▀▀▀▀▀────███\r\n" + 
					"█───█──────────────────────────█─█\r\n" + 
					"█────────────────────▄───────────█\r\n" + 
					"█───────────▄▀────────▀▄─────────█\r\n" + 
					"▀█─▄█───────▀▄─▀██──██───────────█\r\n" + 
					"─▀██────────────────────────────██\r\n" + 
					"──██────▄▀▀──────█─█──────▀▀▄──██─\r\n" + 
					"───█──────█▀▄────▀─▀────▄▀█────█──\r\n" + 
					"───█──────▀──▀▀▄▄▄▄▄▄▄▀▀──▀────█──\r\n" + 
					"───▀█─────────────────────────█▀──\r\n" + 
					"────▀█───────────────────────█▀───\r\n" + 
					"─────▀█─────────────────────█▀────\r\n" + 
					"──────▀█───────────────────█▀─────\r\n" + 
					"───────▀█─────────────────█▀──────\r\n" + 
					"────────▀█───▄───────▄───█▀───────\r\n" + 
					"─────────▀█▄──▀▄▄▄▄▄▀──▄█▀────────\r\n" + 
					"───────────▀▀█▄▄▄▄▄▄▄█▀▀──────────\r\n" + 
					"────────────────███───────────────\r\n" + 
					"──────────────███████─────────────\r\n" + 
					"─────────────██─███─██────────────\r\n" + 
					"────────────██──███──██───────────\r\n" + 
					"───────────██───███───██──────────\r\n" + 
					"──────────██────███────██─────────\r\n" + 
					"\n\n\tSI LA ACEPTA");
			info.show();
    	}else {
    		Alert info = new Alert(AlertType.ERROR);
			info.setTitle("PAILANDER");
			info.setHeaderText(null);
			info.initStyle(StageStyle.UTILITY);
			info.setContentText("░░░░░░▄▄▄▄▀▀▀▀▀▀▀▀▄▄▄▄▄▄▄\r\n" + 
					"░░░░░█░░░░░░░░░░░░░░░░░░▀▀▄\r\n" + 
					"░░░░█░░░░░░░░░░░░░░░░░░░░░░█\r\n" + 
					"░░░█░░░░░░▄██▀▄▄░░░░░▄▄▄░░░░█\r\n" + 
					"░▄▀░▄▄▄░░█▀▀▀▀▄▄█░░░██▄▄█░░░░█\r\n" + 
					"█░░█░▄░▀▄▄▄▀░░░░░░░░█░░░░░░░░░█\r\n" + 
					"█░░█░█▀▄▄░░░░░█▀░░░░▀▄░░▄▀▀▀▄░█\r\n" + 
					"░█░▀▄░█▄░█▀▄▄░▀░▀▀░▄▄▀░░░░█░░█\r\n" + 
					"░░█░░░▀▄▀█▄▄░█▀▀▀▄▄▄▄▀▀█▀██░█\r\n" + 
					"░░░█░░░░██░░▀█▄▄▄█▄▄█▄▄██▄░░█\r\n" + 
					"░░░░█░░░░▀▀▄░█░░░█░█▀█▀█▀██░█\r\n" + 
					"░░░░░▀▄░░░░░▀▀▄▄▄█▄█▄█▄█▄▀░░█\r\n" + 
					"░░░░░░░▀▄▄░░░░░░░░░░░░░░░░░░░█\r\n" + 
					"░░▐▌░█░░░░▀▀▄▄░░░░░░░░░░░░░░░█\r\n" + 
					"░░░█▐▌░░░░░░█░▀▄▄▄▄▄░░░░░░░░█\r\n" + 
					"░░███░░░░░▄▄█░▄▄░██▄▄▄▄▄▄▄▄▀\r\n" + 
					"░▐████░░▄▀█▀█▄▄▄▄▄█▀▄▀▄\r\n" + 
					"░░█░░▌░█░░░▀▄░█▀█░▄▀░░░█\r\n" + 
					"░░█░░▌░█░░█░░█░░░█░░█░░█\r\n" + 
					"░░█░░▀▀░░██░░█░░░█░░█░░█\r\n" + 
					"░░░▀▀▄▄▀▀░█░░░▀▄▀▀▀▀█░░█\r\n" + 
					"░░░░░░░░░░█░░░░▄░░▄██▄▄▀\r\n" + 
					"░░░░░░░░░░█░░░░▄░░████\r\n" + 
					"░░░░░░░░░░█▄░░▄▄▄░░▄█\r\n" + 
					"░░░░░░░░░░░█▀▀░▄░▀▀█\r\n" + 
					"░░░░░░░░░░░█░░░█░░░█\r\n" + 
					"░░░░░░░░░░░█░░░▐░░░█\r\n" + 
					"░░░░░░░░░░░█░░░▐░░░█\r\n" + 
					"░░░░░░░░░░░█░░░▐░░░█\r\n" + 
					"░░░░░░░░░░░█░░░▐░░░█\r\n" + 
					"░░░░░░░░░░░█░░░▐░░░█\r\n" + 
					"░░░░░░░░░░░█▄▄▄▐▄▄▄█\r\n" + 
					"░░░░░░░▄▄▄▄▀▄▄▀█▀▄▄▀▄▄▄▄\r\n" + 
					"░░░░░▄▀▄░▄░▄░░░█░░░▄░▄░▄▀▄\r\n" + 
					"░░░░░█▄▄▄▄▄▄▄▄▄▀▄▄▄▄▄▄▄▄▄█\r\n" + 
					"\n\\n\tNO LA ACEPTA");
			info.show();
    	}
    }

    @FXML
    void initialize() {}
    
    protected void saveGrammar() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("src\\grammar.txt"));
        String r = grammar.getText();
        pw.print(r);
        pw.close();
    }
}