package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class ColumnC {
	private Circle r1;
	private Circle r2;
	private Circle r3;
	private Circle r4;
	private Circle r5;
	private Circle r6;
	private int colCounter = 1;
	
	public ColumnC(Circle t1, Circle t2, Circle t3, Circle t4, Circle t5, Circle t6) {
		r1= t1;
		r2 = t2;
		r3 = t3;
		r4 = t4;
		r5 = t5;
		r6 = t6;
	}
	
	public void turn(int turn) {
			switch (colCounter) {
			case 1:
				if ((int)turn == 1)
					((Shape) r1).setFill(Color.DARKRED);
				else
					((Shape) r1).setFill(Color.YELLOW);
				break;
			case 2:
				if ((int)turn == 1)
					((Shape) r2).setFill(Color.DARKRED);
				else
					((Shape) r2).setFill(Color.YELLOW);
				break;
			case 3:
				if ((int)turn == 1)
					((Shape) r3).setFill(Color.DARKRED);
				else
					((Shape) r3).setFill(Color.YELLOW);
				break;
			case 4:
				if ((int)turn == 1)
					((Shape) r4).setFill(Color.DARKRED);
				else
					((Shape) r4).setFill(Color.YELLOW);
				break;
			case 5:
				if ((int)turn == 1)
					((Shape) r5).setFill(Color.DARKRED);
				else
					((Shape) r5).setFill(Color.YELLOW);
				break;
			case 6:
				if ((int)turn == 1)
					((Shape) r6).setFill(Color.DARKRED);
				else
					((Shape) r6).setFill(Color.YELLOW);
				break;
			}
		colCounter++;
	}
	
	public void setValue(int row, int value) {
		if(value != 0) {
			switch (row) {
				case 1:
					if (value == 1)
						((Shape) r1).setFill(Color.DARKRED);
					else
						((Shape) r1).setFill(Color.YELLOW);
					break;
				case 2:
					if (value == 1)
						((Shape) r2).setFill(Color.DARKRED);
					else
						((Shape) r2).setFill(Color.YELLOW);
					break;
				case 3:
					if (value == 1)
						((Shape) r3).setFill(Color.DARKRED);
					else
						((Shape) r3).setFill(Color.YELLOW);
					break;
				case 4:
					if (value == 1)
						((Shape) r4).setFill(Color.DARKRED);
					else
						((Shape) r4).setFill(Color.YELLOW);
					break;
				case 5:
					if (value == 1)
						((Shape) r5).setFill(Color.DARKRED);
					else
						((Shape) r5).setFill(Color.YELLOW);
					break;
				case 6:
					if (value == 1)
						((Shape) r6).setFill(Color.DARKRED);
					else
						((Shape) r6).setFill(Color.YELLOW);
					break;
				}
			}
	}
}


