
public class Customer {

	private String name;
	private int age;
	private boolean student;
	
	Customer(String name, int age, boolean student){
		this.name = name;
		this.age = age;
		this.student = student;
	}
		
	Customer(){
		this.name = "UNKNOWN";
		this.age = 0;
		this.student = false;
	}
	
	// setting the get methods for all attributes
	public int getAge(){
		return this.age;
	}
	
	public boolean getStudent(){
		return this.student;
	}

	public String getName(){
		return this.name;
	}
	
	// the set methods for all attributes
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	
	public void setStudent(boolean student){
		this.student = student;
	}
	

	public String toString(){
	 	 return "Name:" +this.name+" Age: "+this.age + " Is Student?: "+this.student;
	}
	
}
