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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class playController implements Initializable {
	
	public final String[] greenDie = {"GREEN-BRAIN", "GREEN-BRAIN", "GREEN-BRAIN", "GREEN-FEET", "GREEN-FEET", "GREEN-SHOTGUN"};
	public final String[] redDie = {"RED-BRAIN", "RED-FEET", "RED-FEET", "RED-SHOTGUN", "RED-SHOTGUN", "RED-SHOTGUN"};
	public final String[] yellowDie = {"YELLOW-BRAIN", "YELLOW-BRAIN", "YELLOW-FEET", "YELLOW-FEET", "YELLOW-SHOTGUN", "YELLOW-SHOTGUN"};
	public final String[] schoolBus = {"BUS-YIELD", "BUS-RUNOVER", "BUS-STOP", "BUS-DEADEND", "BUS-BRAIN", "BUS-BRAIN-BRAIN-BRAIN", "BUS-BRAIN-BRAIN-SHOTGUN", "BUS-SHOTGUN-SHOTGUN", "BUS-SHOTGUN", "BUS-BRAIN-SHOTGUN", "BUS-BRAIN", "BUS-BRAIN-BRAIN"};
	public final String[] hunk = {"HUNK-SHOTGUN", "HUNK-SHOTGUN-SHOTGUN", "HUNK-SHOTGUN", "HUNK-FEET", "HUNK-FEET", "HUNK-BRAIN-BRAIN"};
	public final String[] hottie = {"HOTTIE-FEET", "HOTTIE-FEET", "HOTTIE-FEET", "HOTTIE-SHOTGUN", "HOTTIE-SHOTGUN", "HOTTIE-BRAIN"};
	public final String[] santa = {"SANTA-BRAIN", "SANTA-BRAIN-BRAIN", "SANTA-ENERGY", "SANTA-HELMET", "SANTA-SHOTGUN", "SANTA-FEET"};
	
	public final Dice green = new Dice(6, greenDie);
	public final Dice red = new Dice(6, redDie);
	public final Dice yellow = new Dice(6, yellowDie);
	public final Dice school = new Dice(12, schoolBus);
	public final Dice honk = new Dice(6, hunk);
	public final Dice hot = new Dice(6, hottie);
	public final Dice claus = new Dice(6, santa);
	
	public boolean SB = diceController.getBus();
	public boolean SC = diceController.getSanta();
	public boolean HH = diceController.getHH();
	
	public final Random randGen = new Random();
	public final Scanner in = new Scanner(System.in);
	
	public ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	public ArrayList<Zombie> zombiesHolder = new ArrayList<Zombie>();
	public ArrayList<Dice> cup = refillCup();

	public boolean lastRound = false;
	public boolean suddenDeath = false;
	public int counter = 0;
	public int playerIndex = 1;
	public int maxBrains = 0;
	public int numShotguns = 0;
	public int numBrains = 0;
	public int numFeet = 0;
	public int greenFeet = 0;
	public int yellowFeet = 0;
	public int redFeet = 0;
	public int greenShotguns = 0;
	public int redShotguns = 0;
	public int yellowShotguns = 0;
	public boolean hottieFeet = false;
	public boolean hunkFeet = false;
	public boolean hottieShotgun = false;
	public boolean hunkShotgun = false;
	public boolean hottieBrain = false;
	public boolean hunkBrain = false;
	public boolean santaBrain = false;
	public boolean santaShotgun = false;
	public boolean santaFeet = false;
	public boolean santaHelmet = false;
	public boolean santaEnergy = false;
	public boolean hasRolledBus = false;
	public boolean noMoreBus = false;
	public boolean stopSign = false;
	
	public boolean oneHasRolled = true;
	public boolean twoHasRolled = false;
	public boolean threeHasRolled = false;
	public boolean fourHasRolled = false;
	public boolean fiveHasRolled = false;
	public boolean sixHasRolled = false;
	public boolean sevenHasRolled = false;
	public boolean eightHasRolled = false;
	
	public Dice die1 = cup.get(randGen.nextInt(cup.size()-1));
	public Dice die2 = cup.get(randGen.nextInt(cup.size()-1));
	public Dice die3 = cup.get(randGen.nextInt(cup.size()-1));
	
	public Zombie zOne = new Zombie(0, 0);
	public Zombie zTwo = new Zombie(0, 0);
	public Zombie zThree = new Zombie(0, 0);
	public Zombie zFour = new Zombie(0, 0);
	public Zombie zFive = new Zombie(0, 0);
	public Zombie zSix = new Zombie(0, 0);
	public Zombie zSeven = new Zombie(0, 0);
	public Zombie zEight = new Zombie(0, 0);
	
    @FXML private Text playerTurn;
	
	@FXML private Text winner;

    @FXML private Text currentShotguns;

    @FXML private Text currentBrains;

    @FXML private ImageView dieOne;

    @FXML private ImageView dieTwo;

    @FXML private ImageView dieThree;
	
	@FXML private ImageView hottiesBrain;

    @FXML private ImageView hunksBrains;

    @FXML private ImageView santasBrain;
	
	@FXML private ImageView helmetSanta;

    @FXML private ImageView energyDrink1;

    @FXML private ImageView energyDrink2;

    @FXML private ImageView energyDrink3;

    @FXML private ImageView energyDrink4;

    @FXML private ImageView energyDrink5;

    @FXML private ImageView energyDrink6;

    @FXML private ImageView energyDrink7;

    @FXML private ImageView energyDrink8;

    @FXML private Button rollButton;

    @FXML private Button continueButton;

    @FXML private Button stop;

    @FXML private Button rideSchool;

    @FXML private Button ground;

    @FXML private Button keepRiding;

    @FXML private Button runners;
	
	@FXML private Button ok;
	
	@FXML private Button ok1;
	
	@FXML private Button menu;

    @FXML private Button confirmExit;

    @FXML private Button cancelExitBut;
	
	@FXML private Label shotgunAlert;

    @FXML private Text scenery;

    @FXML private Label playerOne;

    @FXML private Label playerTwo;

    @FXML private Label playerThree;

    @FXML private Label playerFour;

    @FXML private Label playerFive;

    @FXML private Label playerSix;

    @FXML private Label playerSeven;

    @FXML private Label playerEight;

    @FXML private Text p1B;

    @FXML private Text p2B;

    @FXML private Text p3B;

    @FXML private Text p4B;

    @FXML private Text p5B;

    @FXML private Text p6B;

    @FXML private Text p7B;

    @FXML private Text p8B;

    @FXML private Label brainThree;

    @FXML private Label brainFour;

    @FXML private Label brainFive;

    @FXML private Label brainSix;

    @FXML private Label brainSeven;

    @FXML private Label brainEight;
	
	@FXML private Label stopAlert;
	
	@FXML private Label hunkHottieAlert;

    @FXML private Label santaHottieAlert;

    @FXML private Label hottieSantaAlert;

    @FXML private Label hunkSantaAlert;

    @FXML private Label hottieHunkAlert;

    @FXML private Label santaHunkAlert;
	
	@FXML 
	public void rollDice() throws InterruptedException, IOException {
		this.rollButton.setDisable(true);
		if(cup.size() < 3) this.cup = refillCup();
		this.numFeet = 0;
		this.greenFeet = 0;
		this.yellowFeet = 0; 
		this.redFeet = 0;
		if(!hottieBrain && hunkShotgun) hottieBrain = false;
		else if(!hottieBrain && santaShotgun) hottieBrain = false;
		else if(!santaBrain && hottieShotgun) hottieShotgun = false;
		else if(!santaBrain && hunkShotgun) hunkShotgun = false;
		else if(!hunkBrain && hottieShotgun) hottieShotgun = false;
		else if(!hunkBrain && santaShotgun) santaShotgun = false;
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.25), e -> {
			// Rolling die1
			if(Arrays.equals(die1.getFace(), greenDie)) {
				String greenHolder1 = die1.roll(greenDie);
				this.dieOne.setImage(new Image("gui/" + greenHolder1 + ".png"));
				switch(greenHolder1) {
					case "GREEN-SHOTGUN": this.numShotguns += 1; this.greenShotguns += 1; break;
					case "GREEN-BRAIN": this.numBrains += 1; break;
					case "GREEN-FEET": this.greenFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die1.getFace(), yellowDie)) {
				String yellowHolder1 = die1.roll(yellowDie);
				this.dieOne.setImage(new Image("gui/" + yellowHolder1 + ".png"));
				switch(yellowHolder1) {
					case "YELLOW-SHOTGUN": this.numShotguns += 1; this.yellowShotguns += 1; break;
					case "YELLOW-BRAIN": this.numBrains += 1; break;
					case "YELLOW-FEET": this.yellowFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die1.getFace(), redDie)) {
				String redHolder1 = die1.roll(redDie);
				this.dieOne.setImage(new Image("gui/" + redHolder1 + ".png"));
				switch(redHolder1) {
					case "RED-SHOTGUN": this.numShotguns += 1; this.redShotguns += 1; break;
					case "RED-BRAIN": this.numBrains += 1; break;
					case "RED-FEET": this.redFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die1.getFace(), hunk)) {
				String hunkHolder1 = die1.roll(hunk);
				if(!new File("gui/" + hunkHolder1 + ".png").isFile()) {
					System.out.println("Tried: " + hunkHolder1);
					while(!new File("gui/" + hunkHolder1 + ".png").isFile()) {
						hunkHolder1 = die1.roll(hunk);
						System.out.println("Trying another image: " + hunkHolder1);
					}
				}
				this.dieOne.setImage(new Image("gui/" + hunkHolder1 + ".png"));
				switch(hunkHolder1) {
					case "HUNK-SHOTGUN": this.numShotguns += 1; this.hunkShotgun = true; break;
					case "HUNK-SHOTGUN-SHOTGUN": this.numShotguns += 2; this.hunkShotgun = true; break;
					case "HUNK-BRAIN-BRAIN": this.numBrains += 2; 
											 this.hunkBrain = true; 
											 this.hunksBrains.setImage(new Image("gui/HUNK-BRAIN-BRAIN.png"));
											 break;
					case "HUNK-FEET": this.hunkFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die1.getFace(), hottie)) {
				String hottieHolder1 = die1.roll(hottie);
				if(!new File("gui/" + hottieHolder1 + ".png").isFile()) {
					System.out.println("Tried: " + hottieHolder1);
					while(!new File("gui/" + hottieHolder1 + ".png").isFile()) {
						hottieHolder1 = die1.roll(hottie);
						System.out.println("Trying another image: " + hottieHolder1);
					}
				}
				this.dieOne.setImage(new Image("gui/" + hottieHolder1 + ".png"));
				switch(hottieHolder1) {
					case "HOTTIE-SHOTGUN": this.numShotguns += 1; this.hottieShotgun = true; break;
					case "HOTTIE-BRAIN": this.numBrains += 1; 
										 this.hottieBrain = true; 
										 this.hottiesBrain.setImage(new Image("gui/HOTTIE-BRAIN.png"));
										 break;
					case "HOTTIE-FEET": this.hottieFeet  = true; this.numFeet += 1; break;
					default: break;
				}
			}
			else {
				String santaHolder1 = die1.roll(santa);
				if(!new File("gui/" + santaHolder1 + ".png").isFile()) {
					System.out.println("Tried: " + santaHolder1);
					while(!new File("gui/" + santaHolder1 + ".png").isFile()) {
						santaHolder1 = die1.roll(santa);
						System.out.println("Trying another image: " + santaHolder1);
					}
				}
				this.dieOne.setImage(new Image("gui/" + santaHolder1 + ".png"));
				switch(santaHolder1) {
					case "SANTA-SHOTGUN": this.numShotguns += 1; this.santaShotgun = true; break;
					case "SANTA-ENERGY": this.santaEnergy = true; break;
					case "SANTA-HELMET": this.santaHelmet = true; 
										 this.helmetSanta.setImage(new Image("gui/SANTA-HELMET.png"));
										 break;
					case "SANTA-BRAIN": this.numBrains += 1; 
										this.santaBrain = true; 
										this.santasBrain.setImage(new Image("gui/SANTA-BRAIN.png"));
										break;
					case "SANTA-BRAIN-BRAIN": this.numBrains += 2; break;
					case "SANTA-FEET": this.santaFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			this.dieOne.setVisible(true);
			}));
		timeline.setCycleCount(1);
		timeline.play();
		
		Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(2.75), e -> {
			// Rolling die2
			if(Arrays.equals(die2.getFace(), greenDie)) {
				String greenHolder2 = die2.roll(greenDie);
				this.dieTwo.setImage(new Image("gui/" + greenHolder2 + ".png"));
				switch(greenHolder2) {
					case "GREEN-SHOTGUN": this.numShotguns += 1; this.greenShotguns += 1; break;
					case "GREEN-BRAIN": this.numBrains += 1; break;
					case "GREEN-FEET": this.greenFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die2.getFace(), yellowDie)) {
				String yellowHolder2 = die2.roll(yellowDie);
				this.dieTwo.setImage(new Image("gui/" + yellowHolder2 + ".png"));
				switch(yellowHolder2) {
					case "YELLOW-SHOTGUN": this.numShotguns += 1; this.yellowShotguns += 1; break;
					case "YELLOW-BRAIN": this.numBrains += 1; break;
					case "YELLOW-FEET": this.yellowFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die2.getFace(), redDie)) {
				String redHolder2 = die2.roll(redDie);
				this.dieTwo.setImage(new Image("gui/" + redHolder2 + ".png"));
				switch(redHolder2) {
					case "RED-SHOTGUN": this.numShotguns += 1; this.redShotguns += 1; break;
					case "RED-BRAIN": this.numBrains += 1; break;
					case "RED-FEET": this.redFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(HH && Arrays.equals(die2.getFace(), hunk)) {
				String hunkHolder2 = die2.roll(hunk);
				if(!new File("gui/" + hunkHolder2 + ".png").isFile()) {
					System.out.println("Tried: " + hunkHolder2);
					while(!new File("gui/" + hunkHolder2 + ".png").isFile()) {
						hunkHolder2 = die2.roll(hunk);
						System.out.println("Trying another image: " + hunkHolder2);
					}
				}
				this.dieTwo.setImage(new Image("gui/" + hunkHolder2 + ".png"));
				switch(hunkHolder2) {
					case "HUNK-SHOTGUN": this.numShotguns += 1; this.hunkShotgun = true; break;
					case "HUNK-SHOTGUN-SHOTGUN": this.numShotguns += 2; this.hunkShotgun = true; break;
					case "HUNK-BRAIN-BRAIN": this.numBrains += 2; 
											 this.hunkBrain = true; 
											 this.hunksBrains.setImage(new Image("gui/HUNK-BRAIN-BRAIN.png"));
											 break;
					case "HUNK-FEET": this.hunkFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(HH && Arrays.equals(die2.getFace(), hottie)) {
				String hottieHolder2 = die2.roll(hottie);
				if(!new File("gui/" + hottieHolder2 + ".png").isFile()) {
					System.out.println("Tried: " + hottieHolder2);
					while(!new File("gui/" + hottieHolder2 + ".png").isFile()) {
						hottieHolder2 = die2.roll(hottie);
						System.out.println("Trying another image: " + hottieHolder2);
					}
				}
				this.dieTwo.setImage(new Image("gui/" + hottieHolder2 + ".png"));
				switch(hottieHolder2) {
					case "HOTTIE-SHOTGUN": this.numShotguns += 1; this.hottieShotgun = true; break;
					case "HOTTIE-BRAIN": this.numBrains += 1; 
										 this.hottieBrain = true; 
										 this.hottiesBrain.setImage(new Image("gui/HOTTIE-BRAIN.png"));
										 break;
					case "HOTTIE-FEET": this.hottieFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			else {
				String santaHolder2 = die2.roll(santa);
				if(!new File("gui/" + santaHolder2 + ".png").isFile()) {
					System.out.println("Tried: " + santaHolder2);
					while(!new File("gui/" + santaHolder2 + ".png").isFile()) {
						santaHolder2 = die2.roll(santa);
						System.out.println("Trying another image: " + santaHolder2);
					}
				}
				this.dieTwo.setImage(new Image("gui/" + santaHolder2 + ".png"));
				switch(santaHolder2) {
					case "SANTA-SHOTGUN": this.numShotguns += 1; this.santaShotgun = true; break;
					case "SANTA-ENERGY": this.santaEnergy = true; break;
					case "SANTA-HELMET": this.santaHelmet = true; 
										 this.helmetSanta.setImage(new Image("gui/SANTA-HELMET.png"));
										 break;
					case "SANTA-BRAIN": this.numBrains += 1; 
										this.santaBrain = true; 
										this.santasBrain.setImage(new Image("gui/SANTA-BRAIN.png"));
										break;
					case "SANTA-BRAIN-BRAIN": this.numBrains += 2; break;
					case "SANTA-FEET": this.santaFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			this.dieTwo.setVisible(true);
		}));
		timeline1.setCycleCount(1);
		timeline1.play();
		
		Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(4.25), e -> {
			// Rolling die3
			if(SB && !noMoreBus && Arrays.equals(die3.getFace(), schoolBus)){
				this.hasRolledBus = true;
				String busHolder = die3.roll(schoolBus);
				if(!new File("gui/" + busHolder + ".png").isFile()) {
					System.out.println("Tried: " + busHolder);
					while(!new File("gui/" + busHolder + ".png").isFile()) {
						busHolder = die3.roll(schoolBus);
						System.out.println("Trying another image: " + busHolder);
					}
				}
				this.dieThree.setImage(new Image("gui/" + busHolder + ".png"));
				switch(busHolder) {
					case "BUS-YIELD": 
									if(this.redShotguns == 1 || this.yellowShotguns == 1 || this.greenShotguns == 1 || hunkShotgun || santaShotgun || hottieShotgun) { 
										if(this.redShotguns == 1) this.redFeet += 1; 
										else if(this.greenShotguns == 1) this.greenFeet += 1; 
										else if(this.hunkShotgun) this.hunkFeet = true; 
										else if(this.hottieShotgun) this.hottieFeet = true;
										else if(this.santaShotgun) this.santaFeet = true;
										else this.yellowFeet += 1; 
										this.numFeet += 1;
										this.numShotguns -= 1;
									}
									else if(this.redShotguns == 2 || this.yellowShotguns == 2 || this.greenShotguns == 2) { 
										if(this.redShotguns == 1) {
											if(this.greenShotguns == 1) {
												this.redFeet += 1; 
												this.greenFeet += 1; 
											}
											else {
												this.redFeet += 1; 
												this.yellowFeet += 1; 
											}
										}
										else if(this.greenShotguns == 1) {
											if(this.redShotguns == 1) {
												this.redFeet += 1; 
												this.greenFeet += 1; 
											}
											else {
												this.greenFeet += 1; 
												this.yellowFeet += 1; 
											}
										}
										else if(this.yellowShotguns == 1) {
											if(this.redShotguns == 1) {
												this.redFeet += 1; 
												this.yellowFeet += 1; 
											}
											else {
												this.yellowFeet += 1; 
												this.greenFeet += 1; 
											}
										}
										else if(this.redShotguns == 2) this.redFeet += 2;
										else if(this.greenShotguns == 2) this.greenFeet += 2;
										else this.yellowFeet += 2; 
										this.numFeet += 2;
										this.numShotguns -= 2;
									}
									break;
				case "BUS-RUNOVER": 
									if(this.numBrains > 0) --numBrains;
									if(this.hunkBrain) {
										//Complete code
									}
									else if(this.hottieBrain) {
										//Complete code
									}
									this.noMoreBus = true;
									break;
					case "BUS-STOP": this.stopSign = true; break;
					case "BUS-DEADEND": 
										if(this.numFeet == 1) { 
											if(this.redFeet == 1) this.redFeet -= 1; 
											else if(this.greenFeet == 1) this.greenFeet -= 1;
											else if(this.hunkFeet) this.hunkFeet = false;
											else if(this.santaFeet) this.santaFeet = false;
											else if(this.hottieFeet) this.hottieFeet = false;
											else this.yellowFeet -= 1;
											this.numBrains += 1;
											this.numFeet -= 1;
										}
										else if(this.numFeet == 2) { 
											if(this.redFeet == 2) this.redFeet -= 2;
											else if(this.greenFeet == 2) this.greenFeet -= 2;
											else if(this.hunkFeet && this.santaFeet) { this.hunkFeet = false; this.santaFeet = false; }
											else if(this.hunkFeet&& this.hottieFeet) { this.hunkFeet = false; this.hottieFeet = false; }
											else if(this.santaFeet && this.hottieFeet) { this.santaFeet = false; this.hottieFeet = false; }
											else this.yellowFeet -= 2;
											this.numBrains += 2;
											this.numFeet -= 2;
										}
										break;
					case "BUS-BRAIN": this.numBrains += 1; break;
					case "BUS-BRAIN-BRAIN-BRAIN": this.numBrains += 3; break;
					case "BUS-BRAIN-BRAIN-SHOTGUN": this.numBrains += 2; this.numShotguns += 1; break;
					case "BUS-SHOTGUN-SHOTGUN": this.numShotguns += 2; break;
					case "BUS-SHOTGUN": this.numShotguns += 1; break;
					case "BUS-BRAIN-SHOTGUN": this.numBrains += 1; this.numShotguns += 1; break;
					case "BUS-BRAIN-BRAIN": this.numBrains += 2; break;
					default: break;
				}
			}
			else if(Arrays.equals(die3.getFace(), greenDie)) {
				String greenHolder3 = die3.roll(greenDie);
				this.dieThree.setImage(new Image("gui/" + greenHolder3 + ".png"));
				switch(greenHolder3) {
					case "GREEN-SHOTGUN": this.numShotguns += 1; break;
					case "GREEN-BRAIN": this.numBrains += 1; break;
					case "GREEN-FEET": this.greenFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die3.getFace(), yellowDie)) {
				String yellowHolder3 = die3.roll(yellowDie);
				this.dieThree.setImage(new Image("gui/" + yellowHolder3 + ".png"));
				switch(yellowHolder3) {
					case "YELLOW-SHOTGUN": this.numShotguns += 1; break;
					case "YELLOW-BRAIN": this.numBrains += 1; break;
					case "YELLOW-FEET": this.yellowFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(Arrays.equals(die3.getFace(), redDie)) {
				String redHolder3 = die3.roll(redDie);
				this.dieThree.setImage(new Image("gui/" + redHolder3 + ".png"));
				switch(redHolder3) {
					case "RED-SHOTGUN": this.numShotguns += 1; break;
					case "RED-BRAIN": this.numBrains += 1; break;
					case "RED-FEET": this.redFeet += 1; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(HH && Arrays.equals(die3.getFace(), hunk)) {
				String hunkHolder3 = die3.roll(hunk);
				if(!new File("gui/" + hunkHolder3 + ".png").isFile()) {
					System.out.println("Tried: " + hunkHolder3);
					while(!new File("gui/" + hunkHolder3 + ".png").isFile()) {
						hunkHolder3 = die3.roll(hunk);
						System.out.println("Trying another image: " + hunkHolder3);
					}
				}
				this.dieThree.setImage(new Image("gui/" + hunkHolder3 + ".png"));
				switch(hunkHolder3) {
					case "HUNK-SHOTGUN": this.numShotguns += 1; this.hunkShotgun = true; break;
					case "HUNK-SHOTGUN-SHOTGUN": this.numShotguns += 2; this.hunkShotgun = true; break;
					case "HUNK-BRAIN-BRAIN": this.numBrains += 2; 
											 this.hunkBrain = true; 
											 this.hunksBrains.setImage(new Image("gui/HUNK-BRAIN-BRAIN.png"));
											 break;
					case "HUNK-FEET": this.hunkFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			else if(HH && Arrays.equals(die3.getFace(), hottie)) {
				String hottieHolder3 = die3.roll(hottie);
				if(!new File("gui/" + hottieHolder3 + ".png").isFile()) {
					System.out.println("Tried: " + hottieHolder3);
					while(!new File("gui/" + hottieHolder3 + ".png").isFile()) {
						hottieHolder3 = die3.roll(hottie);
						System.out.println("Trying another image: " + hottieHolder3);
					}
				}
				this.dieThree.setImage(new Image("gui/" + hottieHolder3 + ".png"));
				switch(hottieHolder3) {
					case "HOTTIE-SHOTGUN": this.numShotguns += 1; this.hottieShotgun = true; break;
					case "HOTTIE-BRAIN": this.numBrains += 1; 
										 this.hottieBrain = true; 
										 this.hottiesBrain.setImage(new Image("gui/HOTTIE-BRAIN.png"));
										 break;
					case "HOTTIE-FEET": this.hottieFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			else {
				String santaHolder3 = die3.roll(santa);
				if(!new File("gui/" + santaHolder3 + ".png").isFile()) {
					System.out.println("Tried: " + santaHolder3);
					while(!new File("gui/" + santaHolder3 + ".png").isFile()) {
						santaHolder3 = die3.roll(santa);
						System.out.println("Trying another image: " + santaHolder3);
					}
				}
				this.dieThree.setImage(new Image("gui/" + santaHolder3 + ".png"));
				switch(santaHolder3) {
					case "SANTA-SHOTGUN": this.numShotguns += 1; this.santaShotgun = true; break;
					case "SANTA-ENERGY": this.santaEnergy = true; break;
					case "SANTA-HELMET": this.santaHelmet = true; 
										 this.helmetSanta.setImage(new Image("gui/SANTA-HELMET.png"));
										 break;
					case "SANTA-BRAIN": this.numBrains += 1; 
										this.santaBrain = true; 
										this.santasBrain.setImage(new Image("gui/SANTA-BRAIN.png"));
										break;
					case "SANTA-BRAIN-BRAIN": this.numBrains += 2; break;
					case "SANTA-FEET": this.santaFeet = true; this.numFeet += 1; break;
					default: break;
				}
			}
			
			this.dieThree.setVisible(true);
			
			this.continueButton.setDisable(true);
			this.continueButton.setVisible(false);
			this.stop.setVisible(false);
			this.stop.setDisable(true);
			if(hottieBrain && hunkShotgun) {
				this.ok1.setVisible(true);
				this.ok1.setDisable(false);
				this.hunkHottieAlert.setVisible(true);
				this.numBrains -= 1;
				return;
			}
			else if(hottieBrain && santaShotgun) {
				this.ok1.setVisible(true);
				this.ok1.setDisable(false);
				this.santaHottieAlert.setVisible(true);
				this.numBrains -= 1;
				return;
			}
			else if(santaBrain && hottieShotgun) {
				this.ok1.setVisible(true);
				this.ok1.setDisable(false);
				this.hottieSantaAlert.setVisible(true);
				this.numBrains -= 1;
				return;
			}
			else if(santaBrain && hunkShotgun) {
				this.ok1.setVisible(true);
				this.ok1.setDisable(false);
				this.hunkSantaAlert.setVisible(true);
				this.numBrains -= 1;
				return;
			}
			else if(hunkBrain && hottieShotgun) {
				this.ok1.setVisible(true);
				this.ok1.setDisable(false);
				this.hottieHunkAlert.setVisible(true);
				this.numBrains -= 1;
				return;
			}
			else if(hunkBrain && santaShotgun) {
				this.ok1.setVisible(true);
				this.ok1.setDisable(false);
				this.santaHunkAlert.setVisible(true);
				this.numBrains -= 1;
				return;
			}
			rollPartTwo();
		}));
		timeline2.setCycleCount(1);
		timeline2.play();
	}
	
	public void rollPartTwo() {
		if(santaEnergy) {
			switch(greenFeet) {
				case 1: this.greenFeet -= 1; this.numBrains += 1; break;
				case 2: this.greenFeet -= 2; this.numBrains += 2; break;
				case 3: this.greenFeet -= 3; this.numBrains += 3; break;
				default: break;
			}
			if(zombies.contains(zOne) && playerIndex == 1) this.energyDrink1.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zTwo) && playerIndex == 2) this.energyDrink2.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zThree) && playerIndex == 3) this.energyDrink3.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zFour) && playerIndex == 4) this.energyDrink4.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zFive) && playerIndex == 5) this.energyDrink5.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zSix) && playerIndex == 6) this.energyDrink6.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zSeven) && playerIndex == 7) this.energyDrink7.setImage(new Image("gui/SANTA-ENERGY.png")); 
			else if(zombies.contains(zEight) && playerIndex == 8) this.energyDrink8.setImage(new Image("gui/SANTA-ENERGY.png")); 
		}
		if(santaHelmet && numShotguns > 3) {
			if(lastRound && counter == zombies.size()-1) {
				replaceZombies();
				printWinner();
				return;
			}
			this.shotgunAlert.setVisible(true);
			this.ok.setVisible(true);
			this.ok.setDisable(false);
			return;
		}
		else if(!santaHelmet && numShotguns > 2) {
			if(lastRound && counter == zombies.size()-1) {
				replaceZombies();
				printWinner();
				return;
			}
			this.shotgunAlert.setVisible(true);
			this.ok.setVisible(true);
			this.ok.setDisable(false);
			return;
		}
		else if(stopSign) {
			if(lastRound && counter == zombies.size()-1) {
				replaceZombies();
				printWinner();
				return;
			}
			if(numShotguns > 2) this.shotgunAlert.setVisible(true);
			else this.stopAlert.setVisible(true);
			this.ok.setVisible(true);
			this.ok.setDisable(false);
			return;
		}
		else {
			this.continueButton.setDisable(false);
			this.continueButton.setVisible(true);
			this.stop.setVisible(true);
			this.stop.setDisable(false);
		}
	}
	
	@FXML
    public void rescue(ActionEvent event) throws IOException {
		this.hunkHottieAlert.setVisible(false);
		this.santaHottieAlert.setVisible(false);
		this.hottieSantaAlert.setVisible(false);
		this.hunkSantaAlert.setVisible(false);
		this.hottieHunkAlert.setVisible(false);
		this.santaHunkAlert.setVisible(false);
		this.ok1.setVisible(false);
		this.ok1.setDisable(true);
		rollPartTwo();
    }
	
	@FXML
    public void confirm(ActionEvent event) throws IOException {
		if(stopSign && numShotguns < 3) stopTurn();
		if(santaHelmet && numShotguns < 3) stopTurn();
		nextTurn();
    }
	
	@FXML
	public void stopTurn() {
		
		if(zombies.contains(zOne) && playerIndex == 1) zOne.setBrains(zOne.getBrains() + numBrains); 
		else if(zombies.contains(zTwo) && playerIndex == 2) zTwo.setBrains(zTwo.getBrains() + numBrains); 
		else if(zombies.contains(zThree) && playerIndex == 3)zThree.setBrains(zThree.getBrains() + numBrains); 
		else if(zombies.contains(zFour) && playerIndex == 4) zFour.setBrains(zFour.getBrains() + numBrains); 
		else if(zombies.contains(zFive) && playerIndex == 5) zFive.setBrains(zFive.getBrains() + numBrains); 
		else if(zombies.contains(zSix) && playerIndex == 6) zSix.setBrains(zSix.getBrains() + numBrains); 
		else if(zombies.contains(zSeven) && playerIndex == 7) zSeven.setBrains(zSeven.getBrains() + numBrains); 
		else if(zombies.contains(zEight) && playerIndex == 8) zEight.setBrains(zEight.getBrains() + numBrains); 

		for(int q = 0; q < zombies.size(); q++) if(zombies.get(q).getBrains() > maxBrains) maxBrains = zombies.get(q).getBrains();
		
		if(zombies.contains(zOne)) p1B.setText(Integer.toString(zOne.getBrains()));
		if(zombies.contains(zTwo)) p2B.setText(Integer.toString(zTwo.getBrains()));
		if(zombies.contains(zThree)) p3B.setText(Integer.toString(zThree.getBrains()));
		if(zombies.contains(zFour)) p4B.setText(Integer.toString(zFour.getBrains())); 
		if(zombies.contains(zFive)) p5B.setText(Integer.toString(zFive.getBrains())); 
		if(zombies.contains(zSix)) p6B.setText(Integer.toString(zSix.getBrains())); 
		if(zombies.contains(zSeven)) p7B.setText(Integer.toString(zSeven.getBrains())); 
		if(zombies.contains(zEight)) p8B.setText(Integer.toString(zEight.getBrains())); 
		
		if(maxBrains >= 13 && !lastRound) { 
			scenery.setVisible(true);
			lastRound = true; 
		}
		nextTurn();
	}
	
	public void nextTurn() {
		if(lastRound) {
			++counter;
			if(counter == zombies.size() && suddenDeathBool())  {
				replaceZombies();
				//System.out.println("MAXBRAINS" + maxBrains);
				//System.out.println("SIZE" + zombies.size());
				remainingZombies();
				//System.out.println("SIZE" + zombies.size());
				counter = 0;
				scenery.setText("SUDDEN DEATH!");
				this.oneHasRolled = false;
				this.twoHasRolled = false;
				this.threeHasRolled = false;
				this.fourHasRolled = false;
				this.fiveHasRolled = false;
				this.sixHasRolled = false;
				this.sevenHasRolled = false;
				this.eightHasRolled = false;
			}
			else if(counter == zombies.size()) { 
				replaceZombies();
				printWinner();
				return;
			}
		}
		
		currentBrains.setText("0");
		currentShotguns.setText("0");
		this.continueButton.setDisable(true);
		this.stop.setDisable(true);
		this.continueButton.setVisible(false);
		this.stop.setVisible(false);
		this.rollButton.setDisable(false);
		this.dieOne.setVisible(false);
		this.dieTwo.setVisible(false);
		this.dieThree.setVisible(false);
		this.shotgunAlert.setVisible(false);
		this.stopAlert.setVisible(false);
		this.ok.setVisible(false);
		this.ok.setDisable(true);
		this.cup = refillCup();
		this.die1 = cup.get(randGen.nextInt(cup.size()-1));
		this.cup.remove(die1);
		this.die2 = cup.get(randGen.nextInt(cup.size()-1));
		this.cup.remove(die2);
		this.die3 = cup.get(randGen.nextInt(cup.size()-1));
		this.cup.remove(die3);
		this.numShotguns = 0;
		this.numBrains = 0;
		this.numFeet = 0;
		this.greenFeet = 0;
		this.yellowFeet = 0;
		this.redFeet = 0;
		this.greenShotguns = 0;
		this.redShotguns = 0;
		this.yellowShotguns = 0;
		this.hottieFeet = false;
		this.hunkFeet = false;
		this.hottieShotgun = false;
		this.hunkShotgun = false;
		this.hottieBrain = false;
		this.hunkBrain = false;
		this.santaBrain = false;
		this.santaShotgun = false;
		this.santaFeet = false;
		this.santaHelmet = false;
		this.santaEnergy = false;
		this.hasRolledBus = false;
		this.noMoreBus = false;
		this.stopSign = false;
		this.hottiesBrain.setVisible(false);
		this.hunksBrains.setVisible(false);
		this.santasBrain.setVisible(false);
		this.helmetSanta.setVisible(false);
		this.energyDrink1.setVisible(false);
		this.energyDrink2.setVisible(false);
		this.energyDrink3.setVisible(false);
		this.energyDrink4.setVisible(false);
		this.energyDrink5.setVisible(false);
		this.energyDrink6.setVisible(false);
		this.energyDrink7.setVisible(false);
		this.energyDrink8.setVisible(false);
		//Note rolling
		if(playerIndex == zombies.size()) {
			this.playerIndex = 1;
			this.oneHasRolled = false;
			this.twoHasRolled = false;
			this.threeHasRolled = false;
			this.fourHasRolled = false;
			this.fiveHasRolled = false;
			this.sixHasRolled = false;
			this.sevenHasRolled = false;
			this.eightHasRolled = false;
		}
		
		if(zombies.contains(zOne) && !oneHasRolled) {
			playerTurn.setText(playerOne.getText() + "'s Turn"); 
			this.oneHasRolled = true;
			this.playerIndex = 1;
		}
		else if(zombies.contains(zTwo) && !twoHasRolled) {
			playerTurn.setText(playerTwo.getText() + "'s Turn");
			this.twoHasRolled = true;
			this.playerIndex = 2;
		}
		else if(zombies.contains(zThree) && !threeHasRolled) {
			playerTurn.setText(playerThree.getText() + "'s Turn"); 
			this.threeHasRolled = true;
			this.playerIndex = 3;
		}
		else if(zombies.contains(zFour) && !fourHasRolled) {
			playerTurn.setText(playerFour.getText() + "'s Turn"); 
			this.fourHasRolled = true;
			this.playerIndex = 4;
		}
		else if(zombies.contains(zFive) && !fiveHasRolled) {
			playerTurn.setText(playerFive.getText() + "'s Turn"); 
			this.fiveHasRolled = true;
			this.playerIndex = 5;
		}
		else if(zombies.contains(zSix) && !sixHasRolled) {
			playerTurn.setText(playerSix.getText() + "'s Turn"); 
			this.sixHasRolled = true;
			this.playerIndex = 6;
		}
		else if(zombies.contains(zSeven) && !sevenHasRolled) {
			playerTurn.setText(playerSeven.getText() + "'s Turn"); 
			this.sevenHasRolled = true;
			this.playerIndex = 7;
		}
		else if(zombies.contains(zEight) && !eightHasRolled) {
			playerTurn.setText(playerEight.getText() + "'s Turn"); 
			this.eightHasRolled = true;
			this.playerIndex = 8;
		}
	}

	@FXML
	public void continueTurn() throws IOException {
		currentBrains.setText(Integer.toString(numBrains));
		currentShotguns.setText(Integer.toString(numShotguns));
		if(hottieBrain) this.hottiesBrain.setVisible(true);
		if(hunkBrain) this.hunksBrains.setVisible(true);
		if(santaBrain) this.santasBrain.setVisible(true);
		if(hottieBrain && hunkShotgun) {
			this.hottiesBrain.setVisible(false);
			hottieBrain = false;
			hunkShotgun = false;
		}
		else if(hottieBrain && santaShotgun) {
			this.hottiesBrain.setVisible(false);
			hottieBrain = false;
			santaShotgun = false;
		}
		else if(santaBrain && hottieShotgun) {
			this.santasBrain.setVisible(false);
			hottieShotgun = false;
			santaBrain = false;
		}
		else if(santaBrain && hunkShotgun) {
			this.santasBrain.setVisible(false);
			hunkShotgun = false;
			santaBrain = false;
		}
		else if(hunkBrain && hottieShotgun) {
			this.hunksBrains.setVisible(false);
			hottieShotgun = false;
			hunkBrain = false;
		}
		else if(hunkBrain && santaShotgun) {
			this.hunksBrains.setVisible(false);
			santaShotgun = false;
			hunkBrain = false;
		}
		
		if(santaEnergy) {
			if(zombies.contains(zOne) && !oneHasRolled) this.energyDrink1.setVisible(true);
			else if(zombies.contains(zTwo) && !twoHasRolled) this.energyDrink2.setVisible(true);
			else if(zombies.contains(zThree) && !threeHasRolled) this.energyDrink3.setVisible(true);
			else if(zombies.contains(zFour) && !fourHasRolled) this.energyDrink4.setVisible(true);
			else if(zombies.contains(zFive) && !fiveHasRolled) this.energyDrink5.setVisible(true);
			else if(zombies.contains(zSix) && !sixHasRolled) this.energyDrink6.setVisible(true);
			else if(zombies.contains(zSeven) && !sevenHasRolled) this.energyDrink7.setVisible(true);
			else if(zombies.contains(zEight) && !eightHasRolled) this.energyDrink8.setVisible(true);
		}
		if(santaHelmet) this.helmetSanta.setVisible(true);
		if(numFeet == 3) {
			backToOrig();
			return;
		}
		else if(SB && !noMoreBus && !hasRolledBus) {
			this.continueButton.setDisable(true);
			this.stop.setDisable(true);
			this.continueButton.setVisible(false);
			this.stop.setVisible(false);
			this.rideSchool.setDisable(false);
			this.rideSchool.setVisible(true);
			this.ground.setDisable(false);
			this.ground.setVisible(true);
			return;
		}
		else if(SB && !noMoreBus && numFeet > 0) {
			this.continueButton.setDisable(true);	
			this.stop.setDisable(true);
			continueButton.setVisible(false);
			stop.setVisible(false);
			keepRiding.setDisable(false);
			keepRiding.setVisible(true);
			runners.setDisable(false);
			runners.setVisible(true);
			return;
		}
		else if(SB && !noMoreBus) {
			die1 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die1);
			die2 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die2);
			die3 = school;
			backToOrig();
		}
		else stayGrounded1();
	}

	public void backToOrig() {
		this.continueButton.setDisable(true);	
		this.stop.setDisable(true);
		this.rollButton.setDisable(false);
		this.dieOne.setVisible(false);
		this.dieTwo.setVisible(false);
		this.dieThree.setVisible(false);
		this.keepRiding.setDisable(true);
		this.keepRiding.setVisible(false);
		this.runners.setDisable(true);
		this.runners.setVisible(false);
		this.rideSchool.setDisable(true);
		this.rideSchool.setVisible(false);
		this.ground.setDisable(true);
		this.ground.setVisible(false);
	}
	
	@FXML
    public void keepRiding(ActionEvent event) {
		die1 = cup.get(randGen.nextInt(cup.size()-1));
		cup.remove(die1);
		die2 = cup.get(randGen.nextInt(cup.size()-1));
		cup.remove(die2);
		die3 = school;
		
		this.greenFeet = 0;
		this.redFeet = 0;
		this.yellowFeet = 0;
		backToOrig();
	}
	
	@FXML
    public void rideBus(ActionEvent event) {
		if(redFeet > 0) {
			switch(redFeet) {
				case 1: die1 = red;
					if(greenFeet == 1) die2 = green;
					else if(santaFeet) die2 = claus;
					else if(hottieFeet) die2 = hot;
					else if(hunkFeet) die2 = honk;
					else if(yellowFeet == 1) die2 = yellow;
					die3 = school;
					break;
				case 2: 
					die1 = red;
					die2 = red;
					die3 = school; 
					break;
				default: break;
			}
		}
		else if(greenFeet > 0) {
			switch(greenFeet) {
				case 1: die1 = green;
					if(redFeet == 1) die2 = red;
					else if(santaFeet) die2 = claus;
					else if(hottieFeet) die2 = hot;
					else if(hunkFeet) die2 = honk;
					else if(yellowFeet == 1) die2 = yellow;
					die3 = school;
					break;
				case 2: 
					die1 = green;
					die2 = green;
					die3 = school;
					break;
				default: break;
			}
		}
		else if(yellowFeet > 0) {
			switch(yellowFeet) {
				case 1: die1 = yellow;
					if(greenFeet == 1) die2 = green;
					else if(santaFeet) die2 = claus;
					else if(hottieFeet) die2 = hot;
					else if(hunkFeet) die2 = honk;
					else if(redFeet == 1) die2 = red;
					die3 = school;
					break;
				case 2: 
				die1 = yellow;
				die2 = yellow;
				die3 = school; 
				default: break;
			}
		}
		else if(santaFeet) {
			die1 = claus;
			if(hottieFeet) die2 = hot;
			else if(hunkFeet) die2 = honk;
			else {
				die2 = cup.get(randGen.nextInt(cup.size()-1));
				cup.remove(die2);
			}
			die3 = school;
		}
		else if(hottieFeet) {
			die1 = hot;
			if(santaFeet) die2 = claus;
			else if(hunkFeet) die2 = honk;
			else {
				die2 = cup.get(randGen.nextInt(cup.size()-1));
				cup.remove(die2);
			}
			die3 = school;
		}
		else if(hunkFeet) {
			die1 = honk;
			if(santaFeet) die2 = claus;
			else if(hottieFeet) die2 = hot;
			else {
				die2 = cup.get(randGen.nextInt(cup.size()-1));
				cup.remove(die2);
			}
			die3 = school;
		}
		else {
			die1 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die1);
			die2 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die2);
			die3 = school;
		}
		this.greenFeet = 0;
		this.redFeet = 0;
		this.yellowFeet = 0;
		backToOrig();
    }
	
	public void stayGrounded1() {
		if(numFeet == 3) return;
		
		if(cup.size() < 3) this.cup = refillCup();	
		
		if(redFeet > 0) {
			switch(redFeet) {
				case 1: die1 = red;
					if(greenFeet == 1) die2 = green;
					else if(santaFeet) die2 = claus;
					else if(hottieFeet) die2 = hot;
					else if(hunkFeet) die2 = honk;
					else if(yellowFeet == 1) die2 = yellow;
					die3 = cup.get(randGen.nextInt(cup.size()-1));
					cup.remove(die3);
					break;
				case 2: 
					die1 = red;
					die2 = red;
					die3 = cup.get(randGen.nextInt(cup.size()-1));
					cup.remove(die3); 
					break;
				default: break;
			}
		}
		else if(greenFeet > 0) {
			switch(greenFeet) {
				case 1: die1 = green;
					if(redFeet == 1) die2 = red;
					else if(yellowFeet == 1) die2 = yellow;
					else if(santaFeet) die2 = claus;
					else if(hottieFeet) die2 = hot;
					else if(hunkFeet) die2 = honk;
					die3 = cup.get(randGen.nextInt(cup.size()-1));
					cup.remove(die3);
					break;
				case 2: 
					die1 = green;
					die2 = green;
					die3 = cup.get(randGen.nextInt(cup.size()-1));
					cup.remove(die3); 
					break;
				default: break;
			}
		}
		else if(yellowFeet > 0) {
			switch(yellowFeet) {
				case 1: die1 = red;
					if(greenFeet == 1) die2 = green;
					else if(redFeet == 1) die2 = red;
					else if(santaFeet) die2 = claus;
					else if(hottieFeet) die2 = hot;
					else if(hunkFeet) die2 = honk;
					die3 = cup.get(randGen.nextInt(cup.size()-1));
					cup.remove(die3);
				case 2: 
				die1 = yellow;
				die2 = yellow;
				die3 = cup.get(randGen.nextInt(cup.size()-1));
				cup.remove(die3); 
				default: break;
			}
		}
		else {
			die1 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die1);
			die2 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die2);
			die3 = cup.get(randGen.nextInt(cup.size()-1));
			cup.remove(die3);
		}
		this.numFeet = 0;
		this.greenFeet = 0;
		this.yellowFeet = 0;
		this.redFeet = 0;
		this.hottieFeet = false;
		this.hunkFeet = false;
		backToOrig();
	}
	
	@FXML
    public void stayGrounded(ActionEvent event) {
		this.noMoreBus = true;
		stayGrounded1();
    }
	
	public ArrayList<Dice> refillCup() {
		ArrayList<Dice> cup = new ArrayList<Dice>();
		
		if(SC) cup.add(claus);
		else cup.add(green);
		if(HH) {
			cup.add(honk);
			cup.add(hot);
		}
		else {
			cup.add(yellow);
			cup.add(yellow);
		}
		cup.add(green);
		cup.add(green);
		cup.add(green);
		cup.add(green);
		cup.add(green);
		cup.add(yellow);
		cup.add(yellow);
		cup.add(red);
		cup.add(red);
		cup.add(red);
		
		return cup;
	}
	
	public void remainingZombies() {
		if(zombies.contains(zOne)) {
			if(zOne.getBrains() != maxBrains) zombies.remove(zOne);
		}
		if(zombies.contains(zTwo)) {
			if(zTwo.getBrains() != maxBrains) zombies.remove(zTwo);
		}
		if(zombies.contains(zThree)) {
			if(zThree.getBrains() != maxBrains) zombies.remove(zThree);
		}
		if(zombies.contains(zFour)) {
			if(zFour.getBrains() != maxBrains) zombies.remove(zFour);
		}
		if(zombies.contains(zFive)) {
			if(zFive.getBrains() != maxBrains) zombies.remove(zFive);
		}
		if(zombies.contains(zSix)) {
			if(zSix.getBrains() != maxBrains) zombies.remove(zSix);
		}
		if(zombies.contains(zSeven)) {
			if(zSeven.getBrains() != maxBrains) zombies.remove(zSeven);
		}
		if(zombies.contains(zEight)) {
			if(zEight.getBrains() != maxBrains) zombies.remove(zEight);
		}
	}
	
	public boolean suddenDeathBool() {
		int numMax = 0;
		for(int o = 0; o < zombies.size(); o++) if(zombies.get(o).getBrains() == maxBrains) numMax++;
		if(numMax > 1) return true;
		else return false;
	}

	public void replaceZombies() {
		for(int i = 0; i < zombies.size(); i++) {
			switch(zombies.get(i).getID()) {
				case 1: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 2: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 3: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 4: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 5: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 6: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 7: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				case 8: zombiesHolder.set(zombies.get(i).getID()-1, new Zombie(zombies.get(i).getID(), zombies.get(i).getBrains()));
				default: break;
			}
		}
		System.out.println();
	}
	
	public void printWinner() {
		this.continueButton.setDisable(true);	
		this.stop.setDisable(true);
		this.rollButton.setDisable(true);
		this.ok.setVisible(false);
		this.ok.setDisable(true);
		this.dieOne.setVisible(true);
		this.dieTwo.setVisible(true);
		this.dieThree.setVisible(true);
		try {
			boolean real = false;
			//System.out.println("MAXBRAINS: " + maxBrains);
			for(int i = 0; i < zombiesHolder.size(); i++) {
					if(new File("gui/" + zombiesHolder.get(i).getID() + ".txt").isFile()) real = true;
			}
			if(real) {
				int wins = 0;
				int losses = 0;
				String[] values = new String[14];
				for(int i = 0; i < zombiesHolder.size(); i++) {
					if(zombiesHolder.get(i).getID() == 0) continue;
					Scanner z8 = new Scanner(new File("gui/" + zombiesHolder.get(i).getID() + ".txt")); 
					int j = 0;
					while(z8.hasNext()) {
						values[j] = z8.next();
						++j;
					}
					
					String name = values[1]; 
					int lifeTimeScore = Integer.parseInt(values[3]) + zombiesHolder.get(i).getBrains();
					int numberOfPlays = Integer.parseInt(values[7]) + 1; 			
					double averageScore = (double)lifeTimeScore / (double)numberOfPlays; 
					if(zombiesHolder.get(i).getBrains() == maxBrains) {
						wins = Integer.parseInt(values[9]) + 1; 
						losses = Integer.parseInt(values[11]);
						switch(zombiesHolder.get(i).getID()) {
							case 1: winner.setText(playerOne.getText() + " Wins!"); break;
							case 2: winner.setText(playerTwo.getText() + " Wins!"); break;
							case 3: winner.setText(playerThree.getText() + " Wins!"); break;
							case 4: winner.setText(playerFour.getText() + " Wins!"); break;
							case 5: winner.setText(playerFive.getText() + " Wins!"); break;
							case 6: winner.setText(playerSix.getText() + " Wins!"); break;
							case 7: winner.setText(playerSeven.getText() + " Wins!"); break;
							case 8: winner.setText(playerEight.getText() + " Wins!"); break;
							default: break;
						}
						winner.setVisible(true);
					}
					else {
						losses = Integer.parseInt(values[11]) + 1;
						wins = Integer.parseInt(values[9]);
					}			
					String password = values[13]; 
					
					switch(zombiesHolder.get(i).getID()) {
						case 1: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 1).store();
								break;
						case 2: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 2).store();
								break;
						case 3: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 3).store();
								break;
						case 4: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 4).store();
								break;
						case 5: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 5).store();
								break;
						case 6: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 6).store();
								break;
						case 7: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 7).store();
								break;
						case 8: new Player(name, lifeTimeScore, averageScore, numberOfPlays, wins, losses, password, 8).store();
								break;
						default: break;
					}
				}
			}
			else {
				for(int i = 0; i < zombiesHolder.size(); i++) {
					if(zombiesHolder.get(i).getBrains() != maxBrains) continue;
					switch(i+1) {
							case 1: winner.setText("Player   1   Wins!"); break;
							case 2: winner.setText("Player   2   Wins!"); break;
							case 3: winner.setText("Player   3   Wins!"); break;
							case 4: winner.setText("Player   4   Wins!"); break;
							case 5: winner.setText("Player   5   Wins!"); break;
							case 6: winner.setText("Player   6   Wins!"); break;
							case 7: winner.setText("Player   7   Wins!"); break;
							case 8: winner.setText("Player   8   Wins!"); break;
							default: break;
					}
					winner.setVisible(true);
					break;
				}
			}
		} catch(IOException e) {
		}
	}
	
	@FXML
    public void exitGame(ActionEvent event) {
		menu.setDisable(true);
		confirmExit.setDisable(false);
		confirmExit.setVisible(true);
		cancelExitBut.setDisable(false);
		cancelExitBut.setVisible(true);
    }
	
	@FXML
    public void cancelExit(ActionEvent event) {
		menu.setDisable(false);
		confirmExit.setDisable(true);
		confirmExit.setVisible(false);
		cancelExitBut.setDisable(true);
		cancelExitBut.setVisible(false);
    }

    @FXML
    public void menuFXML(ActionEvent event) throws Exception {
		playerOne.setText("Player 1");
		playerTwo.setText("Player 2");
		playerThree.setText("Player 3");
		playerFour.setText("Player 4");
		playerFive.setText("Player 5");
		playerSix.setText("Player 6");
		playerSeven.setText("Player 7");
		playerEight.setText("Player 8");
		playerController.setNumP(0);
		playerController.setNumC(0);
		diceController.setBus(false);
		diceController.setHH(false);
		diceController.setSanta(false);
		playerController.setAccountOne(false);
		playerController.setAccountTwo(false);
		playerController.setAccountThree(false);
		playerController.setAccountFour(false);
		playerController.setAccountFive(false);
		playerController.setAccountSix(false);
		playerController.setAccountSeven(false);
		playerController.setAccountEight(false);
		zombiesHolder = new ArrayList<Zombie>();
		zombies = new ArrayList<Zombie>();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/menuFXML.fxml"));
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new Scene(root));
		window.show();
    }
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		playerOne.setText("Player 1");
		playerTwo.setText("Player 2");
		playerThree.setText("Player 3");
		playerFour.setText("Player 4");
		playerFive.setText("Player 5");
		playerSix.setText("Player 6");
		playerSeven.setText("Player 7");
		playerEight.setText("Player 8");
		for(int i = 8; i > playerController.getNumP() + playerController.getNumC(); i--) {
			switch(i) {
				case 8: playerEight.setVisible(false);
						brainEight.setVisible(false);
						p8B.setVisible(false);
						break;
				case 7: playerSeven.setVisible(false);
						brainSeven.setVisible(false);
						p7B.setVisible(false);
						break;
				case 6: playerSix.setVisible(false);
						brainSix.setVisible(false);
						p6B.setVisible(false);
						break;
				case 5: playerFive.setVisible(false);
						brainFive.setVisible(false);
						p5B.setVisible(false);
						break;
				case 4: playerFour.setVisible(false);
						brainFour.setVisible(false);
						p4B.setVisible(false);
						break;
				case 3: playerThree.setVisible(false);
						brainThree.setVisible(false);
						p3B.setVisible(false);
						break;
				default: break;
			}
		}
		
		try {
			boolean one = false;
			boolean two = false;
			boolean three = false;
			boolean four = false;
			boolean five = false;
			boolean six = false;
			boolean seven = false;
			for(int i = 1; i < playerController.getNumP()+ 1; i++) {
				switch(i) {
					case 1: if(playerController.getAccountOne() && !one) { 
								Scanner s1 = new Scanner(new File("gui/1.txt")); 
								String temp35 = s1.nextLine();
								temp35 = temp35.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp35);
								playerTurn.setText(temp35 + "'s Turn");
								one = true;
							}
							else if(playerController.getAccountTwo() && !two) { 
								Scanner s2 = new Scanner(new File("gui/2.txt")); 
								String temp34 = s2.nextLine();
								temp34 = temp34.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp34);
								playerTurn.setText(temp34 + "'s Turn");								
								two = true;
							}
							else if(playerController.getAccountThree() && !three) { 
								Scanner s3 = new Scanner(new File("gui/3.txt"));
								String temp33 = s3.nextLine();
								temp33 = temp33.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp33);
								playerTurn.setText(temp33 + "'s Turn");
								three = true;
							}
							else if(playerController.getAccountFour() && !four) { 
								Scanner s4 = new Scanner(new File("gui/4.txt"));
								String temp32 = s4.nextLine();
								temp32 = temp32.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp32);
								playerTurn.setText(temp32 + "'s Turn");
								four = true;
							}
							else if(playerController.getAccountFive() && !five) { 
								Scanner s5 = new Scanner(new File("gui/5.txt"));
								String temp31 = s5.nextLine();
								temp31 = temp31.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp31);
								playerTurn.setText(temp31 + "'s Turn");
								five = true;
							}
							else if(playerController.getAccountSix() && !six) { 
								Scanner s6 = new Scanner(new File("gui/6.txt"));
								String temp30 = s6.nextLine();
								temp30 = temp30.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp30);
								playerTurn.setText(temp30 + "'s Turn");
								six = true;
							}
							else if(playerController.getAccountSeven() && !seven) { 
								Scanner s7 = new Scanner(new File("gui/7.txt"));
								String temp29 = s7.nextLine();
								temp29 = temp29.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp29);
								playerTurn.setText(temp29 + "'s Turn");
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner s8 = new Scanner(new File("gui/8.txt"));
								String temp28 = s8.nextLine();
								temp28 = temp28.replaceAll("\\s+|Name:","");	
								playerOne.setText(temp28);
								playerTurn.setText(temp28 + "'s Turn");
							}
							break;
					case 2: if(playerController.getAccountTwo() && !two) { 
								Scanner d2 = new Scanner(new File("gui/2.txt"));
								String temp27 = d2.nextLine();
								temp27 = temp27.replaceAll("\\s+|Name:","");	
								playerTwo.setText(temp27); 
								two = true;
							}
							else if(playerController.getAccountThree() && !three) { 
								Scanner d3 = new Scanner(new File("gui/3.txt"));
								String temp26 = d3.nextLine();
								temp26 = temp26.replaceAll("\\s+|Name:","");	
								playerTwo.setText(temp26); 
								three = true;
							}
							else if(playerController.getAccountFour() && !four) { 
								Scanner d4 = new Scanner(new File("gui/4.txt"));
								String temp25 = d4.nextLine();
								temp25 = temp25.replaceAll("\\s+|Name:","");	
								playerTwo.setText(temp25); 
								four = true;
							}
							else if(playerController.getAccountFive() && !five) { 
								Scanner d5 = new Scanner(new File("gui/5.txt"));
								String temp24 = d5.nextLine();
								temp24 = temp24.replaceAll("\\s+|Name:","");	
								playerTwo.setText(temp24); 
								five = true;
							}
							else if(playerController.getAccountSix() && !six) { 
								Scanner d6 = new Scanner(new File("gui/6.txt"));
								String temp23 = d6.nextLine();
								temp23 = temp23.replaceAll("\\s+|Name:","");	
								playerTwo.setText(temp23); 
								six = true;
							}
							else if(playerController.getAccountSeven() && !seven) { 
								Scanner d7 = new Scanner(new File("gui/7.txt"));
								String temp22 = d7.nextLine();
								temp22 = temp22.replaceAll("\\s+|Name:","");									
								playerTwo.setText(temp22); 
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner d8 = new Scanner(new File("gui/8.txt"));
								String temp21 = d8.nextLine();
								temp21 = temp21.replaceAll("\\s+|Name:","");	
								playerTwo.setText(temp21); 								
							}
							break;
					case 3: if(playerController.getAccountThree() && !three) { 
								Scanner f3 = new Scanner(new File("gui/3.txt"));
								String temp20 = f3.nextLine();
								temp20 = temp20.replaceAll("\\s+|Name:","");	
								playerThree.setText(temp20); 
								three = true;
							}
							else if(playerController.getAccountFour() && !four) { 
								Scanner f4 = new Scanner(new File("gui/4.txt"));
								String temp19 = f4.nextLine();
								temp19 = temp19.replaceAll("\\s+|Name:","");	
								playerThree.setText(temp19); 
								four = true;
							}
							else if(playerController.getAccountFive() && !five) { 
								Scanner f5 = new Scanner(new File("gui/5.txt"));
								String temp18 = f5.nextLine();
								temp18 = temp18.replaceAll("\\s+|Name:","");	
								playerThree.setText(temp18); 
								five = true;
							}
							else if(playerController.getAccountSix() && !six) { 
								Scanner f6 = new Scanner(new File("gui/6.txt"));
								String temp17 = f6.nextLine();
								temp17 = temp17.replaceAll("\\s+|Name:","");									
								playerThree.setText(temp17); 
								six = true;
							}
							else if(playerController.getAccountSeven() && !seven) { 
								Scanner f7 = new Scanner(new File("gui/7.txt")); 
								String temp16 = f7.nextLine();
								temp16 = temp16.replaceAll("\\s+|Name:","");	
								playerThree.setText(temp16); 
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner f8 = new Scanner(new File("gui/8.txt"));
								String temp15 = f8.nextLine();
								temp15 = temp15.replaceAll("\\s+|Name:","");	
								playerThree.setText(temp15); 								
							}
							break;
					case 4: if(playerController.getAccountFour() && !four) { 
								Scanner g4 = new Scanner(new File("gui/4.txt"));
								String temp14 = g4.nextLine();
								temp14 = temp14.replaceAll("\\s+|Name:","");	
								playerFour.setText(temp14); 
								four = true;
							}
							else if(playerController.getAccountFive() && !five) { 
								Scanner g5 = new Scanner(new File("gui/5.txt")); 
								String temp13 = g5.nextLine();
								temp13 = temp13.replaceAll("\\s+|Name:","");	
								playerFour.setText(temp13); 
								five = true;
							}
							else if(playerController.getAccountSix() && !six) { 
								Scanner g6 = new Scanner(new File("gui/6.txt")); 
								String temp12 = g6.nextLine();
								temp12 = temp12.replaceAll("\\s+|Name:","");	
								playerFour.setText(temp12); 
								six = true;
							}
							else if(playerController.getAccountSeven() && !seven) { 
								Scanner g7 = new Scanner(new File("gui/7.txt")); 
								String temp11 = g7.nextLine();
								temp11 = temp11.replaceAll("\\s+|Name:","");	
								playerFour.setText(temp11); 
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner g8 = new Scanner(new File("gui/8.txt"));
								String temp10 = g8.nextLine();
								temp10 = temp10.replaceAll("\\s+|Name:","");									
								playerFour.setText(temp10); 								
							}
							break;
					case 5: if(playerController.getAccountFive() && !five) { 
								Scanner h5 = new Scanner(new File("gui/5.txt"));
								String temp9 = h5.nextLine();
								temp9 = temp9.replaceAll("\\s+|Name:","");								
								playerFive.setText(temp9); 
								five = true;
							}
							else if(playerController.getAccountSix() && !six) { 
								Scanner h6 = new Scanner(new File("gui/6.txt")); 
								String temp8 = h6.nextLine();
								temp8 = temp8.replaceAll("\\s+|Name:","");
								playerFive.setText(temp8); 
								six = true;
							}
							else if(playerController.getAccountSeven() && !seven) { 
								Scanner h7 = new Scanner(new File("gui/7.txt")); 
								String temp7 = h7.nextLine();
								temp7 = temp7.replaceAll("\\s+|Name:","");
								playerFive.setText(temp7); 
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner h8 = new Scanner(new File("gui/8.txt")); 
								String temp6 = h8.nextLine();
								temp6 = temp6.replaceAll("\\s+|Name:","");
								playerFive.setText(temp6); 								
							}
							break;
					case 6: if(playerController.getAccountSix() && !six) { 
								Scanner j6 = new Scanner(new File("gui/6.txt")); 
								String temp5 = j6.nextLine();
								temp5 = temp5.replaceAll("\\s+|Name:","");
								playerSix.setText(temp5); 
								six = true;
							}
							else if(playerController.getAccountSeven() && !seven) { 
								Scanner j7 = new Scanner(new File("gui/7.txt")); 
								String temp4 = j7.nextLine();
								temp4 = temp4.replaceAll("\\s+|Name:","");
								playerSix.setText(temp4); 
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner j8 = new Scanner(new File("gui/8.txt")); 
								String temp3 = j8.nextLine();
								temp3 = temp3.replaceAll("\\s+|Name:","");
								playerSix.setText(temp3); 								
							}
							break;
					case 7: if(playerController.getAccountSeven() && !seven) { 
								Scanner k7 = new Scanner(new File("gui/7.txt")); 
								String temp2 = k7.nextLine();
								temp2 = temp2.replaceAll("\\s+|Name:","");
								playerSeven.setText(temp2); 
								seven = true;
							}
							else if(playerController.getAccountEight()) { 
								Scanner k8 = new Scanner(new File("gui/8.txt")); 
								String temp1 = k8.nextLine();
								temp1 = temp1.replaceAll("\\s+|Name:","");
								playerSeven.setText(temp1); 								
							}
							break;
					case 8: if(playerController.getAccountEight()) { 
								Scanner z8 = new Scanner(new File("gui/8.txt")); 
								String temp = z8.nextLine();
								temp = temp.replaceAll("\\s+|Name:","");
								playerEight.setText(temp); 
							}
							break;
					default: break;
				}
			}
		} catch(FileNotFoundException ex) {
			Alert alert = new Alert(AlertType.ERROR, "A FILE WAS NOT FOUND!");
            alert.showAndWait();
			System.out.println(ex);
		} 	
		this.zombies = new ArrayList<Zombie>();
		int max = playerController.getNumP() + playerController.getNumC();
		int tracker = 2;
		while(true) {
			if(!playerOne.getText().toString().equals("Player 1")) this.zOne = new Zombie(1, 0);
			zombies.add(zOne);
			
			if(!playerTwo.getText().toString().equals("Player 2")) zTwo = new Zombie(2, 0);
			zombies.add(zTwo);
			
			if(tracker == max) break;
			else ++tracker;
			if(!playerThree.getText().toString().equals("Player 3")) zThree = new Zombie(3, 0);
			zombies.add(zThree);
			
			if(tracker == max) break;
			else ++tracker;
			if(!playerFour.getText().toString().equals("Player 4")) zFour = new Zombie(4, 0);
			zombies.add(zFour);
			
			if(tracker == max) break;
			else ++tracker;
			if(!playerFive.getText().toString().equals("Player 5")) zFive = new Zombie(5, 0);
			zombies.add(zFive);
			
			if(tracker == max) break;
			else ++tracker;
			if(!playerSix.getText().equals("Player 6")) zSix = new Zombie(6, 0);
			zombies.add(zSix);
			
			if(tracker == max) break;
			else ++tracker;
			if(!playerSeven.getText().toString().equals("Player 7")) zSeven = new Zombie(7, 0);
			zombies.add(zSeven);
			
			if(tracker == max) break;
			else if(!playerEight.getText().toString().equals("Player 8")) zEight = new Zombie(8, 0);
			zombies.add(zEight);
			break;
		}
		this.SB = diceController.getBus();
		this.SC = diceController.getSanta();
		this.HH = diceController.getHH();
		this.lastRound = false;
		this.counter = 0;
		this.maxBrains = 0;
		this.numShotguns = 0;
		this.numBrains = 0;
		this.numFeet = 0;
		this.greenFeet = 0;
		this.yellowFeet = 0;
		this.redFeet = 0;
		this.greenShotguns = 0;
		this.redShotguns = 0;
		this.yellowShotguns = 0;
		this.hottieFeet = false;
		this.hunkFeet = false;
		this.hottieShotgun = false;
		this.hunkShotgun = false;
		this.hottieBrain = false;
		this.hunkBrain = false;
		this.santaBrain = false;
		this.santaShotgun = false;
		this.santaFeet = false;
		this.santaHelmet = false;
		this.santaEnergy = false;
		this.hasRolledBus = false;
		this.noMoreBus = false;
		this.stopSign = false;
		this.cup = refillCup();
		this.die1 = cup.get(randGen.nextInt(cup.size()-1));
		this.die2 = cup.get(randGen.nextInt(cup.size()-1));
		this.die3 = cup.get(randGen.nextInt(cup.size()-1));
		this.cup.remove(die1);
		this.cup.remove(die2);
		this.cup.remove(die3);
		this.zombiesHolder = new ArrayList<Zombie>();
		zombiesHolder.addAll(zombies);
	}
}
