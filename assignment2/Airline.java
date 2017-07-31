
public abstract class Airline {
	
	private String Name;

	// Getter and setter for AirlineName
	public String getAirlineName() {
		return Name;
	}

	public void setAirlineName(String airlineName) {
		Name = airlineName;
	}

	public abstract Seat reserveFirstClass(Flight flight, SeatType seatType);
	
	//public abstract Seat reserveEconomy(Flight, SeatType);
	
}


