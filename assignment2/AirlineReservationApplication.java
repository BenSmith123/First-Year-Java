
import java.util.Scanner;

/**
 * The AirlineReservationApplication class is the main class where the user interacts with the program.
 * A static Scanner object called keyboardInput is initialised to get input from the user.
 * The class creates the Flights as static objects and then calls methods depending on the user input.
 * This class also stores the flights in an array of Flight[] type for the methods to iterate through.
 * A static currentFlight is also initialised for the class to store the current flight chosen.
 * 
 *  @author Ben Smith
 */

public class AirlineReservationApplication {
	
	static Scanner keyboardInput = new Scanner(System.in); // Create a static scanner object called keyboardInput for all methods to use
	
	// Creating each flight object with input parameters to set the object attributes
	static Flight flight1 = new Flight("BO085","Auckland, New Zealand", "New York, United States", "30/11/2015 at 08:00GMT", new BoeingSeatMap());
	static Flight flight2 = new Flight("PS004","Auckland, New Zealand", "Sydney, Australia", "13/05/2016 at 13:00GMT", new AirBusSeatMap());
	static Flight flight3 = new Flight("XB360","Auckland, New Zealand", "Nadi, Fiji", "08/01/2016 at 04:00GMT", new BoeingSeatMap());
	static Flight flight4 = new Flight("AZ123","Auckland, New Zealand", "Saskatoon, Canada", "21/12/2015 at 16:00GMT", new AirBusSeatMap());
	static Flight[] flights = {flight1, flight2, flight3,flight4};
	
	static Flight currentFlight;
	
	public static void main(String args[]){
		
		flight1.getSeatMap().getSeat(1, 'A').setIsReserved(true); // debug

		System.out.println("---------------------------------------------------");
		System.out.println("  Welcome to the Airline Reservation Application!  ");
		System.out.println("---------------------------------------------------");
		
		selectFlight();
		
	}
	
	/**The selectFlight() method is invoked by the main method.
	 * This method displays a menu by iterating through the flights[] array and printing
	 * the flights according to the Flight.toString() method.
	 * It then asks the user for an input which is then stored in an integer type variable.
	 * The currentFlight object is then set to the Flight object according to the 
	 * flights array [selection-1] to return the number chosen and also get the right
	 * flight object according to the array (which starts at 0).
	 */

	public static void selectFlight(){
		System.out.println("Which flight would you like to book?");
		
		for (int i = 0; i < flights.length; i++){ // iterate through the flights
			System.out.println(i+1 +") " + flights[i]); // print the flights array according the array index of i
		}
		
		int selection = keyboardInput.nextInt();
		
		currentFlight = flights[selection-1]; // set the current flight to the flight chosen by the input
		
		bookOrViewSeat();
	}
	
	/**The bookOrViewSeat method is invoked by the selectFlight() method.
	 * This method displays the current flight object with a menu asking 
	 * for a user input, which is then stored as an integer.
	 * Depending on the user input, this method calls the selectClass(), 
	 * resumeOrExit() or the selectFlight() method.
	 */
	
	public static void bookOrViewSeat(){
		
		System.out.println("Current flight number:\n" +currentFlight);
		
		System.out.println("1) Book a seat");
		System.out.println("2) View available seats");
		System.out.println("3) Choose a different flight");
		
		int selection = keyboardInput.nextInt();

		if (selection == 1){
			selectSeatType();
		}
		
		if (selection == 2){
			System.out.println(currentFlight.getSeatMapArray());
			resumeOrExit();
		}
		
		if (selection == 3){
			selectFlight();
		}

	}
	
	/**
	 * The selectClass() method is invoked by the bookOrViewSeat() method.
	 * This method first prompts the user asking if they would like to book a first class seat.
	 * The user input is then stored in a String type variable.
	 * 
	 * <p>
	 * This method then calls the selectSeatType() method.
	 */
	public static void selectClass(){
		
		System.out.println("Would you like to book a first class seat? (y/n)");
		
		String choice = keyboardInput.next();
		
		if (choice.equalsIgnoreCase("y")){
			
			//currentFlight.getAirline().reserveFirstClass(currentFlight, seatType);
			
			
		} 
		else {
			// select economy seat
		}
		
		showBooking();
	}
	
	/**
	 * The selectSeatType() method is invoked by bookOrViewSeat().
	 * This method prompts the user and displays a menu for the user
	 * to input which type of seat they want to book. 
	 *  
	 *  This method then calls the selectClass() method.
	 */
	
	public static void selectSeatType(){
		
		System.out.println("Which seat type would you like to book?");
		System.out.println("1) Aisle");
		System.out.println("2) Middle");
		System.out.println("3) Window");
		
		int selection = keyboardInput.nextInt();
		
		if (selection == 1){
			//currentFlight.getAirline().
		}
		
		if (selection == 2){
			// select middle seat
		}
		
		if (selection == 3){
			// select window seat
		}
		
		selectClass();
		
	}
	
	/**
	 *  The showBooking() method is invoked by the selectSeatType() method.
	 *  This method displays the currentFlight objects seatMap array and a 
	 *  detailed description of the seat that has been booked.<p>
	 *  
	 *  <p>
	 *  This method then calls the resumeOrExit() method.
	 */
	
	public static void showBooking(){
		
		System.out.println(currentFlight.getSeatMapArray());
		// show the seat booked (row: column) - toString()
		
		resumeOrExit();
	}
	
	/**
	 * The resumeOrExit() method invoked by either the showBooking() method or the bookOrViewSeat() method.
	 * This method prompts the user to book or view another flight.
	 * The user input is stored in a String type variable.
	 * This method then calls the selectFlight() variable again or prompts the user before terminating.
	 */
	
	public static void resumeOrExit(){
		
		System.out.println("Would you like to continue to book or view another flight? (y/n)");
		
		String choice = keyboardInput.next();
		
		if (choice.equalsIgnoreCase("y")){
			selectFlight();
		}
		else
		{
			System.out.println("Thank you for using the Airline Reservation Application!");
		}
		
	}
	
}
