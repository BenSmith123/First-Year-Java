
public class Seat {
	
	SeatPosition seatPosition = new SeatPosition(); // create a new seat position object
	
	private SeatType seatType;
	private boolean isReserved = false;
	private boolean isFirstClass = false;
	
	public void setSeatPosition(int row, char column){
		seatPosition.setRow(row);
		seatPosition.setColumn(column);
	}

	public SeatPosition getSeatPosition(){
		return this.seatPosition;
	}
	
	public boolean getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public boolean getIsFirstClass() {
		return isFirstClass;
	}

	public void setIsFirstClass(boolean isFirstClass) {
		this.isFirstClass = isFirstClass;
	}

	public SeatType getSeatType(){
		return this.seatType;
	}
	
	public void setSeatType(SeatType seatType){
		this.seatType = seatType;
	}
	
	public String getSeatInfo(){
		
		if (this.getIsReserved() == false){
			return getIsFirstClass() +" class "+getSeatType() +" seat at: " +seatPosition.getRow() +seatPosition.getColumn() +" is not reserved.";
		}
		else{
			return getIsFirstClass() +" class "+getSeatType() +" seat at: " +seatPosition.getRow() +seatPosition.getColumn() +" is reserved.";
		}

	}
	
	public String toString(){
		
		return seatPosition.getRow()+":" + seatPosition.getColumn();
	}
	
	
}
