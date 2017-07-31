
public class Film {
	
	private String title;
	private char rating;
	
	// newFilm constructor
	public Film(String title, char rating) {
        this.title = title;
        this.rating = rating;
    }
	
	// Default constructor
	public Film(){
		this.title = "UNKNOWN";
		this.rating = '-';
	}
	
	// Get methods
	public String getTitle(){
		return this.title;
	}
	
	public char getRating(){
		return this.rating;
	}
	
	// String format
	public String toString(){
	 	 return this.title+" rating: ("+this.rating +")";
	}
}
