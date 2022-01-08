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
// The original string would not change
String str_replace = str_word.replace('e', 't');  // replacing all occurrences of old char in this string with new char
String str_replace = str_word.replaceAll('ell', 'mpp');  // replacing all occurrences of old string to new string 
String str_replace = str_word.replaceFirst('ell', 'mpp');

String result = s.replaceAll(oldChar, newChar); String result = s.replaceFirst(oldString, newString);
String[] result = s.split("StringChar");
String lower_str = str_word.toLowerCase();
String upper_str = str_word.toUpperCase();
String result = s.trim();   // trim the start and end part
boolean result = s.isEmpty();
char[] result = s.toCharArray();
String result = String.join('-', "This", "Is", "My");
s.getChars(beginingindex, endingindex, destchararray, destinationbegining);
String.join(", ", ["2", "3", "4"]);

String.join('-', "Happy", "Friday");  // join elements with delimeter "Happy-Friday"
String.join('-', new String[] {"Happy", "Friday"});

Character.toString('a');  // convert char to String
new String(new char[] {'a', 'm'});  // merge a char array to string

// find all the index of occurancy of the words
int index = s.indexOf(word);
while (index >= 0){
    result.add(index);
    index = s.indexOf(word, index + word.length())   ;
}



char[] char_word = new char[] { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd' };
String str_word = str_word.copyValueOf(char_word);  // str_word is hello world. copy the value of char array to a string
str_word = str_word.copyValueOf( char_word, 2, 6 );  // initial offset of the subarray is 2, the count is 6 result is llo wo
String output = "";
output = output.copyValueOf(input_char);


import java.util.stream.*;
String s = str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
String s = str.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining())
String s = Stream.of(str.split(" ")).sorted().collect(Collectors.joining());


// Check if a string is unique
char[] item_list = input.toCharArray();
for(char item : item_list) {
    String new_string = input.replaceFirst(Character.toString(item), "");
    if(new_string.contains(String.valueOf(item))) {
    return false;
    }
}
return true;

boolean[] words_list = new boolean[128];
for(char item : input.toCharArray()) {
    if(words_list[item]) {
    return false;
    }
    words_list[item] = true;
}
return true;

// Count the occurence of a char in string
long count = someString.chars().filter(ch -> ch == 'e').count();

