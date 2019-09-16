package gui;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	//javac --module-path "%PATH_TO_FX%" --add-modules=javafx.controls,javafx.fxml,javafx.media gui\Main.java
	//java --module-path "%PATH_TO_FX%" --add-modules=javafx.controls,javafx.fxml,javafx.media gui.Main
    @Override
    public void start(Stage primaryStage) throws Exception {
		String path = new File("gui/zombieDiceThemeMusic.mp3").getAbsolutePath();
        Media media = new Media(new File(path).toURI().toString());
		
		MediaPlayer p1 = new MediaPlayer(media);
		
		p1.setCycleCount(MediaPlayer.INDEFINITE);
		p1.play();
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.3)));
		timeline.setCycleCount(1);
		timeline.play();
		
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/menuFXML.fxml"));
		
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setTitle("Zombie Dice");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
