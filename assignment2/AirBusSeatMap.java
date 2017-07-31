
public class AirBusSeatMap extends SeatMap {
	
	// getters and setters?
	private final int rows = 12;
	private final char columns = 'I';
	private final int firstClassRows = 6;

	Seat[][] seatMap = new Seat[getMaxRows()][getMaxColumns()];
	
	public AirBusSeatMap(){
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
	
	public void setAllSeatPostion(AirBusSeatMap airBusSeatMap) {
		
		for (int r = 0; r < this.getMaxRows(); r++){
			
			for (char c = 'A'; c <= getMaxColumns(); c++){
				
				Seat currentSeat = this.getSeatArray()[r][c-65];
				currentSeat.setSeatPosition(r+1,c);
			}
		}
	}

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

