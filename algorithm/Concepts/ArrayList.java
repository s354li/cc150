// Time Comp: add/get O(1) removeO(n)
ArrayList<Integer> arrli = new ArrayList<Integer>(5);
ArrayList<Integer> arrlist = new ArrayList<Integer>();
arrlist.size();  // return the size of the array list
arrlist.add(3);  // add element into the arraylist
arrlist.add(1, 2);  // add element into the arraylist at a specific index; add 2 in the position 1
arrlist.set(1, 8);  // change element at position 1 to 8
arrlist.get(1);  // get the element at position 1
arrlist.indexOf(8);  // get the first position for element 8
arrlist.lastIndexOf(8);  // get the last position for element 8
arrlist.remove(8);  // remove element 8
arrlist.remove(1);  // remove the element at position 1
arrlist.removeIf( n -> ( n % 3 == 0 ) );
arrlist.removeRange(0, 2);  // remove elements from index 0 to index 2
arrlist.clear();  // clear all the elements
arrlist.clone();  // clone an arraylist
arrlist.contains(8);  // return boolean check whether arraylist contains element
arrlist.isEmpty();  // check whether arraylist is empty
arrlist.sort();  // sort the arraylist
arrlist.isEmpty();

arrlist.retainAll(arrli);  // return an array list which is the intersection of two array lists
List<String> arrlist2 = arrlist.subList(2, 4);  // return the sublist of an array list between the two index
int[] arr = arrlist.toArray();  // convert arraylist to array

Collections.sort(arrlist);  // Sort an array list



// loop through all the elements in the array list
arrlist.forEach((n) -> { System.out.println(n); });

for(int n : arrlist) {
	System.out.println(n);
}

for(int i = 0; i < arrlist.size(); i++) {
	System.out.println(arrlist.get(i));
}

ListIterator<String> iterator = arrlist.listIterator(); 
ListIterator<String> iterator2 = arrlist.listIterator(2);  // iterate from the position 2
while (iterator.hasNext()) { 
    System.out.println("Value is : " + iterator.next()); 
} 

arrlist.toString();  // convert arraylist to string print [1,2,3,4,5]


// Clone a list
List<String> cloned_list = new ArrayList<String>();
  
// Cloning a list
cloned_list.addAll(original);
