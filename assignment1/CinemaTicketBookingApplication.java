
import java.util.Scanner;

public class CinemaTicketBookingApplication {
	
	// Creating each film object and setting its input parameters (Title and rating)
	static Film film1 = new Film("Jurassic World", 'M');
    static Film film2 = new Film("Fantastic Four", 'P');
    static Film film3 = new Film("Ant-Man", 'P');
    static Film film4 = new Film("Inside Out", 'G');
    static Film[] filmsList = {film1, film2, film3, film4}; // Make an array for each film object
	private static final int NUMBER_OF_FILMS = filmsList.length; // Specifying the size of the array

	// MAIN //////////////////////////////////////////
    public static void main(String args[]){	
        
    	// While loop for everything in the main function for repeat or no repeat
        boolean printAnotherTicket = true; // set default to true for this to enter loop the first time
        while (printAnotherTicket == true){

	        Customer aCustomer = customerDetailsInput(); // Create a new customer and assign its attributes with the customer details method
	        
	        Film chosenFilm = filmSelection(); // Call the film selection method and get a film returned and stored the the variable chosenFilm
	        
	        while (chosenFilm == null){ // if no film was chosen, repeat the film selection method
	        	chosenFilm = filmSelection();
	        }
	        
	        Ticket aTicket = issueTicket(aCustomer, chosenFilm); // Call the issue ticket method with a customer object and the film of choice 
	        // this method returns null if age is not appropriate for the film chosen
	        if (aTicket == null){ // if null, output that the ticket cannot be issued
	        	System.out.println("Sorry, cannot issue ticket for age restricted films");
	        }
	        else{
	        	System.out.println(aTicket.toString()); // Print the ticket details
	        }
	       
	        System.out.println("Issue another ticket? (Y/N)");
	        keyboard.nextLine();
	        String response = keyboard.nextLine();
	        
	        if (response.equalsIgnoreCase("n")){ // equalsignorecase for capital and  non-capitol
	        	printAnotherTicket = false; // end the loop
	        }
        
        } // End of while loop (if you do not want to issue another ticket)
        
    }
    

    static Scanner keyboard = new Scanner(System.in); // create the keyboard

    private static Customer customerDetailsInput(){
    	
    	// input for keyboard variables
    	String name;
    	int age;
    	boolean isStudent = false;
    	
    	System.out.println("Please enter your name: ");
    	name = keyboard.next();
		
		System.out.println("Please enter your age: ");
		age = keyboard.nextInt();
		
		System.out.println("Are you a student? (Y/N): ");
		char studentChar = keyboard.next().charAt(0); // CharAt(0) gets the first literal of the string
		
		// Change the Char variable to match the Boolean variable isStudent
		if (studentChar == 'Y' || studentChar == 'y'){
			isStudent = true;
		}
		else if (studentChar == 'N' || studentChar == 'n'){
			isStudent = false;
		}

		return new Customer(name, age, isStudent); // return a new customer object with the details input
    }

     	// FILM SELECTION METHOD
    	private static Film filmSelection(){ 
    		
    	System.out.println("Which film would you like to watch?");
    	
    	// Print the list of films
    	for (int i = 0; i < NUMBER_OF_FILMS; i++)
    	{
    		System.out.println(i+1 +") "+filmsList[i]); // Add one because the array starts at 0
    	}
				
    	return filmsList[keyboard.nextInt()-1]; // take one away because we added one
    	
    }

 // ISSUE TICKET METHOD
   public static Ticket issueTicket(Customer aCustomer, Film aFilm){
    	 
    	int minimumAge = 18; // set the default minimum age to 18
    	
    	if (aFilm.getRating() == 'G'){
    		minimumAge = RATING.GENERAL.getMinimumage();
    	}
    	
    	else if (aFilm.getRating() == 'P'){
    		minimumAge = RATING.PARENTAL.getMinimumage();
    	}
    
    	if (aFilm.getRating() == 'M'){
    		minimumAge = RATING.MATURE.getMinimumage();
    	}

    	if (minimumAge <= aCustomer.getAge()){
    		return new Ticket(aCustomer, aFilm);
    	}
    	
    	return null;
		
    }
    
} 
