import java.lang.Math;
int x = 10000;
Math.squr(x);
Math.pow(x, y);  // power x by y times
Math.sin(x);
Math.cos(x);
Math.tan(x);
Math.asin(x);
Math.acos(x);
Math.atan(x);
Math.exp(x);   // power e by x times
Math.log(x);   // lnx
Math.log10(x);  //logx
Math.round(x);   // the closest integer of x (double)
Math.abs(x);   // |x|
Math.max(x, y);
Math.min(x, y);
Math.PI;  Math.E;
(int)(Math.random() * ((max - min) + 1)) + min;  // generate random number within a range
5 * (Round5() - 1) + Round5();   // Maximum the range of the random number A^2
Randab = b * (Randa - 1) + Randb;
Randab = a * (Randb - 1) + Randa;   // Maximum the range of the random number to a*b
(c >> 31) & 0x1;   // check positive is 0 negative is 1


// Date class for JAVA
Date now = new Date();
Date specificDate = new Date(2018, 11, 1, 10, 10, 45);   // year, month, day, hour, min, sec
boolean checkafter = specificDate.after(new Date());
boolean checkbefore = specificDate.before(new Date());
int compareDate = specificDate.compareTo(new Date());  // 0 is equal negative is specificDate is before argument otherwise after argument
int milisecond = specificDate.getTime();
specificDate.setTime(204587433443L);   //data type is long for the argument

// Calendar class for JAVA
Calendar current = (Calendar) Calendar.getInstance();
current.add((Calendar.YEAH), 9);   // the number can be negative like rolling back
current.set(2018, 11, 1, 10, 10, 45);
current.setTime(new Date());
current.roll((Calendar.YEAR), false);  // roll back the year field by one unit

// bitwise operator
// | or means meet 1 is 1 in every bit
// & and means all 1s are 1 in every bit
// ^ XOR means the same is 0 otherwise 1
// ~ bitwise opposite
// << left shift the number and use 0 to make up the bit
// >> right shift the number and use 0 to make up the bit >>> unsigned right shift


