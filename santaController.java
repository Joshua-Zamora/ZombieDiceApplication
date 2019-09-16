package gui;

import javafx.application.Application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;

public class santaController implements Initializable {
	
	@FXML
    private ImageView energy;

    @FXML
    private ImageView helmet;
	
    @FXML
    void menuFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/menuFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void rulesFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/rulesFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
		this.energy.setImage(new Image("gui/SANTA-ENERGY.png"));
		this.helmet.setImage(new Image("gui/SANTA-HELMET.png"));
    }
}
