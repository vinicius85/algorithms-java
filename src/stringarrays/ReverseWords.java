package stringarrays;

/**
 * PROBLEM Write a function that reverses the order of the words in a string.
 * For example, your function should transform the string "Do or do not, there
 * is no try." to "try. no is there not, do or Do". Assume that all words are
 * space delimited and treat punctuation the same as letters.
 *
 */
public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords words = new ReverseWords();
		String phrase = "Do or do not, there is no try.";
		System.out.println(words.reverse(phrase));
		System.out.println(words.reverseWords(phrase.toCharArray()));
	}

	private String reverse(String s1) {
		String[] tokens = s1.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int size = tokens.length - 1; size >= 0; size--) {
			builder.append(tokens[size]).append(" ");
		}
		return builder.toString().trim();
	}

	private void reverseString(char[] s1, int start, int end) {
		char temp;
		while (end > start) {
			temp = s1[start];
			s1[start] = s1[end];
			s1[end] = temp;
			start++;
			end--;
		}
	}

	private String reverseWords(char[] s1) {
		int start = 0, end = 0;
		int length = s1.length;

		reverseString(s1, start, length - 1);

		while (end < length) {
			if (s1[end] != ' ') {
				start = end;
				while (end < length && s1[end] != ' ') {
					end++;
				}
				end--;
				reverseString(s1, start, end);
			}
			end++;
		}
		return new String(s1);
	}

}
