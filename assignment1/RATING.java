
public enum RATING {
	
	 GENERAL(0), PARENTAL(12), MATURE(16);
	 private int minimumage;
	 
	 // Set method for RATING minimum age
	 private RATING(int minimumage){
		 this.minimumage = minimumage;
	}
	 
	 // Get method for minimum age
	public int getMinimumage() {
		return minimumage;
	}

}
