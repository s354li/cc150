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

