package gui;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.ImageCursor;
import javafx.scene.Cursor;
import javafx.scene.layout.AnchorPane;

public class playerController implements Initializable {
	
	public static boolean aa1 = false;
	
	public static boolean aa2 = false;
	
	public static boolean aa3 = false;
	
	public static boolean aa4 = false;
	
	public static boolean aa5 = false;
	
	public static boolean aa6 = false;
	
	public static boolean aa7 = false;
	
	public static boolean aa8 = false;
	
	public static int np = 0;
	
	public static int nc = 0;
	
	public static double previousPlayerValue = 0.0;
	
	public static double previousCPUValue = 0.0;
	
	@FXML
    void cursorToHand(MouseEvent event) {
		grid.setCursor(new ImageCursor(new Image("gui/zombieGrab.png"), 50.0, 50.0));
    }
	
	 @FXML
    void handToCursor(MouseEvent event) {
		grid.setCursor(Cursor.DEFAULT);
    }
	
	@FXML private AnchorPane grid;

    @FXML private Button nextButton;

    @FXML private Slider numPlayers;

    @FXML private Slider numCPU;

    @FXML private CheckBox a1;

    @FXML private CheckBox a5;

    @FXML private CheckBox a2;

    @FXML private CheckBox a6;

    @FXML private CheckBox a3;

    @FXML private CheckBox a7;

    @FXML private CheckBox a4;

    @FXML private CheckBox a8;
	
	@FXML private Label combinedAlert;
	
	@FXML private Label numAccountsAlert;
	
	public static void setNumP(int npz) {
		np = npz;
	}
	
	public static void setNumC(int ncz) {
		nc = ncz;
	}

	public static void setAccountOne(boolean aa1z) {
		aa1 = aa1z;
	}
	
	public static void setAccountTwo(boolean aa2z) {
		aa2 = aa2z;
	}
	
	public static void setAccountThree(boolean aa3z) {
		aa3 = aa3z;
	}
	
	public static void setAccountFour(boolean aa4z) {
		aa4 = aa4z;
	}
	
	public static void setAccountFive(boolean aa5z) {
		aa5 = aa5z;
	}
	
	public static void setAccountSix(boolean aa6z) {
		aa6 = aa6z;
	}
	
	public static void setAccountSeven(boolean aa7z) {
		aa7 = aa7z;
	}
	
	public static void setAccountEight(boolean aa8z) {
		aa8 = aa8z;
	}
	
	public static int getNumP() {
		return np;
	}
	
	public static int getNumC() {
		return nc;
	}
	
	public static boolean getAccountOne() {
		return aa1;
	}
	
	public static boolean getAccountTwo() {
		return aa2;
	}
	
	public static boolean getAccountThree() {
		return aa3;
	}
	
	public static boolean getAccountFour() {
		return aa4;
	}
	
	public static boolean getAccountFive() {
		return aa5;
	}
	
	public static boolean getAccountSix() {
		return aa6;
	}
	
	public static boolean getAccountSeven() {
		return aa7;
	}
	
	public static boolean getAccountEight() {
		return aa8;
	}
	
	public static int sum = 0;
	
	 @FXML
    void checkAccountsToPlayersRatioEight(ActionEvent event) {
		if(!a8.isSelected()) {
			aa8 = false;
			--sum;
			return;
		}
		else if(a8.isSelected()) ++sum;

		if(a8.isSelected() && sum <= np && np != 0) { 
			aa8 = true; 
		}
		else if(a8.isSelected() && sum > np) { 
			a8.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa8 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioFive(ActionEvent event) {
		if(!a5.isSelected()) {
			aa5 = false;
			--sum;
			return;
		}
		else if(a5.isSelected()) ++sum;

		if(a5.isSelected() && sum <= np && np != 0) { 
			aa5 = true; 
		}
		else if(a5.isSelected() && sum > np) { 
			a5.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa5 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioFour(ActionEvent event) {
		if(!a4.isSelected()) {
			aa4 = false;
			--sum;
			return;
		}
		else if(a4.isSelected()) ++sum;

		if(a4.isSelected() && sum <= np && np != 0) { 
			aa4 = true; 
		}
		else if(a4.isSelected() && sum > np) { 
			a4.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa4 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioOne(ActionEvent event) {
		if(!a1.isSelected()) {
			aa1 = false;
			--sum;
			return;
		}
		else if(a1.isSelected()) ++sum;
		
		if(a1.isSelected() && sum <= np && np != 0) { 
			aa1 = true; 
		}
		else if(a1.isSelected() && sum > np) { 
			a1.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa1 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioSeven(ActionEvent event) {
		if(!a7.isSelected()) {
			aa7 = false;
			--sum;
			return;
		}
		else if(a7.isSelected()) ++sum;

		if(a7.isSelected() && sum <= np && np != 0) { 
			aa7 = true; 
		}
		else if(a7.isSelected() && sum > np) { 
			a7.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa7 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioSix(ActionEvent event) {
		if(!a6.isSelected()) {
			aa6 = false;
			--sum;
			return;
		}
		else if(a6.isSelected()) ++sum;

		if(a6.isSelected() && sum <= np && np != 0) { 
			aa6 = true; 
		}
		else if(a6.isSelected() && sum > np) { 
			a6.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa6 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioThree(ActionEvent event) {
		if(!a3.isSelected()) {
			aa3 = false;
			--sum;
			return;
		}
		else if(a3.isSelected()) ++sum;

		if(a3.isSelected() && sum <= np && np != 0) { 
			aa3 = true; 
		}
		else if(a3.isSelected() && sum > np) { 
			a3.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa3 = false;
			--sum;
		}
    }

    @FXML
    void checkAccountsToPlayersRatioTwo(ActionEvent event) {
		if(!a2.isSelected()) {
			aa2 = false;
			--sum;
			return;
		}
		else if(a2.isSelected()) ++sum;

		if(a2.isSelected() && sum <= np && np != 0) { 
			aa2 = true; 
		}
		else if(a2.isSelected() && sum > np) { 
			a2.setSelected(false);
			numAccountsAlert.setVisible(true);
			aa2 = false;
			--sum;
		}
    }
	
    @FXML
    void checkCurrentCPUValue(MouseEvent event) {
		np = (int)numPlayers.getValue();
		nc = (int)numCPU.getValue();
		if(np == 0 || np == 1) {
			sum = 0;
			a1.setSelected(false);
			a2.setSelected(false);
			a3.setSelected(false);
			a4.setSelected(false);
			a5.setSelected(false);
			a6.setSelected(false);
			a7.setSelected(false);
			a8.setSelected(false);
		}
		
		if(nc == 0 && np < 2) {
			nextButton.setDisable(true);
			return;
		}
		if(np + nc > 8) {
			combinedAlert.setVisible(true);
			numCPU.setValue(previousCPUValue);
			return;
		}
		if(np == 0 && nc == 1) {
			numPlayers.setValue(1.0);
		}
		nextButton.setDisable(false);
		numAccountsAlert.setVisible(false);
		combinedAlert.setVisible(false);
    }

    @FXML
    void checkCurrentPlayerValue(MouseEvent event) {
		nc = (int)numCPU.getValue();
		np = (int)numPlayers.getValue();
		if(np == 0 || np == 1) {
			sum = 0;
			a1.setSelected(false);
			a2.setSelected(false);
			a3.setSelected(false);
			a4.setSelected(false);
			a5.setSelected(false);
			a6.setSelected(false);
			a7.setSelected(false);
			a8.setSelected(false);
		}
		
		if(nc < 2 && np == 0) {
			nextButton.setDisable(true);
			return;
		}
		if(np + nc > 8) {
			combinedAlert.setVisible(true);
			numPlayers.setValue(previousPlayerValue);
			return;
		}
		if(np == 1 && nc == 0) {
			numCPU.setValue(1.0);
		}
		nextButton.setDisable(false);
		numAccountsAlert.setVisible(false);
		combinedAlert.setVisible(false);
    }
	
	@FXML
    void getPreviousValue(MouseEvent event) {
		previousPlayerValue = numPlayers.getValue();
		previousCPUValue = numCPU.getValue();
    }

    @FXML
    void diceFXML(ActionEvent event) throws Exception {
		setNumP((int)numPlayers.getValue());
		setNumC((int)numCPU.getValue());
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/diceFXML.fxml"));
		
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
		try {
			if(new File("gui/1.txt").isFile()) {
				a1.setDisable(false);
				Scanner s1 = new Scanner(new File("gui/1.txt")); 
				a1.setText(s1.nextLine());
			}
			if(new File("gui/2.txt").isFile()) { 
				a2.setDisable(false); 
				Scanner s2 = new Scanner(new File("gui/2.txt")); 
				a2.setText(s2.nextLine());
			}
			if(new File("gui/3.txt").isFile()) {
				a3.setDisable(false);
				Scanner s3 = new Scanner(new File("gui/3.txt")); 
				a3.setText(s3.nextLine());
			}
			if(new File("gui/4.txt").isFile()) {
				a4.setDisable(false);
				Scanner s4 = new Scanner(new File("gui/4.txt")); 
				a4.setText(s4.nextLine());
			}
			if(new File("gui/5.txt").isFile()) {
				a5.setDisable(false);
				Scanner s5 = new Scanner(new File("gui/5.txt")); 
				a5.setText(s5.nextLine());
			}
			if(new File("gui/6.txt").isFile()) {
				a6.setDisable(false);
				Scanner s6 = new Scanner(new File("gui/6.txt")); 
				a6.setText(s6.nextLine());
			}
			if(new File("gui/7.txt").isFile()) {
				a7.setDisable(false);
				Scanner s7 = new Scanner(new File("gui/7.txt")); 
				a7.setText(s7.nextLine());
			}
			if(new File("gui/8.txt").isFile()) {
				a8.setDisable(false);
				Scanner s8 = new Scanner(new File("gui/8.txt")); 
				a8.setText(s8.nextLine());
			}
		} catch(FileNotFoundException except) {
		}
		this.numPlayers.setValue(0.0);
		this.numCPU.setValue(0.0);
		this.aa1 = false;
		this.aa2 = false;
		this.aa3 = false;
		this.aa4 = false;
		this.aa5 = false;
		this.aa6 = false;
		this.aa7 = false;
		this.aa8 = false;
		this.a1.setSelected(false);
		this.a2.setSelected(false);
		this.a3.setSelected(false);
		this.a4.setSelected(false);
		this.a5.setSelected(false);
		this.a6.setSelected(false);
		this.a7.setSelected(false);
		this.a8.setSelected(false);
		this.sum = 0;
    }
}
