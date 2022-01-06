int[] arr = new int[] { 1, 2, 3, 4, 5, 6 }
arr.length;
arr.clone();

Arrays.asList(arr); // convert an array to list
new ArrayList<>(Arrays.asList(arr)); // convert an array to arraylist
Arrays.binarySearch(arr, 4);  // binary search array to find element
Arrays.binarySearch(arr, 1, 3, 4);  // binary search array to find element from index 1 to index 3
Arrays.compare(arr, arr1);  // compare two arrays by value; 1 no equal 0 equal
Arrays.toString(Arrays.copyOf(arr, 10));  // copy of array and take the size of 10, use 0 to fill the rest of the position
Arrays.toString(Arrays.copyOfRange(arr, 1, 3));  // copy the range of array two elements in the result index 1 and index 2
Arrays.equals(arr, arr1);  // value equals to each other
Arrays.deepEquals(arr, arr1);  // deep equal for multidimension arrs
Arrays.deepToString(arr);  // convert array to string
Arrays.fill(arr, 8);  // fill the array by the value
Arrays.sort(arr);  // sorting the array in ascending order
Arrays.sort(arr, 1, 3);  // sort a special range of array
Arrays.copyOf(arr, 3);  // copy 3 items from arr to a new array
Arrays.copyOfRange(arr, 3, 7);   // copy arr from position 3 to position 7


Arrays.sort(al, new Comparator class);

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

System.arraycopy(array1, 0, result, 0, aLen);
/*
The arraycopy(array1, 0, result, 0, aLen) function, in simple terms, tells the program to copy array1 starting from index 0 to result from index 0 to aLen.
*/

Arrays.toString(a);  // print the array in [] format

/*char array is different */
char[] chars = s.toCharArray();

//      List<Character> list = Arrays.asList(chars); // this does not compile,
List<char[]> asList = Arrays.asList(chars); // because this DOES compile.

List<Character> listC = new ArrayList<Character>();
for (char c : chars) {
    listC.add(c);
}

myString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

// Convert int array to string array
String[] strArray = Arrays.stream(intArray).mapToObj(String::valueOf).toArray(String[]::new);
