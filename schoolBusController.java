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

public class schoolBusController implements Initializable {
	
	@FXML
    private ImageView stop;

    @FXML
    private ImageView yield;

    @FXML
    private ImageView deadEnd;

    @FXML
    private ImageView runOver;

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
		this.yield.setImage(new Image("gui/BUS-YIELD.png"));
		this.runOver.setImage(new Image("gui/BUS-RUNOVER.png"));
		this.deadEnd.setImage(new Image("gui/BUS-DEADEND.png"));
		this.stop.setImage(new Image("gui/BUS-STOP.png"));
    }
}
