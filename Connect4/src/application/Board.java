package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Board {
	private ColumnC[] columnCircles;
	private ColumnI[] columnShadow;
	int turn = 1; // 1 red turn, -1 is yellow turn
	
	public Board(ColumnC[] x, ColumnI[] y) {
		columnCircles = x;
		columnShadow = y;
	}
	
	public boolean turn(int col) {
		if (columnShadow[col-1].turn(turn)) {
			columnCircles[col-1].turn(turn);
			turn *= -1;
			return true;
		}
		return false;
	}
	
	public boolean check(int col) {
		col -= 1;
		if (col < 0)
			return false;
		
		
		ColumnI colS = columnShadow[col];
		
		// checks vertical
		int colSCounter = colS.getColCounter() - 1;
		
		if (colSCounter - 3 > 0) {
			if (	columnShadow[col].getValue(colSCounter-1) == columnShadow[col].getValue(colSCounter-2) &&
					columnShadow[col].getValue(colSCounter-2) == columnShadow[col].getValue(colSCounter-3) &&
					(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter-1) == -1)) {
				turn *=-1;
				return true;
				}
		}
		
		// check horizontal
		if (columnShadow[0].getValue(colSCounter) == columnShadow[1].getValue(colSCounter) && columnShadow[0].getValue(colSCounter) == columnShadow[2].getValue(colSCounter) && columnShadow[0].getValue(colSCounter) == columnShadow[3].getValue(colSCounter) && (columnShadow[3].getValue(colSCounter) == 1 || columnShadow[3].getValue(colSCounter) == -1)) {
			turn *=-1;
			return true;
		}
		if (columnShadow[1].getValue(colSCounter) == columnShadow[2].getValue(colSCounter) && columnShadow[2].getValue(colSCounter) == columnShadow[3].getValue(colSCounter) && columnShadow[3].getValue(colSCounter) == columnShadow[4].getValue(colSCounter) && (columnShadow[3].getValue(colSCounter) == 1 || columnShadow[3].getValue(colSCounter) == -1)) {
			turn *=-1;
			return true;
		}
		if (columnShadow[2].getValue(colSCounter) == columnShadow[3].getValue(colSCounter) && columnShadow[3].getValue(colSCounter) == columnShadow[4].getValue(colSCounter) && columnShadow[4].getValue(colSCounter) == columnShadow[5].getValue(colSCounter) && (columnShadow[3].getValue(colSCounter) == 1 || columnShadow[3].getValue(colSCounter) == -1)) {
			turn *=-1;
			return true;
		}
		if (columnShadow[4].getValue(colSCounter) == columnShadow[3].getValue(colSCounter) && columnShadow[3].getValue(colSCounter) == columnShadow[5].getValue(colSCounter) && columnShadow[4].getValue(colSCounter) == columnShadow[6].getValue(colSCounter) && (columnShadow[3].getValue(colSCounter) == 1 || columnShadow[3].getValue(colSCounter) == -1)) {
			turn *=-1;
			return true;
		}
		
		// check up right diagonal		
		if (col - 3 >= 0 && colSCounter - 3 > 0) {
			if (columnShadow[col - 3].getValue(colSCounter - 3) == columnShadow[col - 2].getValue(colSCounter - 2) &&
				columnShadow[col - 2].getValue(colSCounter - 2) == columnShadow[col - 1].getValue(colSCounter - 1) &&
				columnShadow[col - 1].getValue(colSCounter - 1) == columnShadow[col].getValue(colSCounter) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		if (col - 2 >= 0 && colSCounter - 2 > 0 && col + 1 < 7 && colSCounter + 1 < 7) {
			if (columnShadow[col - 2].getValue(colSCounter - 2) == columnShadow[col - 1].getValue(colSCounter - 1) &&
				columnShadow[col].getValue(colSCounter) == columnShadow[col - 1].getValue(colSCounter - 1) &&
				columnShadow[col + 1].getValue(colSCounter + 1) == columnShadow[col].getValue(colSCounter) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		if (col - 1 >= 0 && colSCounter - 1 > 0 && col + 2 < 7 && colSCounter + 2 < 7) {
			if (columnShadow[col - 1].getValue(colSCounter - 1) == columnShadow[col].getValue(colSCounter) &&
				columnShadow[col].getValue(colSCounter) == columnShadow[col + 1].getValue(colSCounter + 1) &&
				columnShadow[col + 1].getValue(colSCounter + 1) == columnShadow[col + 2].getValue(colSCounter + 2) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		if (col + 3 < 7 && colSCounter + 3 < 7) {
			if (columnShadow[col + 3].getValue(colSCounter + 3) == columnShadow[col + 2].getValue(colSCounter + 2) &&
				columnShadow[col + 2].getValue(colSCounter + 2) == columnShadow[col + 1].getValue(colSCounter + 1) &&
				columnShadow[col + 1].getValue(colSCounter + 1) == columnShadow[col].getValue(colSCounter) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		
		// check down right diagonal		
		if (col + 3 < 7 && colSCounter - 3 > 0) {
			if (columnShadow[col + 3].getValue(colSCounter - 3) == columnShadow[col + 2].getValue(colSCounter - 2) &&
				columnShadow[col + 2].getValue(colSCounter - 2) == columnShadow[col + 1].getValue(colSCounter - 1) &&
				columnShadow[col + 1].getValue(colSCounter - 1) == columnShadow[col].getValue(colSCounter) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		if (col + 2 < 7 && colSCounter - 2 > 0 && col - 1 >= 0 && colSCounter + 1 < 7) {
			if (columnShadow[col + 2].getValue(colSCounter - 2) == columnShadow[col + 1].getValue(colSCounter - 1) &&
				columnShadow[col].getValue(colSCounter) == columnShadow[col + 1].getValue(colSCounter - 1) &&
				columnShadow[col - 1].getValue(colSCounter + 1) == columnShadow[col].getValue(colSCounter) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		if (col + 1 < 7 && colSCounter - 1 > 0 && col - 2 >= 0 && colSCounter + 2 < 7) {
			if (columnShadow[col + 1].getValue(colSCounter - 1) == columnShadow[col].getValue(colSCounter) &&
				columnShadow[col].getValue(colSCounter) == columnShadow[col - 1].getValue(colSCounter + 1) &&
				columnShadow[col - 1].getValue(colSCounter + 1) == columnShadow[col - 2].getValue(colSCounter + 2) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		if (col - 3 >= 0 && colSCounter + 3 < 7) {
			if (columnShadow[col - 3].getValue(colSCounter + 3) == columnShadow[col - 2].getValue(colSCounter + 2) &&
				columnShadow[col - 2].getValue(colSCounter + 2) == columnShadow[col - 1].getValue(colSCounter + 1) &&
				columnShadow[col - 1].getValue(colSCounter + 1) == columnShadow[col].getValue(colSCounter) &&
				(columnShadow[col].getValue(colSCounter) == 1 || columnShadow[col].getValue(colSCounter) == -1)) {
				turn *= -1;
				return true;
			}
		}
		
		
		
		
		return false;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int getColCounter(int col) {
		return columnShadow[col-1].getColCounter();
	}
	
	public ColumnI[] getColI() {
		return columnShadow;
	}
	
	public void iterateTurn() {
		turn *= -1;
	}
	
	public void save() throws IOException {
		
	}
	
	
	public void load(String x) {
		int index = 0;
		char value;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				value = x.charAt(index);
				//System.out.println("Value for " + i + ", " + j +" = " + value);
				if (value == '1') {
					columnShadow[i].setValue(j, 1);
					columnCircles[i].setValue(j, 1);
				} else if (value == '2') {
					columnShadow[i].setValue(j, -1);
					columnCircles[i].setValue(j, -1);
				}
				index++;
			}
		}
	}
	
	
	
}
