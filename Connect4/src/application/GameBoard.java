package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameBoard {
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private Circle circle1; @FXML private Circle circle2; @FXML private Circle circle3; @FXML private Circle circle4; @FXML private Circle circle5; @FXML private Circle circle6; @FXML private Circle circle7;
	@FXML private Circle circle8; @FXML private Circle circle9; @FXML private Circle circle10; @FXML private Circle circle11; @FXML private Circle circle12; @FXML private Circle circle13; @FXML private Circle circle14;
	@FXML private Circle circle15; @FXML private Circle circle16; @FXML private Circle circle17; @FXML private Circle circle18; @FXML private Circle circle19; @FXML private Circle circle20; @FXML private Circle circle21;
	@FXML private Circle circle22; @FXML private Circle circle23; @FXML private Circle circle24; @FXML private Circle circle25; @FXML private Circle circle26; @FXML private Circle circle27; @FXML private Circle circle28;
	@FXML private Circle circle29; @FXML private Circle circle30; @FXML private Circle circle31; @FXML private Circle circle32; @FXML private Circle circle33; @FXML private Circle circle34; @FXML private Circle circle35;
	@FXML private Circle circle36; @FXML private Circle circle37; @FXML private Circle circle38; @FXML private Circle circle39; @FXML private Circle circle40; @FXML private Circle circle41; @FXML private Circle circle42;

	@FXML private Button column1; @FXML private Button column2; @FXML private Button column3; @FXML private Button column4; @FXML private Button column5; @FXML private Button column6; @FXML private Button column7;
	
	@FXML private Label winner; @FXML private Button exit; @FXML private Button save; @FXML private Button reset; @FXML private Button moveLogButton; @FXML private Label moveLogLabel;
	@FXML private ScrollPane moveLogScrollPane; @FXML private Rectangle moveLogRec;
	
	private int opponent; // 1 = easy AI, 2 = hard AI, 0 = human
	private boolean gameOver;
	private boolean gameLog = false;
	private Board game;
	private Computer AI = new Computer();;
	private String moveLogString = "";
	private String moves = "";
	
		
	
	public void initialize() throws FileNotFoundException {
		ColumnC columnC1 = new ColumnC(circle36, circle29, circle22, circle15, circle8, circle1);
		ColumnC columnC2 = new ColumnC(circle37, circle30, circle23, circle16, circle9, circle2);
		ColumnC columnC3 = new ColumnC(circle38, circle31, circle24, circle17, circle10, circle3);
		ColumnC columnC4 = new ColumnC(circle39, circle32, circle25, circle18, circle11, circle4);
		ColumnC columnC5 = new ColumnC(circle40, circle33, circle26, circle19, circle12, circle5);
		ColumnC columnC6 = new ColumnC(circle41, circle34, circle27, circle20, circle13, circle6);
		ColumnC columnC7 = new ColumnC(circle42, circle35, circle28, circle21, circle14, circle7);
		
		ColumnI columnI1 = new ColumnI(0,0,0,0,0,0);
		ColumnI columnI2 = new ColumnI(0,0,0,0,0,0);
		ColumnI columnI3 = new ColumnI(0,0,0,0,0,0);
		ColumnI columnI4 = new ColumnI(0,0,0,0,0,0);
		ColumnI columnI5 = new ColumnI(0,0,0,0,0,0);
		ColumnI columnI6 = new ColumnI(0,0,0,0,0,0);
		ColumnI columnI7 = new ColumnI(0,0,0,0,0,0);

		ColumnC[] columnsC = {columnC1, columnC2, columnC3, columnC4, columnC5, columnC6, columnC7};
		ColumnI[] columnsI = {columnI1, columnI2, columnI3, columnI4, columnI5, columnI6, columnI7};
			
		game = new Board(columnsC, columnsI);
		
		
		
		winner.setVisible(false);	
		gameOver = false;
		moveLogLabel.setText("");
		moveLogLabel.setVisible(false);
		moveLogScrollPane.setVisible(false);
		moveLogRec.setVisible(false);
	}
	
	// choosing player
	public void setPlayer(int x) {
		opponent = x;
	}
	
	
	// check and win
	public void win() {
		column1.setDisable(true);
		column2.setDisable(true);
		column3.setDisable(true);
		column4.setDisable(true);
		column5.setDisable(true);
		column6.setDisable(true);
		column7.setDisable(true);
		if (game.getTurn() == 1) {
			winner.setText("Red Wins!");
			winner.setStyle("-fx-text-fill: darkred; -fx-font-size: 31px;");
			winner.setVisible(true);
		}
		else {
			winner.setText("Yellow Wins!");
			winner.setStyle("-fx-text-fill: yellow; -fx-font-size: 31px;");
			winner.setVisible(true);
		}
		gameOver = true;
		
	}


	// Turns
	public void compTurn() throws IOException {
		int col = 0;
		if (opponent == 1 && !gameOver) {
			col = AI.turn();
			while (game.getColCounter(col) == 7) {
				col = AI.turn();
			}
			game.turn(col);
		} else if (opponent == 2 && !gameOver) {
			col = AI.turn(game);
			while (game.getColCounter(col) == 7) {
				col = AI.turn();
			}
			game.turn(col);
		}
		game.iterateTurn();
		logMove(col);
		game.iterateTurn();
		if (game.check(col)) {
			win();
		}
	}
	
	public void column1turn() throws IOException {
		logMove(1);
		game.turn(1);
		if (game.getColCounter(1) == 7) {
			column1.setDisable(true);
		}
		if (game.check(1)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
		
	}
	public void column2turn() throws IOException {
		logMove(2);
		game.turn(2);
		if (game.getColCounter(2) == 7) {
			column2.setDisable(true);
		}
		if (game.check(2)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
	}
	public void column3turn() throws IOException {
		logMove(3);
		game.turn(3);
		if (game.getColCounter(3) == 7) {
			column3.setDisable(true);
		}
		if (game.check(3)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
	}
	public void column4turn() throws IOException {
		logMove(4);
		game.turn(4);
		if (game.getColCounter(4) == 7) {
			column4.setDisable(true);
		}
		if (game.check(4)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
	}
	public void column5turn() throws IOException {
		logMove(5);
		game.turn(5);
		if (game.getColCounter(5) == 7) {
			column5.setDisable(true);
		}
		if (game.check(5)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
	}
	public void column6turn() throws IOException {
		logMove(6);
		game.turn(6);
		if (game.getColCounter(6) == 7) {
			column6.setDisable(true);
		}
		if (game.check(6)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
	}
	public void column7turn() throws IOException {
		logMove(7);
		game.turn(7);
		if (game.getColCounter(7) == 7) {
			column7.setDisable(true);
		}
		if (game.check(7)) {
			win();
		}
		if (opponent != 0) {
			compTurn();
		}
	}
	
	// Exit, Save, Reset, Move Log
	public void exitGame(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Title.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void reset(ActionEvent e) throws IOException {		
		root = FXMLLoader.load(getClass().getResource("ChoosePlayer.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void moveLog(ActionEvent e) {
		if (gameLog) {
			moveLogLabel.setVisible(false);
			moveLogScrollPane.setVisible(false);
			moveLogRec.setVisible(false);
			gameLog = false;
		} else {
			moveLogLabel.setVisible(true);
			moveLogScrollPane.setVisible(true);
			moveLogRec.setVisible(true);
			gameLog = true;
		}
	}
	
	public void logMove(int col) throws IOException {
		if (game.getTurn() == 1) {
			moveLogString += " Red made a move in column " + col + "\n";
		} else {
			moveLogString += " Yellow made a move in column " + col + "\n";
		}
		moveLogLabel.setText(moveLogString);
		moves += col + "\n";
	}
	
	public void save(ActionEvent e) throws IOException {
		FileWriter fwOb = new FileWriter("SaveGame", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
		
		PrintWriter pw = new PrintWriter("SaveGame.txt");
		pw.println(opponent);
		pw.print(moves);
		pw.close();
		root = FXMLLoader.load(getClass().getResource("Title.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void load() throws FileNotFoundException {
		File file = new File("SaveGame.txt");
		Scanner readFile = new Scanner(file);
		if (readFile.hasNext()) {
			opponent = readFile.nextInt();
		}
		while (readFile.hasNext()) {
			game.turn(readFile.nextInt());
		}
		readFile.close();
	}
	
	
}
