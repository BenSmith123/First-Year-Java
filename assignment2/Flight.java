/**
 * The Flight class stores class variables to be used by each Flight object.
 * This class has a default constructor and an additional constructor that
 * constructs a Flight objects according to the class variables.
 * The flight class also has a toString() method that prints out the flight data accordingly. 
 * 
 * @author Ben Smith
 */

public class Flight {
	
	private String flightNumber;
	
	private String startLocation;
	private String endDestination;
	private String departureTime;
	private SeatMap seatMap;
	private Airline airline;
	
/**
 * The Flight constructor takes the parameters of each Flight class variable and constructs a Flight object accordingly.
 * 
 * @param flightNumber - stores the flight number as a String because there is no need to use. 
 * the numbers in mathematical operation and the flight number also contains two letters.
 * @param startDestination - stores the start destination of a Flight object as a String (City name, Country Name).
 * @param endDestination - stores the end destination of a Flight object as a String (City name, Country Name).
 * @param departureTime- stores the Flight object departure time as a String (DD/MM/YYYY at HH:MMGMT).
 * @param seatMap - stores a SeatMap object which is then intialised by the initialseSeatMap() method.
 */
	// Constructor for Flight
	public Flight(String flightNumber, String startDestination, String endDestination, String departureTime, SeatMap seatMap) {
		
		this.flightNumber = flightNumber;
		this.startLocation = startDestination;
		this.endDestination = endDestination;
		this.departureTime = departureTime;
		this.seatMap = seatMap;
		this.seatMap.initialiseSeatMap();
	}
	
	// Default constructor for Flight
	public Flight(){
		this.startLocation = "No Start Destination";
		this.endDestination = "No End Destination";
		this.departureTime = "00/00/00 at 00:00GMT";
		this.flightNumber = "00000";
	}
	
	// Getters and Setters
	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndDestination() {
		return endDestination;
	}

	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public SeatMap getSeatMapArray() {
		return this.seatMap;
	}
	
	/**
	 * The bookSeat method takes a Seat object and calls the set method 
	 * .setIsReserved() with a boolean input parameter and sets it to true.
	 * 
	 * @param seat - accepts a Seat object and changes the seats.isReserved to true.
	 */
	public void bookSeat(Seat seat) {
		seat.setIsReserved(true);
	}
	
	public String toString(){
		return getFlightNumber() + " - from " +getStartLocation() +" to " +getEndDestination() + " departing on "+getDepartureTime();
	}

	public SeatMap getSeatMap() {
		return this.seatMap;
	}

	public Airline getAirline() {
		return this.airline;
		
	}

}
