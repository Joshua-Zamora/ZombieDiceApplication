package gui;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import java.net.URL;
import java.util.ResourceBundle;

public class diceController implements Initializable {
	
	
	public static boolean b = false;
	
	public static boolean h = false;
	
	public static boolean s = false;
	
	public static boolean getBus() {
		return b;
	}
	
	public static boolean getHH() {
		return h;
	}
	
	public static boolean getSanta() {
		return s;
	}
	
	public static void setBus(boolean bz) {
		b = bz;
	}
	
	public static void setHH(boolean hz) {
		h = hz;
	}
	
	public static void setSanta(boolean sz) {
		s = sz;
	}

    @FXML private Button playButton;

    @FXML private Button bus;

    @FXML private Button hunkHottie;

    @FXML private Button santa;
	
	@FXML private Button train;

    @FXML private Button spaceShip;

    @FXML private Button scientist;

    @FXML private Button convict;

    @FXML
    void busIsPressed(ActionEvent event) {
		bus.setDisable(true);
		b = true;
    }

    @FXML
    void hhIsPressed(ActionEvent event) {
		hunkHottie.setDisable(true);
		h = true;
    }

    @FXML
    void santaIsPressed(ActionEvent event) {
		santa.setDisable(true);
		s = true;
    }

    @FXML
    void unSelect(ActionEvent event) {
		b = false;
		h = false;
		s = false;
		bus.setDisable(false);
		hunkHottie.setDisable(false);
		santa.setDisable(false);
    }
	
	@FXML
    void playFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/playFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void playerFXML(ActionEvent event) throws Exception {
		santa.setDisable(false);
		hunkHottie.setDisable(false);
		bus.setDisable(false);
		b = false;
		h = false;
		s = false;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/playersFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
		santa.setDisable(false);
		hunkHottie.setDisable(false);
		bus.setDisable(false);
		b = false;
		h = false;
		s = false;
    }
}
