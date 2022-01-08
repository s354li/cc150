// LinkedList concept: Zero based index; ArrayList is similiar with LinkedList
// Time Comp: https://www.bigocheatsheet.com/
// add/remove O(1) search O(n)
LinkedList<String> iniLinkedList = new LinkedList<String>();
iniLinkedList.add("Grace");
iniLinkedList.add(2, "Grace");
ArrayList<String> iniArrayList = new ArrayList<String>();
iniArrayList.add("Mom");
iniLinkedList.addAll(iniArrayList);
iniLinkedList.addFirst("Grace");
iniLinkedList.addLast("Grace");
iniLinkedList.clear();
iniLinkedList.contains("Grace");
String result = (String) iniLinkedList.get(2);
String result = (String) iniLinkedList.getFirst();
String result = (String) iniLinkedList.getLast();
iniLinkedList.indexOf("Grace");
iniLinkedList.lastIndexOf("Grace");
String result = (String) iniLinkedList.pollFirst();  // retrieve and remove the first element return null if empty
String result = iniLinkedList.pop();   // retrieve and remove the first element
String result = (String) iniLinkedList.peekFirst();  // retrieve but not remove the head of the list return null if empty
String result = (String) iniLinkedList.peekLast();  // retrieve but not remove the end of the list return null if empty
String result = (String) iniLinkedList.pollLast();   // retrieve and remove the last element return null if empty
iniLinkedList.offerFirst("Grace");  // add new element at the front of the list  
iniLinkedList.push("Grace");   // add new element at the begining of the list
iniLinkedList.remove(2);
iniLinkedList.remove("Grace");
iniLinkedList.size();
iniLinkedList.set(2, "Grace");
iniLinkedList.iterator();
List<String> result = iniLinkedList.subList(2, 5);
LinkedList<String> result = (LinkedList) iniLinkedList.clone();
String[] result = iniLinkedList.toArray(new String[iniLinkedList.size()]);


List<Integer> list = new ArrayList<Integer>();
list.add(12);
list.remove(2);
list.get(2);
list.set(2, 25);
ListIterator<String> itr=al.listIterator();

Arrays.sort();
public static int binarySearch(Object[] a, int fromIndex, int toIndex, Object key);
// This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1).
// The insertion point is the point at which the key would be inserted into the array;
// the index of the first element in the range greater than the key, or toIndex if all elements in the range are less than the specified key.

