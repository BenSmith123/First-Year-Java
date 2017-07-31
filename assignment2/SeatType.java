/**
 * The SeatType is an Enum used to set the seat type of a Seat object.
 * Each value in the Enum has a String value equivalent.
 * 
 * @author Ben Smith
 */

public enum SeatType {
	AISLE("A"), MIDDLE("M"), WINDOW("W");
	
	private String typeString;
	
	SeatType(String type){
		this.typeString = type;
	}
	
	public String getSeatTypeString(){
		return this.typeString;
	}
	
}
