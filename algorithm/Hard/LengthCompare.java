import java.util.*;
public class LengthCompare implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s2.length() - s1.length();
	}
}