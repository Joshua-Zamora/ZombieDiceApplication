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
import javafx.scene.layout.AnchorPane;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;

public class accountController implements Initializable {
	
	public int accountNum = 0;
	
	public int deleteNum = 0;
	
	public static int open = 0;
	
	@FXML private ResourceBundle resources;

    @FXML private URL location;

	@FXML private Button c1;

    @FXML private Button c2;

    @FXML private Button c3;

    @FXML private Button c4;

    @FXML private Button c5;

    @FXML private Button c6;

    @FXML private Button c7;

    @FXML private Button c8;

    @FXML private Button a1;

    @FXML private Button d1;

    @FXML private Button d2;

    @FXML private Button d3;

    @FXML private Button d4;

    @FXML private Button a2;

    @FXML private Button a3;

    @FXML private Button a4;

    @FXML private Button a5;

    @FXML private Button a6;

    @FXML private Button a7;

    @FXML private Button a8;

    @FXML private Button d5;

    @FXML private Button d6;

    @FXML private Button d7;

    @FXML private Button d8;

    @FXML private Label usernameLabel;

    @FXML private Label passwordLabel;

    @FXML private Button confirmCreate;

    @FXML private Button cancelCreate;

    @FXML private TextField password;

    @FXML private TextField userName;

    @FXML private Button confirmDelete;

    @FXML private Button cancelDelete;
	
	@FXML private Text accountCreationLabel;
	
	@FXML private Text accountDeletionLabel;
	
	@FXML private Label note;

    @FXML private Label passwordWarning;

    @FXML private Label userNameWarning;
	
	@FXML private Pane passwordFade;

    @FXML private Pane userNameFade;
	
	@FXML private Label passwordLabelDelete;

    @FXML private Pane passwordFade1;

    @FXML private TextField password1;
	
	@FXML private Label passwordWarning1;
	
	public static int getOpen() {
		return open;
	}
	
	public void resetAll() {
		a1.setDisable(true);
		c1.setDisable(false);
		d1.setDisable(true);
		a2.setDisable(true);
		c2.setDisable(false);
		d2.setDisable(true);
		a3.setDisable(true);
		c3.setDisable(false);
		d3.setDisable(true);
		a4.setDisable(true);
		c4.setDisable(false);
		d4.setDisable(true);
		a5.setDisable(true);
		c5.setDisable(false);
		d5.setDisable(true);
		a6.setDisable(true);
		c6.setDisable(false);
		d6.setDisable(true);
		a7.setDisable(true);
		c7.setDisable(false);
		d7.setDisable(true);
		a8.setDisable(true);
		c8.setDisable(false);
		d8.setDisable(true);
		if(new File("gui/1.txt").isFile()) {
			a1.setDisable(false);
			c1.setDisable(true);
			d1.setDisable(false);
		}
		if(new File("gui/2.txt").isFile()) {
			a2.setDisable(false);
			c2.setDisable(true);
			d2.setDisable(false);
		}
		if(new File("gui/3.txt").isFile()) {
			a3.setDisable(false);
			c3.setDisable(true);
			d3.setDisable(false);
		}
		if(new File("gui/4.txt").isFile()) {
			a4.setDisable(false);
			c4.setDisable(true);
			d4.setDisable(false);
		}
		if(new File("gui/5.txt").isFile()) {
			a5.setDisable(false);
			c5.setDisable(true);
			d5.setDisable(false);
		}
		if(new File("gui/6.txt").isFile()) {
			a6.setDisable(false);
			c6.setDisable(true);
			d6.setDisable(false);
		}
		if(new File("gui/7.txt").isFile()) {
			a7.setDisable(false);
			c7.setDisable(true);
			d7.setDisable(false);
		}
		if(new File("gui/8.txt").isFile()) {
			a8.setDisable(false);
			c8.setDisable(true);
			d8.setDisable(false);
		}
		
		passwordWarning1.setVisible(false);
		passwordFade1.setVisible(false);
		password1.setVisible(false);
		passwordLabelDelete.setVisible(false);
		accountDeletionLabel.setVisible(false);
		cancelDelete.setVisible(false);
		cancelDelete.setDisable(true);
		confirmDelete.setDisable(true);
		confirmDelete.setVisible(false);
		accountCreationLabel.setVisible(false);
		usernameLabel.setVisible(false);
		passwordLabel.setVisible(false);
		password.setDisable(true);
		userName.setDisable(true);
		password.setVisible(false);
		userName.setVisible(false);
		userNameFade.setVisible(true);
		passwordFade.setVisible(true);
		confirmCreate.setDisable(true);
		cancelCreate.setDisable(true);
		confirmCreate.setVisible(false);
		cancelCreate.setVisible(false);
		passwordWarning.setVisible(false);
		userNameWarning.setVisible(false);
		note.setVisible(false);
		accountNum = 0;
		deleteNum = 0;
		open = 0;
		password.clear();
		userName.clear();
	}
	
	void disableAll() {
		a1.setDisable(true);
		c1.setDisable(true);
		d1.setDisable(true);
		a2.setDisable(true);
		c2.setDisable(true);
		d2.setDisable(true);
		a3.setDisable(true);
		c3.setDisable(true);
		d3.setDisable(true);
		a4.setDisable(true);
		c4.setDisable(true);
		d4.setDisable(true);
		a5.setDisable(true);
		c5.setDisable(true);
		d5.setDisable(true);
		a6.setDisable(true);
		c6.setDisable(true);
		d6.setDisable(true);
		a7.setDisable(true);
		c7.setDisable(true);
		d7.setDisable(true);
		a8.setDisable(true);
		c8.setDisable(true);
		d8.setDisable(true);
	}
	
	void prepareDelete()  { 
	try {
		switch(deleteNum) {
			case 1: if(new File("gui/1.txt").isFile()) {
					Scanner s1 = new Scanner(new File("gui/1.txt"));
					String temp1 = s1.nextLine();
					s1.close();
					temp1 = temp1.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp1 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 1"); 
					break;
			case 2: if(new File("gui/2.txt").isFile()) {
					Scanner s2 = new Scanner(new File("gui/2.txt"));
					String temp2 = s2.nextLine();
					s2.close();
					temp2 = temp2.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp2 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 2"); 
					break;
			case 3: if(new File("gui/3.txt").isFile()) {
					Scanner s3 = new Scanner(new File("gui/3.txt"));
					String temp3 = s3.nextLine();
					s3.close();
					temp3 = temp3.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp3 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 3"); 
					break;
			case 4: if(new File("gui/4.txt").isFile()) {
					Scanner s4 = new Scanner(new File("gui/4.txt"));
					String temp4 = s4.nextLine();
					s4.close();
					temp4 = temp4.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp4 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 4"); 
					break;
			case 5: if(new File("gui/5.txt").isFile()) {
					Scanner s5 = new Scanner(new File("gui/5.txt"));
					String temp5 = s5.nextLine();
					s5.close();
					temp5 = temp5.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp5 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 5"); 
					break;
			case 6: if(new File("gui/6.txt").isFile()) {
					Scanner s6 = new Scanner(new File("gui/6.txt"));
					String temp6 = s6.nextLine();
					s6.close();
					temp6 = temp6.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp6 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 6"); 
					break;
			case 7: if(new File("gui/7.txt").isFile()) {
					Scanner s7 = new Scanner(new File("gui/7.txt"));
					String temp7 = s7.nextLine();
					s7.close();
					temp7 = temp7.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp7 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 7"); 
					break;
			case 8:if(new File("gui/8.txt").isFile()) {
					Scanner s8 = new Scanner(new File("gui/8.txt"));
					String temp8 = s8.nextLine();
					s8.close();
					temp8 = temp8.replaceAll("\\s+|Name:","");
					accountDeletionLabel.setText("DELETE   " + temp8 + "'s   ACCOUNT");
					}
					else accountDeletionLabel.setText("DELETE ACCOUNT 8"); 
					break;
			default: break;
		}
	} catch(IOException e1) {
	} 
		accountDeletionLabel.setVisible(true);
		passwordFade1.setVisible(true);
		password1.setVisible(true);
		passwordLabelDelete.setVisible(true);
		cancelDelete.setVisible(true);
		cancelDelete.setDisable(false);
		confirmDelete.setDisable(false);
		confirmDelete.setVisible(true);
		disableAll();
	}
	
	void prepareCreate() {
		switch(accountNum) {
			case 1: accountCreationLabel.setText("CREATE     ACCOUNT     1"); break;
			case 2: accountCreationLabel.setText("CREATE     ACCOUNT     2"); break;
			case 3: accountCreationLabel.setText("CREATE     ACCOUNT     3"); break;
			case 4: accountCreationLabel.setText("CREATE     ACCOUNT     4"); break;
			case 5: accountCreationLabel.setText("CREATE     ACCOUNT     5"); break;
			case 6: accountCreationLabel.setText("CREATE     ACCOUNT     6"); break;
			case 7: accountCreationLabel.setText("CREATE     ACCOUNT     7"); break;
			case 8: accountCreationLabel.setText("CREATE     ACCOUNT     8"); break;
			default: break;
		}
		accountCreationLabel.setVisible(true);
		usernameLabel.setVisible(true);
		passwordLabel.setVisible(true);
		password.setDisable(false);
		userName.setDisable(false);
		password.setVisible(true);
		userName.setVisible(true);
		userNameFade.setVisible(true);
		passwordFade.setVisible(true);
		confirmCreate.setDisable(false);
		cancelCreate.setDisable(false);
		confirmCreate.setVisible(true);
		cancelCreate.setVisible(true);
		disableAll();
	}
	
	@FXML
    void cancelUniversal(ActionEvent event) {
		resetAll();
    }
	
	@FXML
    void deleteUniversal(ActionEvent event) throws IOException {
		String[] values = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
		int j = 0;
		switch(deleteNum) {
			case 1: Scanner d = new Scanner(new File("gui/1.txt"));
					while(d.hasNext()) { values[j] = d.next(); ++j; }
					d.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/1.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 2: Scanner d1 = new Scanner(new File("gui/2.txt"));
					while(d1.hasNext()) { values[j] = d1.next(); ++j; }
					d1.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/2.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 3: Scanner d2 = new Scanner(new File("gui/3.txt"));
					while(d2.hasNext()) { values[j] = d2.next(); ++j; }
					d2.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/3.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 4: Scanner d3 = new Scanner(new File("gui/4.txt"));
					while(d3.hasNext()) { values[j] = d3.next(); ++j; }
					d3.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/4.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 5: Scanner d4 = new Scanner(new File("gui/5.txt"));
					while(d4.hasNext()) { values[j] = d4.next(); ++j; }
					d4.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/5.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 6: Scanner d5 = new Scanner(new File("gui/6.txt"));
					while(d5.hasNext()) { values[j] = d5.next(); ++j; }
					d5.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/6.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 7: Scanner d7 = new Scanner(new File("gui/7.txt"));
					while(d7.hasNext()) { values[j] = d7.next(); ++j; }
					d7.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/7.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			case 8: Scanner d8 = new Scanner(new File("gui/8.txt"));
					while(d8.hasNext()) { values[j] = d8.next(); ++j; }
					d8.close();
					if(password1.getText().equals(values[13])) {
						(new File("gui/8.txt")).delete();
					}
					else {
						passwordWarning1.setVisible(true);
						return;
					}
					break;
			default: break;
		}
		resetAll();
    }
	
	@FXML
    void createUniversal(ActionEvent event) throws Exception {
		if(userName.getText().contains(" ")) {
			userNameWarning.setText("No Spaces!");
			userNameWarning.setVisible(true);
			if(password.getText().contains(" ")) {
				passwordWarning.setText("No Spaces!");
				passwordWarning.setVisible(true);
			}
			else passwordWarning.setVisible(false);
			return;
		}
		else if(password.getText().contains(" ")) {
			passwordWarning.setText("No Spaces!");
			passwordWarning.setVisible(true);
			return;
		}
		
		if(userName.getText().length() > 7) {
			userNameWarning.setText("Too Long!");
			userNameWarning.setVisible(true);
			note.setVisible(true);
			if(password.getText().length() > 7) {
			passwordWarning.setText("Too Long!");
			passwordWarning.setVisible(true);
			}
			else if(password.getText().length() == 0) {
				passwordWarning.setText("Too Short!");
				passwordWarning.setVisible(true);
			}
			else passwordWarning.setVisible(false);
			return;
		}
		else if(userName.getText().length() == 0) {
			userNameWarning.setText("Too Short!");
			userNameWarning.setVisible(true);
			note.setVisible(true);
			if(password.getText().length() > 7) {
				passwordWarning.setText("Too Long!");
				passwordWarning.setVisible(true);
			}
			else if(password.getText().length() == 0) {
				passwordWarning.setText("Too Short!");
				passwordWarning.setVisible(true);
			}
			else passwordWarning.setVisible(false);
			return;
		}
		else userNameWarning.setVisible(false);
		note.setVisible(false);
		
		if(password.getText().length() > 7) {
			passwordWarning.setText("Too Long!");
			passwordWarning.setVisible(true);
			note.setVisible(true);
			return;
		}
		else if(password.getText().length() == 0) {
			passwordWarning.setText("Too Short!");
			passwordWarning.setVisible(true);
			note.setVisible(true);
			return;
		}
		
		new Player(userName.getText(), 0, 0, 0, 0, 0, password.getText(), accountNum).store();
		resetAll();
    }

    @FXML
    void createAccountEight(ActionEvent event) {
		accountNum = 8;
		prepareCreate();
    }

    @FXML
    void createAccountFive(ActionEvent event) {
		accountNum = 5;
		prepareCreate();
    }

    @FXML
    void createAccountFour(ActionEvent event) {
		accountNum = 4;
		prepareCreate();
    }

    @FXML
    void createAccountOne(ActionEvent event) {
		accountNum = 1;
		prepareCreate();
    }

    @FXML
    void createAccountSeven(ActionEvent event) {
		accountNum = 7;
		prepareCreate();
    }

    @FXML
    void createAccountSix(ActionEvent event) {
		accountNum = 6;
		prepareCreate();
    }

    @FXML
    void createAccountThree(ActionEvent event) {
		accountNum = 3;
		prepareCreate();
    }

    @FXML
    void createAccountTwo(ActionEvent event) {
		accountNum = 2;
		prepareCreate();
    }

    @FXML
    void deleteAccountEight(ActionEvent event) {
		deleteNum = 8;
		prepareDelete();
    }

    @FXML
    void deleteAccountFive(ActionEvent event) {
		deleteNum = 5;
		prepareDelete();
    }

    @FXML
    void deleteAccountFour(ActionEvent event) {
		deleteNum = 4;
		prepareDelete();
    }

    @FXML
    void deleteAccountOne(ActionEvent event) {
		deleteNum = 1;
		prepareDelete();
    }

    @FXML
    void deleteAccountSeven(ActionEvent event) {
		deleteNum = 7;
		prepareDelete();
    }

    @FXML
    void deleteAccountSix(ActionEvent event) {
		deleteNum = 6;
		prepareDelete();
    }

    @FXML
    void deleteAccountThree(ActionEvent event) {
		deleteNum = 3;
		prepareDelete();
    }

    @FXML
    void deleteAccountTwo(ActionEvent event) {
		deleteNum = 2;
		prepareDelete();
    }

    @FXML
    void openAccountEight(ActionEvent event) throws Exception {
		open = 8;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountFive(ActionEvent event) throws Exception {
		open = 5;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountFour(ActionEvent event) throws Exception {
		open = 4;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountOne(ActionEvent event) throws Exception {
		open = 1;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountSeven(ActionEvent event) throws Exception {
		open = 7;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountSix(ActionEvent event) throws Exception {
		open = 6;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountThree(ActionEvent event) throws Exception {
		open = 3;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }

    @FXML
    void openAccountTwo(ActionEvent event) throws Exception {
		open = 2;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/personalFXML.fxml"));
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }
	
    @FXML
    void menuFXML(ActionEvent event) throws Exception {
		resetAll();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/menuFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if(new File("gui/1.txt").isFile()) {
			a1.setDisable(false);
			c1.setDisable(true);
			d1.setDisable(false);
		}
		if(new File("gui/2.txt").isFile()) {
			a2.setDisable(false);
			c2.setDisable(true);
			d2.setDisable(false);
		}
		if(new File("gui/3.txt").isFile()) {
			a3.setDisable(false);
			c3.setDisable(true);
			d3.setDisable(false);
		}
		if(new File("gui/4.txt").isFile()) {
			a4.setDisable(false);
			c4.setDisable(true);
			d4.setDisable(false);
		}
		if(new File("gui/5.txt").isFile()) {
			a5.setDisable(false);
			c5.setDisable(true);
			d5.setDisable(false);
		}
		if(new File("gui/6.txt").isFile()) {
			a6.setDisable(false);
			c6.setDisable(true);
			d6.setDisable(false);
		}
		if(new File("gui/7.txt").isFile()) {
			a7.setDisable(false);
			c7.setDisable(true);
			d7.setDisable(false);
		}
		if(new File("gui/8.txt").isFile()) {
			a8.setDisable(false);
			c8.setDisable(true);
			d8.setDisable(false);
		}
		accountDeletionLabel.setVisible(false);
		passwordFade1.setVisible(false);
		password1.setVisible(false);
		passwordLabelDelete.setVisible(false);
		passwordWarning1.setVisible(false);
		cancelDelete.setVisible(false);
		cancelDelete.setDisable(true);
		confirmDelete.setDisable(true);
		confirmDelete.setVisible(false);
		accountCreationLabel.setVisible(false);
		usernameLabel.setVisible(false);
		passwordLabel.setVisible(false);
		password.setDisable(true);
		userName.setDisable(true);
		password.setVisible(false);
		userName.setVisible(false);
		userNameFade.setVisible(false);
		passwordFade.setVisible(false);
		confirmCreate.setDisable(true);
		cancelCreate.setDisable(true);
		confirmCreate.setVisible(false);
		cancelCreate.setVisible(false);
		userNameFade.setVisible(false);
		passwordFade.setVisible(false);
		accountNum = 0;
		deleteNum = 0;
		open = 0;
		password.clear();
		userName.clear();
	}
}
