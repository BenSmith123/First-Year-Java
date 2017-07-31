
/**
 * The SeatMap class is an abstract class that is extended by the BoeingSeatMap and AirBusSeatMap class
 * This class uses a Seat object seatMap to initialise the array.
 * 
 * 
 * @author Ben Smith
 *
 */

public abstract class SeatMap {
	
	private int maxRows;
	private char maxColumns;
	private int maxRowsFirstClass;
	private Seat [][] seatMap;
	
	public abstract void initialiseSeatMap();

	// default constructor
	public SeatMap(){
		setMaxRows(0);
		setMaxColumns('A');
		setMaxRowsFirstClass(0);
	}
	
	// constructor for seatmap
	public SeatMap(int rows, char columns, int rowsFirstClass){
		setMaxRows(rows);
		setMaxColumns(columns);
		setMaxRowsFirstClass(rowsFirstClass);
		//initialiseSeatMap(); // do i need
	}
	
	/**
	 * Populate seats array takes row and column parameter and creates a new seat in the array for the parameter values.
	 * 
	 * 
	 * @param rows
	 * @param columns
	 */
	public void polulateSeatsArray(int rows, char columns) {
		
		setSeatMapArray(new Seat[rows][columns-64]);
		
		for (int r = 0; r < rows; r++){
			
			for (char c = 'A'; c <= columns; c++){
				
				seatMap[r][c - 65] = new Seat();
				
			}
		}
	}

	private void setSeatMapArray(Seat[][] seats) {
		this.seatMap = seats;
	}

	public void setFirstClassRows(int firstClassRows){
		this.maxRowsFirstClass = firstClassRows;
	}


	public Seat[][] getSeatArray(){
		return this.seatMap;
	}
	
	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	public char getMaxColumns() {
		return maxColumns;
	}

	public void setMaxColumns(char maxColumns) {
		this.maxColumns = maxColumns;
	}

	public int getMaxRowsFirstClass() {
		return maxRowsFirstClass;
	}

	public void setMaxRowsFirstClass(int maxRowsFirstClass) {
		this.maxRowsFirstClass = maxRowsFirstClass;
	}
	
	public abstract void setAllSeatType(SeatMap seatMap);
	
	public String toString(){
		
		String seatMapString = "";
		
		seatMapString += "  ";
		
		for (int c = 0; c <= getMaxColumns()-65; c++){
			seatMapString += "    " + (char) (c +65) +"";
		}
		
		seatMapString += "\n";
		

		for (int r = 0; r < getMaxRows(); r++){
			
			if (r+1 <= 9){
				seatMapString += r+1 + "   ";
			} else {
				seatMapString += r+1 + "  ";
			}
			
			for (int c = 0; c <= getMaxColumns()-65; c++){
			
				Seat seat = this.getSeatArray()[r][c];

				if (seat.getIsReserved() == false){
					
					if (seat.getIsFirstClass() == true){
						seatMapString += seat.getSeatType().getSeatTypeString()+"[ ] ";
						System.out.println("debuggg"); // debug
					}
					else{
						seatMapString += seat.getSeatType().getSeatTypeString().toLowerCase()+"[ ] ";
					}
					
				} 
				
				else { // Seat is reserved
					if (seat.getIsFirstClass() == true){
						seatMapString += seat.getSeatType().getSeatTypeString()+"[X] ";
						
					}
					else{
						seatMapString += seat.getSeatType().getSeatTypeString().toLowerCase()+"[X] ";
					}
				}
			}
			
			seatMapString += "\n";
		}
		
		return seatMapString;
	}

	
	
	
	public Seat queryAvailableFirstClassSeat(SeatType seatType) {
		
		// finish this
		
		return null;
	}


	public Seat getSeat(int i, char c) {
		return getSeatArray()[i-1][c-65];
	}


	public Seat getRight(Seat seat) {
		
		for (int c = 0; c <= getMaxColumns()-65; c++){
			
			for (int r = 0; r < getMaxRows(); r++){
				
				seat = this.getSeatArray()[r][c];
				Seat seatr = seat;
				seatr.getSeatPosition().setRow(r+1);
				
				if ((seat.getIsReserved() == false) && (seatr.getIsReserved()  == false)){
					seat.setIsReserved(true);
					seatr.setIsReserved(true);
				}
				
			}
		}
		
		return null;
	}
	
	public Seat getLeft(Seat seat) {
		return null;
	}

}
