package stringarrays;

/**
 * PROBLEM Write two conversion routines. The first routine converts a string to
 * a signed integer. You may assume that the string contains only digits and the
 * minus character ( '-' ), that it is a properly formatted integer number, and
 * that the number is within the range of an int type. The second routine
 * converts a signed integer stored as an int back to a string.
 *
 */
public class Conversions {

	public static void main(String[] args) {
		Conversions conv = new Conversions();
		int stringToInt = conv.stringToInt("-327");
		System.out.println(stringToInt);
		
		String intToStr = conv.intToStr(327);
		System.out.println(intToStr);
	}

	public static final int MAX_DIGITS = 10;

	public String intToStr(int num) {
		int i = 0;
		boolean isNeg = false;
		/* Buffer big enough for largest int and - sign */
		char[] temp = new char[MAX_DIGITS + 1];
		/* Check to see if the number is negative */
		if (num < 0) {
			num = -num;
			isNeg = true;
		}
		/* Fill buffer with digit characters in reverse order */
		do {
			temp[i++] = (char) ((num % 10) + '0');
			num /= 10;
		} while (num != 0);
		StringBuilder b = new StringBuilder();
		if (isNeg)
			b.append('-');
		while (i > 0) {
			b.append(temp[--i]);
		}
		return b.toString();
	}

	private int stringToInt(String s1) {

		boolean isNeg = false;
		int result = 0;
		int index = 0;

		if (s1.charAt(0) == '-') {
			isNeg = true;
			index = 1;
		}

		while (index < s1.length()) {
			result *= 10;
			result += (s1.charAt(index++) - '0');
		}
		if (isNeg) {
			result = -result;
		}
		return result;
	}

}
