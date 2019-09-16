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

public class classicController implements Initializable {
	
	@FXML
    private ImageView greenBrain;

    @FXML
    private ImageView yellowFeet;

    @FXML
    private ImageView redShotgun;

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
		this.greenBrain.setImage(new Image("gui/GREEN-BRAIN.png"));
		this.yellowFeet.setImage(new Image("gui/YELLOW-FEET.png"));
		this.redShotgun.setImage(new Image("gui/RED-SHOTGUN.png"));
    }
}
