
/**
 * The SeatPosition class stores the seat row and column and has get and set methods to access them.
 * This class also has a constructor and a default constructor.
 * A toString method is also used to print the attributes in a formatted style.
 * 
 * @author Ben Smith
 */

public class SeatPosition {

	private int row;
	private char column;
	
	// constructor for seat
	public SeatPosition(int row, char column){
		this.row = row;
		this.column = column;
	}
	
	// default constructor
	public SeatPosition(){
		this.row = 0;
		this.column = 0;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}
	
	public String toString(){
		return this.getRow() + "" + this.getColumn();
	}
	
}
