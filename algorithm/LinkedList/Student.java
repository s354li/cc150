import java.util.*;
public class Student {
	private int studentID;
	private String studentName;
	private int studentAge;
	public Student(int id, String name, int age) {
		studentID = id;
		studentName = name;
		studentAge = age;
	}
	public int getID() {
		return studentID;
	}
	public String getName() {
		return studentName;
	}
	public int getAge() {
		return studentAge;
	}
	public String printStudent() {
		return studentID + ", " + studentName + ", " + studentAge;
	}
	
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof Student))
	        return false;
	    if (obj == this)
	        return true;
	    return this.getID() == ((Student) obj).getID() && this.getName() == ((Student) obj).getName() && this.getAge() == ((Student) obj).getAge();
	} 
}
