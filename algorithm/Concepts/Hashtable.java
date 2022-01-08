// HashMap: a pair of key and value. No duplicate keys. similar with hash table but unsync and allow null key. no order
HashMap<Integer, String> lib = new HashMap<Integer, String>();
lib.put(1, "Lucy");  // add element into the hashmap change the element with key 1 to be Lucy
// Time comp : add/remove/get/contains O(1)
lib.remove(1);  // remove pair which key is 1

lib.size();
lib.containsKey(1);  // if this hashmap contains a specified key.
lib.containsValue("Lucy");  // if this hashmap contains a specified value.
lib.get(1);  // get the value of a specific key in the hashmap

lib.isEmpty();  // if the hashmap is empty

lib.clear();  // clear the content of hashmap
lib.clone();

lib.compute(1, (key, value) -> "Student Name: " + value);  // change the value of the hashmap with key 1 {1: "Student Name: Lucy"}
lib.computeIfAbsent(2, k -> "Student Name: Lily");  // calculatae the value of a key if the key is not associated with a value
lib.computeIfPresent(1, (key, val) -> "Student Name: " + value);  // compute value of a specified key if key is already associated with a value


// loop through hashmap
for(Map.Entry<String, Integer> e : lib.entrySet()) {
	System.out.println("Key: " + e.getKey() + " Value: " + e.getValue()); 
}

Set<Integer> key_set = lib.keySet();
for(int i : key_set) {
	System.out.println(i);
	System.out.println(lib.get(i));
}

for(String i : lib.values()) {
	System.out.println(i);
}

Set set = lib.entrySet();
Iterator iterator = set.iterator();
while(iterator.hasNext()) {
	Map.Entry en = (Map.Entry)iterator.next();
    System.out.print("key is: "+ en.getKey() + " & Value is: ");
    System.out.println(en.getValue());
}
for (Map.Entry me : hmap.entrySet()) {
	System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
}


// Hashtable concept
Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
Hashtable<Integer, String> hash1 = new Hashtable<Integer, String>(10);
hash.put(1, "Grace");
hash.clear();
Hashtable<Integer, String> cloned = (Hashtable<Integer, String>) hash.clone();   // create a copy of the hashtable
boolean result = hash.containsKey(2);
boolean result = hash.contains("Grace");   boolean result = hash.containsValue("Grace");
boolean result = hash.equals(hash1);
String result = (String) hash.get(2);   // get the element of the key
boolean result = hash.isEmpty();
String result = (String) hash.remove(2);   // remove the element in the table and return the removed one or null
int result = hash.size();
Enumeration keys = hash.keys();   Set keys = hash.keySet();
while (e.hasMoreElements()) { 
   System.out.println(e.nextElement());
} 
Collection values = hash.values();   Enumeration e = hash.elements();  // return enumeration of the elements in the hash table use while(e.hasMoreElements()) iteration



HashSet<String> set = new HashSet<String>();
set.add("Grace");
set.clear();
boolean result = set.contains("Grace");
boolean result = set.isEmpty();
result.remove("Grace");
int result = set.size();
Iterator<String> itr = set.iterator();
for(String item:set)  // loop through set

// Time Comp: Add/remove/contains O(1)
