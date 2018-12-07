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
