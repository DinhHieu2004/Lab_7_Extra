package Extra;

import java.io.IOException;
import java.util.Comparator;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws IOException {

//		ArrayList<Student> list = StudentUtils.loadStudents("Students.txt");

		Clazz c = new Clazz("DH22DTA", "2022");

		c.loadStudents("Students.txt");
 
		System.out.println("-------list original-------");
		c.display();
		
		System.out.println("--------List is sorted------");
		Comparator<Student> value = (s1, s2) -> Student.compare(s1, s2);

		c.sortStudents(value);

		for (Student s : c.getStudents()) {
			System.out.println(s);
		}

		System.out.println("--------List n top------");
		c.getTopNStudents(3);
		for (Student s : c.getTopNStudents(3)) {
			System.out.println(s);
		}

		c.getTopNStudents(3);

		System.out.println("--------List get by birth year------");
		for (Student s : c.getStudentByBirthYear(1998)) {
			System.out.println(s);
		}
		c.removeStudent("18130006");
		System.out.println("-----List after remove");
	
		c.display();
		
		
    	System.out.println("------Student get by random------");
		for (Student s : c.getRandomNStudents(5)) {
			System.out.println(s);
		}
    	
	}

}
