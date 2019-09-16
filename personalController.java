package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javafx.scene.control.ProgressBar;

public class personalController implements Initializable {
	
	private int o = accountController.getOpen();

    @FXML private Text playerName;

    @FXML private ImageView topLeft;

    @FXML private ImageView middleLeft;

    @FXML private ImageView bottomLeft;

    @FXML private ProgressBar progressBar;

    @FXML private Text gamesPlayed;

    @FXML private Text brainCounter;

    @FXML private Text losses;

    @FXML private Text wins;

    @FXML private Text brainsPerGame;

    @FXML private ImageView topRight;

    @FXML private ImageView middleRight;

    @FXML private ImageView bottomRight;

    @FXML
    void accountFXML(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/accountFXML.fxml"));
		
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
			Random randGen = new Random();
			String[] images = {"GREEN-BRAIN", "GREEN-FEET", "GREEN-SHOTGUN", 
			"RED-BRAIN", "RED-FEET", "RED-SHOTGUN", 
			"YELLOW-BRAIN", "YELLOW-FEET", "YELLOW-SHOTGUN", 
			"HUNK-SHOTGUN-SHOTGUN", "HUNK-SHOTGUN", "HUNK-FEET", "HUNK-BRAIN-BRAIN", 
			"BUS-STOP", "BUS-RUNOVER", "BUS-YIELD", "BUS-BRAIN", "BUS-BRAIN-BRAIN", "BUS-BRAIN-BRAIN-BRAIN", "BUS-BRAIN-BRAIN-SHOTGUN", "BUS-SHOTGUN", "BUS-SHOTGUN-SHOTGUN", "BUS-DEADEND",
			"HOTTIE-FEET", "HOTTIE-SHOTGUN", "HOTTIE-BRAIN", 
			"SANTA-BRAIN", "SANTA-BRAIN-BRAIN", "SANTA-ENERGY", "SANTA-HELMET", "SANTA-SHOTGUN", "SANTA-FEET"};
			
			int Imdom = randGen.nextInt(images.length-1);
			int Imdom1 = randGen.nextInt(images.length-1);
			int Imdom2 = randGen.nextInt(images.length-1);
			int Imdom3 = randGen.nextInt(images.length-1);
			int Imdom4 = randGen.nextInt(images.length-1);
			int Imdom5 = randGen.nextInt(images.length-1);
			
			this.topLeft.setImage(new Image("gui/" + images[Imdom] + ".png"));
			this.middleLeft.setImage(new Image("gui/" + images[Imdom1] + ".png"));
			this.bottomLeft.setImage(new Image("gui/" + images[Imdom2] + ".png"));
			this.topRight.setImage(new Image("gui/" + images[Imdom3] + ".png"));
			this.middleRight.setImage(new Image("gui/" + images[Imdom4] + ".png"));
			this.bottomRight.setImage(new Image("gui/" + images[Imdom5] + ".png"));
			
			String[] values = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
			
			for(int i = 1; i <= 8; i++) {
				if(i != o) continue;
				Scanner z8 = new Scanner(new File("gui/" + o + ".txt"));
				int j = 0;
				while(z8.hasNext()) { values[j] = z8.next(); ++j; }
				z8.close();
				this.playerName.setText(values[1]); 
				this.brainCounter.setText(values[3]);
				this.brainsPerGame.setText(values[5]); 
				this.gamesPlayed.setText(values[7]); 			
				this.wins.setText(values[9]); 
				this.losses.setText(values[11]); 
			}	
		} catch(IOException e) {
		}
		//progressBar
    }
}
