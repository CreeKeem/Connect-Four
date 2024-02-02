package application;

import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class TitleController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	// beginning and end functions
	public void start(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ChoosePlayer.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void exitTitle(ActionEvent e) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("Are you sure you want to Exit?");
		alert.setContentText("Press OK to leave");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			System.exit(0);
		}
	}
	
	
	public void load(ActionEvent e) throws IOException {
		Scanner readFile = new Scanner("SaveGame.txt");
		if (readFile.hasNext()) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		root = loader.load();
		GameBoard gameBoardController = loader.getController();
		gameBoardController.load();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		readFile.close();
	}
}
