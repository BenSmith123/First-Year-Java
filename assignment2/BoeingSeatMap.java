
/**
 * The BoeingSeatMap class is a concrete class that extends the abstract SeatMap class.
 * This class has final variables that set the size of a SeatMap (size of a BoeingSeatMap).
 * <p>
 * The class initialises a Seat[][] object (seatMap) as an array.
 * @author Ben Smith
 */

public class BoeingSeatMap extends SeatMap{
	
	private final int rows = 10;
	private final char columns = 'G';
	private final int firstClassRows = 4;

	Seat[][] seatMap = new Seat[getMaxRows()][getMaxColumns()];
	
	public BoeingSeatMap(){
		setMaxRows(rows);
		setMaxColumns(columns);
		setFirstClassRows(firstClassRows);
		initialiseSeatMap();
	}
	
	public void initialiseSeatMap() {	
		this.polulateSeatsArray(rows,columns);
		this.setAllSeatPostion(this);
		this.setAllSeatType(this);
	}
	/**
	 * The method setAllSeatPostion() takes BoeingSeatMap object and iterates
	 * through the 2D array and assigns a new Seat object according to the array iteration.
	 *  
	 * @param boeingSeatMap - Takes a BoeingSeatMap object to set boundaries for setting each seat
	 */

	public void setAllSeatPostion(BoeingSeatMap boeingSeatMap) {
		
		for (int r = 0; r < this.getMaxRows(); r++){
			
			for (char c = 'A'; c <= getMaxColumns(); c++){
				
				Seat currentSeat = this.getSeatArray()[r][c-65]; // -65 returns the character value 'A' to int 0
				currentSeat.setSeatPosition(r+1,c); // sets the seats position according to the array
			}
		}
	}

	/**
	 * setIsFirstClass() 
	 * @param seatMap
	 */
	
	public void setIsFirstClass(SeatMap seatMap){
		for (Seat[] row : seatMap.getSeatArray()){
			for (Seat seat : row){
			
				if (seat.getSeatPosition().getRow() <= seatMap.getMaxRowsFirstClass()){
					seat.setIsFirstClass(true);
				}
				else
				{
					seat.setIsFirstClass(false);
				}
			}
		}
	}
	
	/**
	 *  The method setAllSeatType() is the <p>
	 *  @param seatMap takes a SeatMap object  
	 */
	
	public void setAllSeatType(SeatMap seatMap) {
		for (Seat[] row : seatMap.getSeatArray()){
			for (Seat seat : row){
				
				if (seat.getSeatPosition().getColumn() == 'A' || seat.getSeatPosition().getColumn() == columns){
					seat.setSeatType(SeatType.WINDOW);
				}
				else if (seat.getSeatPosition().getColumn() == 'D'){
					seat.setSeatType(SeatType.MIDDLE);
				}
				else{
					seat.setSeatType(SeatType.AISLE);
				}		
			}
		}		
	}
	
}
