package gui;

import javafx.application.Application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import java.io.IOException;

public class rulesController implements Initializable {
	
    @FXML private Button classic;

    @FXML private Button bus;

    @FXML private Button hunkHottie;

    @FXML private Button santa;

    @FXML private Button convict;

    @FXML private Button scientist;

    @FXML private Button spaceShip;

    @FXML private Button train;
	
    @FXML
    void classicFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/classicFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void convictFXML(ActionEvent event) throws Exception {
		
    }

    @FXML
    void hunkHottieFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/hunkHottieFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void menuFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/menuFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void santaFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/santaFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void schoolBusFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/schoolBusFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void scientistFXML(ActionEvent event) throws Exception {

    }

    @FXML
    void spaceShipFXML(ActionEvent event) throws Exception {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
