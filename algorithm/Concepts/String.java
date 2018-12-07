// String method
String s = "Grace";
char result = s.charAt(0);
int result = s.contains("Gr");
int result = s.compareTo("Grace"); int result = s.compareToIgnoreCase("Grace");  // return 0 if equals, return position if s is greater return negative if "Grace" is greater
boolean result = s.equals("Grace"); boolean result = s.equalsIgnoreCase("Grace");
String result = s.concat(" is ");
String result = s.substring(int beginning, int endingindex);
String result = s.substring(int beginning);   // substring until the end
String result = String.valueOf(1);   // convert all the other type into String
boolean result = s.startsWith("Gr");
boolean result = s.endsWith("ce");
String result = String.format("My String is %s", s);
int result = s.indexOf(char/String);
int result = s.length();
String result = s.replaceAll(oldChar, newChar); String result = s.replaceFirst(oldString, newString);
String[] result = s.split("StringChar");
String result = s.trim();   // trim the start and end part
boolean result = s.isEmpty();
char[] result = s.toCharArray();
String result = String.join('-', "This", "Is", "My");
s.getChars(beginingindex, endingindex, destchararray, destinationbegining);
String.join(", ", ["2", "3", "4"]);


Arrays.binarySearch(al, 34);
Arrays.equals(al1, al2);
Arrays.fill(al, 23);   // assign the value to all the elements in the array
Arrays.sort(al, new Comparator class);
Arrays.copyOfRange(arr, 0, 2); 

int[] result = new int[] { 1, 1, 1 };
int[][] result = new int[][] {
	{ 1, 1, 1 },
	{ 1 }
};

class Sortbyroll implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return a.rollno - b.rollno; 
    } 
}

class Student implements Comparable<Student>{  
	int rollno;  
	String name;  
	int age;  
	Student(int rollno,String name,int age){  
		this.rollno=rollno;  
		this.name=name;  
		this.age=age;  
	}  
	  
	public int compareTo(Student st){  
		if(age==st.age)  
		return 0;  
		else if(age>st.age)  
		return 1;  
		else  
		return -1;  
	}  
} 

// ascending order: return 1 if this is greater; -1 if other is greater
Arrays.sort([12, 15, 23], Collections.reverseOrder());
Arrays.sort(al, new Sortbyroll());
Collections.sort(ArrayList, LinkedList, etc)




