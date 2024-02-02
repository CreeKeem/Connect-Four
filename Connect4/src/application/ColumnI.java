package application;


public class ColumnI {
	private int r1;
	private int r2;
	private int r3;
	private int r4;
	private int r5;
	private int r6;

	private int colCounter = 1;
	
	public ColumnI(int t1, int t2, int t3, int t4, int t5, int t6) {
		r1= t1;
		r2 = t2;
		r3 = t3;
		r4 = t4;
		r5 = t5;
		r6 = t6;
	}
	
	public boolean turn(int turn) {
		switch(colCounter) {
		case 1:
			r1 = turn;
			break;
		case 2:
			r2 = turn;
			break;
		case 3:
			r3 = turn;
			break;
		case 4:
			r4 = turn;
			break;
		case 5:
			r5 = turn;
			break;
		case 6:
			r6 = turn;
			break;
		default:
			return false;
		}
		colCounter++;
		return true;
	}
	
	public int getValue(int position) {
		switch(position) {
		case 1:
			return r1;
		case 2:
			return r2;
		case 3:
			return r3;
		case 4:
			return r4;
		case 5:
			return r5;
		case 6:
			return r6;
		}
		return 2;
	}
	
	public int getColCounter() {
		return colCounter;
	}
	
	public void setValue(int row, int val) {
		switch(row) {
		case 1:
			r1 = val;
		case 2:
			r2 = val;
		case 3:
			r3 = val;
		case 4:
			r4 = val;
		case 5:
			r5 = val;
		case 6:
			r6 = val;
		}
	}
}
