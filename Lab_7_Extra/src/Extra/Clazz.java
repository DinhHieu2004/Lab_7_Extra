package Extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Clazz {
	private String name;
	private String year;// 2017, 2018, 2019, ...
	private ArrayList<Student> students = new ArrayList<Student>();

	public Clazz(String name, String year) {
		this.name = name;
		this.year = year;
	}
	// load all students from filename into the list of
	// students.

	public void loadStudents(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, "\t");
			String id = tokens.nextToken().trim();
			String firstName = tokens.nextToken().trim();
			String lastName = tokens.nextToken().trim();
			int birthYear = Integer.parseInt(tokens.nextToken().trim());
			double GPA = Double.parseDouble(tokens.nextToken().trim());
			students.add(new Student(id, firstName, lastName, birthYear, GPA));
		}
		reader.close();
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		students.sort(c);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
		ArrayList<Student> result = new ArrayList<>();
		Collections.sort(students, (s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));

		for (int i = 0; i < Math.min(n, students.size()); i++) {
			result.add(students.get(i));
		}
		return result;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {

		Random random = new Random();

		ArrayList<Student> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int  r  = random.nextInt(students.size());
			Student s = students.get(r);
			if(!result.contains(s)) {
				result.add(s);
			}else {
				i=i-1;
			}

		}

		display();
		return result;
	}

// remove a student with a given id
	public boolean removeStudent(String id) {

		for (int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			if (s.getId().equals(id)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {

		ArrayList<Student> result = new ArrayList<>();

		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getBirthYear() == birthYear) {
				result.add(students.get(i));
			}
		}
		return result;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		java.util.Iterator<Student> studentIterator = students.iterator();
	    while (studentIterator.hasNext()) {
	        Student student = studentIterator.next();
	        System.out.println("ID: "+ student.getId()+" Name: " + student.getLastName() 
	        + ", birth Year: " + student.getBirthYear()
	        +", GPA"+ student.getGPA());
	    }

	}
}
