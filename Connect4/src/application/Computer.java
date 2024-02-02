package application;

public class Computer {
	
	public Computer() {
	}
	
	public int turn() {
		return (int) (Math.random() * 6) + 1;
	}
	
	public int turn(Board game) {
		int canWin = canWin(game);
		if (canWin > -1) {
			return canWin;
		}
		int canLose = canLose(game);
		if(canLose > -1) {
			return canLose;
		}
		return  (int) (Math.random() * 6) + 1;
	}
	
	public int canWin(Board game) {
		ColumnI[] columnShadow = game.getColI();
		
		for (int i = 0; i < 7; i++) {
			ColumnI colS = columnShadow[i];
			int colSCounter = colS.getColCounter();
			
			if (colSCounter - 3 > 0) {
				if (	columnShadow[i].getValue(colSCounter-1) == columnShadow[i].getValue(colSCounter-2) &&
						columnShadow[i].getValue(colSCounter-2) == columnShadow[i].getValue(colSCounter-3) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i].getValue(colSCounter-1) == -1) {
						return i + 1;
					}
			}
			
			// check horizontal
			if (i - 3 >= 0) {
				if (	columnShadow[i-1].getValue(colSCounter) == columnShadow[i-2].getValue(colSCounter) &&
						columnShadow[i-2].getValue(colSCounter) == columnShadow[i-3].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i-1].getValue(colSCounter) == -1) {
						return i + 1;
					}
			}
			if (i - 2 >= 0 && i + 1 < 7) {
				if (	columnShadow[i-1].getValue(colSCounter) == columnShadow[i-2].getValue(colSCounter) &&
						columnShadow[i-2].getValue(colSCounter) == columnShadow[i+1].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i-1].getValue(colSCounter) == -1) {
						return i + 1;
					}
			}
			if (i - 1 >= 0 && i + 2 < 7) {
				if (	columnShadow[i-1].getValue(colSCounter) == columnShadow[i+1].getValue(colSCounter) &&
						columnShadow[i+2].getValue(colSCounter) == columnShadow[i+1].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i-1].getValue(colSCounter) == -1) {
						return i + 1;
					}
			}
			if (i + 3 < 7) {
				if (	columnShadow[i+1].getValue(colSCounter) == columnShadow[i+2].getValue(colSCounter) &&
						columnShadow[i+2].getValue(colSCounter) == columnShadow[i+3].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i+1].getValue(colSCounter) == -1) {
						return i + 1;
					}
			}
			
			// check up right diagonal		
			if (i - 3 >= 0 && colSCounter - 3 > 0) {
				if (columnShadow[i - 3].getValue(colSCounter - 3) == columnShadow[i - 2].getValue(colSCounter - 2) &&
					columnShadow[i - 2].getValue(colSCounter - 2) == columnShadow[i - 1].getValue(colSCounter - 1) &&
					columnShadow[i - 1].getValue(colSCounter - 1) == -1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			if (i - 2 >= 0 && colSCounter - 2 > 0 && i + 1 < 7 && colSCounter + 1 < 7) {
				if (columnShadow[i - 2].getValue(colSCounter - 2) == columnShadow[i - 1].getValue(colSCounter - 1) &&
					columnShadow[i].getValue(colSCounter) == columnShadow[i - 1].getValue(colSCounter - 1) &&
					columnShadow[i + 1].getValue(colSCounter + 1) == -1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			if (i - 1 >= 0 && colSCounter - 1 > 0 && i + 2 < 7 && colSCounter + 2 < 7) {
				if (columnShadow[i - 1].getValue(colSCounter - 1) == columnShadow[i].getValue(colSCounter) &&
					-1 == columnShadow[i + 1].getValue(colSCounter + 1) &&
					columnShadow[i + 1].getValue(colSCounter + 1) == columnShadow[i + 2].getValue(colSCounter + 2) &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			if (i + 3 < 7 && colSCounter + 3 < 7) {
				if (columnShadow[i + 3].getValue(colSCounter + 3) == columnShadow[i + 2].getValue(colSCounter + 2) &&
					columnShadow[i + 2].getValue(colSCounter + 2) == columnShadow[i + 1].getValue(colSCounter + 1) &&
					columnShadow[i + 1].getValue(colSCounter + 1) == -1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			
			// check down right diagonal		
			if (i + 3 < 7 && colSCounter - 3 > 0) {
				if (columnShadow[i + 3].getValue(colSCounter - 3) == columnShadow[i + 2].getValue(colSCounter - 2) &&
					columnShadow[i + 2].getValue(colSCounter - 2) == columnShadow[i + 1].getValue(colSCounter - 1) &&
					columnShadow[i + 1].getValue(colSCounter - 1) == -1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
			if (i + 2 < 7 && colSCounter - 2 > 0 && i - 1 >= 0 && colSCounter + 1 < 7) {
				if (columnShadow[i + 2].getValue(colSCounter - 2) == columnShadow[i + 1].getValue(colSCounter - 1) &&
					-1 == columnShadow[i + 1].getValue(colSCounter - 1) &&
					columnShadow[i - 1].getValue(colSCounter + 1) == columnShadow[i + 1].getValue(colSCounter - 1) &&
					columnShadow[i].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
			if (i + 1 < 7 && colSCounter - 1 > 0 && i - 2 >= 0 && colSCounter + 2 < 7) {
				if (columnShadow[i + 1].getValue(colSCounter - 1) == columnShadow[i - 2].getValue(colSCounter + 2) &&
					columnShadow[i + 1].getValue(colSCounter - 1) == -1 &&
					columnShadow[i - 1].getValue(colSCounter + 1) == columnShadow[i - 2].getValue(colSCounter + 2) &&
					columnShadow[i ].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
			if (i - 3 >= 0 && colSCounter + 3 < 7) {
				if (columnShadow[i - 3].getValue(colSCounter + 3) == columnShadow[i - 2].getValue(colSCounter + 2) &&
					columnShadow[i - 2].getValue(colSCounter + 2) == columnShadow[i - 1].getValue(colSCounter + 1) &&
					columnShadow[i - 1].getValue(colSCounter + 1) == -1 &&
					columnShadow[i ].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
		}
		
		
		return -1;
	}
	
	public int canLose(Board game) {
ColumnI[] columnShadow = game.getColI();
		
		for (int i = 0; i < 7; i++) {
			ColumnI colS = columnShadow[i];
			int colSCounter = colS.getColCounter();
			
			if (colSCounter - 3 > 0) {
				if (	columnShadow[i].getValue(colSCounter-1) == columnShadow[i].getValue(colSCounter-2) &&
						columnShadow[i].getValue(colSCounter-2) == columnShadow[i].getValue(colSCounter-3) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i].getValue(colSCounter-1) == 1) {
						return i + 1;
					}
			}
			
			// check horizontal
			if (i - 3 >= 0) {
				if (	columnShadow[i-1].getValue(colSCounter) == columnShadow[i-2].getValue(colSCounter) &&
						columnShadow[i-2].getValue(colSCounter) == columnShadow[i-3].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i-1].getValue(colSCounter) == 1) {
						return i + 1;
					}
			}
			if (i - 2 >= 0 && i + 1 < 7) {
				if (	columnShadow[i-1].getValue(colSCounter) == columnShadow[i-2].getValue(colSCounter) &&
						columnShadow[i-2].getValue(colSCounter) == columnShadow[i+1].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i-1].getValue(colSCounter) == 1) {
						return i + 1;
					}
			}
			if (i - 1 >= 0 && i + 2 < 7) {
				if (	columnShadow[i-1].getValue(colSCounter) == columnShadow[i+1].getValue(colSCounter) &&
						columnShadow[i+2].getValue(colSCounter) == columnShadow[i+1].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i-1].getValue(colSCounter) == 1) {
						return i + 1;
					}
			}
			if (i + 3 < 7) {
				if (	columnShadow[i+1].getValue(colSCounter) == columnShadow[i+2].getValue(colSCounter) &&
						columnShadow[i+2].getValue(colSCounter) == columnShadow[i+3].getValue(colSCounter) &&
						columnShadow[i].getValue(colSCounter) == 0 && columnShadow[i+1].getValue(colSCounter) == 1) {
						return i + 1;
					}
			}
			
			// check up right diagonal		
			if (i - 3 >= 0 && colSCounter - 3 > 0) {
				if (columnShadow[i - 3].getValue(colSCounter - 3) == columnShadow[i - 2].getValue(colSCounter - 2) &&
					columnShadow[i - 2].getValue(colSCounter - 2) == columnShadow[i - 1].getValue(colSCounter - 1) &&
					columnShadow[i - 1].getValue(colSCounter - 1) == 1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			if (i - 2 >= 0 && colSCounter - 2 > 0 && i + 1 < 7 && colSCounter + 1 < 7) {
				if (columnShadow[i - 2].getValue(colSCounter - 2) == columnShadow[i - 1].getValue(colSCounter - 1) &&
					columnShadow[i].getValue(colSCounter) == columnShadow[i - 1].getValue(colSCounter -1) &&
					columnShadow[i + 1].getValue(colSCounter + 1) == 1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			if (i - 1 >= 0 && colSCounter - 1 > 0 && i + 2 < 7 && colSCounter + 2 < 7) {
				if (columnShadow[i - 1].getValue(colSCounter - 1) == columnShadow[i].getValue(colSCounter) &&
					1 == columnShadow[i + 1].getValue(colSCounter + 1) &&
					columnShadow[i + 1].getValue(colSCounter + 1) == columnShadow[i + 2].getValue(colSCounter + 2) &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			if (i + 3 < 7 && colSCounter + 3 < 7) {
				if (columnShadow[i + 3].getValue(colSCounter + 3) == columnShadow[i + 2].getValue(colSCounter + 2) &&
					columnShadow[i + 2].getValue(colSCounter + 2) == columnShadow[i + 1].getValue(colSCounter + 1) &&
					columnShadow[i + 1].getValue(colSCounter + 1) == 1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					return i + 1;
				}
			}
			
			// check down right diagonal		
			if (i + 3 < 7 && colSCounter - 3 > 0) {
				if (columnShadow[i + 3].getValue(colSCounter - 3) == columnShadow[i + 2].getValue(colSCounter - 2) &&
					columnShadow[i + 2].getValue(colSCounter - 2) == columnShadow[i + 1].getValue(colSCounter - 1) &&
					columnShadow[i + 1].getValue(colSCounter - 1) == 1 &&
					columnShadow[i].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
			if (i + 2 < 7 && colSCounter - 2 > 0 && i - 1 >= 0 && colSCounter + 1 < 7) {
				if (columnShadow[i + 2].getValue(colSCounter - 2) == columnShadow[i + 1].getValue(colSCounter - 1) &&
					1 == columnShadow[i + 1].getValue(colSCounter - 1) &&
					columnShadow[i - 1].getValue(colSCounter + 1) == columnShadow[i + 1].getValue(colSCounter - 1) &&
					columnShadow[i].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
			if (i + 1 < 7 && colSCounter - 1 > 0 && i - 2 >= 0 && colSCounter + 2 < 7) {
				if (columnShadow[i + 1].getValue(colSCounter - 1) == columnShadow[i - 2].getValue(colSCounter + 2) &&
					columnShadow[i + 1].getValue(colSCounter - 1) == 1 &&
					columnShadow[i - 1].getValue(colSCounter + 1) == columnShadow[i - 2].getValue(colSCounter + 2) &&
					columnShadow[i ].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
			if (i - 3 >= 0 && colSCounter + 3 < 7) {
				if (columnShadow[i - 3].getValue(colSCounter + 3) == columnShadow[i - 2].getValue(colSCounter + 2) &&
					columnShadow[i - 2].getValue(colSCounter + 2) == columnShadow[i - 1].getValue(colSCounter + 1) &&
					columnShadow[i - 1].getValue(colSCounter + 1) == 1 &&
					columnShadow[i ].getValue(colSCounter) == 0) {
					 
					return i + 1;
				}
			}
		}
		
		
		return -1;
	}
}
