// 12. Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// 13. convert Roman numerals to int
import java.util.*;
public class IntToRoman {
	public static String convertRoman(int iniInt) {
		String result = "";
		while (iniInt / 1000 > 0) {
			result += "M";
			iniInt -= 1000;
		}
		if (iniInt / 100 == 9) {
			result += "CM";
			iniInt -= 900;
		} else if (iniInt / 100 == 4) {
			result += "CD";
			iniInt -= 400;
		} else {
			while (iniInt / 500 > 0) {
				result += "D";
				iniInt -= 500;
			}
			while (iniInt / 100 > 0) {
				result += "C";
				iniInt -= 100;
			}
		}
		if (iniInt / 10 == 9) {
			result += "XC";
			iniInt -= 90;
		} else if (iniInt / 10 == 4) {
			result += "XL";
			iniInt -= 40;
		} else {
			while (iniInt / 50 > 0) {
				result += "L";
				iniInt -= 50;
			}
			while (iniInt / 10 > 0) {
				result += "X";
				iniInt -= 10;
			}
		}
		if (iniInt / 1 == 9) {
			result += "IX";
			iniInt -= 9;
		} else if (iniInt / 1 == 4) {
			result += "IV";
			iniInt -= 4;
		} else {
			while (iniInt / 5 > 0) {
				result += "V";
				iniInt -= 5;
			}
			while (iniInt / 1 > 0) {
				result += "I";
				iniInt -= 1;
			}
		}
		return result;
	}
	public static String convertRomanSecond(int iniInt) {
		int[] arabics = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String result = "";
        
        for (int i = 0; i < arabics.length; i++) {
            while (iniInt - arabics[i] >= 0) {
                result += romans[i];
                iniInt = iniInt - arabics[i];
            }            
        }
                
        return result;
	}
	public static int convertInt(String iniString) {
		int result = 0;
		int[] arabics = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 1; i < romans.length; i += 2) {
        	while (iniString.contains(romans[i])) {
        		result += arabics[i];
        		iniString = iniString.replaceFirst(romans[i], "");
        	}
        }
        for (int i = 0; i < romans.length; i += 2) {
        	while (iniString.contains(romans[i])) {
        		result += arabics[i];
        		iniString = iniString.replaceFirst(romans[i], "");
        	}
        }
        return result;
	}
	public static int convertIntSecond(String iniString) {
		if (iniString == null || iniString.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = romanValues.get(iniString.charAt(iniString.length() - 1));

        for (int i = iniString.length() - 2; i >= 0; i--) {
        	if (romanValues.get(iniString.charAt(i)) < romanValues.get(iniString.charAt(i + 1))) {
        		result -= romanValues.get(iniString.charAt(i));
        	} else {
        		result += romanValues.get(iniString.charAt(i));
        	}
        }
        return result;
	}
	public static void main(String[] args) {
		System.out.println(convertRomanSecond(1994));
		System.out.println(convertInt("MCMXCIV"));
		System.out.println(convertIntSecond("MCMXCIV"));
	}
}