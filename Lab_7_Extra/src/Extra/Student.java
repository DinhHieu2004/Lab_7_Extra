package Extra;



public class Student  {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Student(String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthYear=" + birthYear
				+ ", GPA=" + GPA + "]";
	}

	public String getId() {
		return id;
	}

	public double getGPA() {
		return GPA;
	}
	public int getBirthYear() {
		return this.birthYear;
	}
	

	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public static int compare(Student str1, Student str2) {
		
		return str1.getId().compareTo(str2.getId());
	}



	

	
	
}
