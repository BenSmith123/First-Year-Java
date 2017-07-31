
public class Ticket {
	
	
	Customer aCustomer = new Customer();
	Film aFilm = new Film();
	private double cost = 10; // set the default cost to 10
	
	public Ticket(Customer customer, Film film) {
        this.aFilm = film;
        this.aCustomer = customer;
        this.cost = cost();
    }
	
	public double cost(){
		
		if (aCustomer.getAge() >= 18){ // ticket for adults
			this.cost = 10;
		}
		
		else if (aCustomer.getAge() < 18){ //  ticket for children
			this.cost = 7;
		}
		
		if (aCustomer.getAge() > 10 && aCustomer.getAge() < 25 && aCustomer.getStudent() == true){ //  ticket for children
			this.cost = cost * 0.85; // 15% discount
		}
		
		else if (aCustomer.getAge() > 25 && aCustomer.getStudent() == true){ //  ticket for seniors
			this.cost =  cost * 0.90; // 10% discount
		}
			
		else if (aCustomer.getAge() > 64){ //  ticket for seniors
			this.cost =  cost*0.93; // 7% discount
		}	
		
		
		return this.cost;
	}
	
	public String toString(){
	 	 return 
	 	 "-------------------------------------------------------"+ 
	 	 "\n FILM TICKET for: "+aFilm.getTitle() + " (" + aFilm.getRating()+ ")" +
	 	 "\n CUSTOMER DETAILS: " +aCustomer.getName()+ " age: "+aCustomer.getAge() + " Student?: "+aCustomer.getStudent() +
	 	 "\n TOTAL COST: $" +String.format("%.2f",cost())+
	 	 "\n-------------------------------------------------------";
	}

}
