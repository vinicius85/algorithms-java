package stringarrays;

/**
 * PROBLEM Write an efficient function that deletes characters from an ASCII
 * string. Use the prototype
 *
 */
public class RemoveChars {

	public static void main(String[] args) {

		RemoveChars removeChars = new RemoveChars();
		String chars = removeChars.removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou");
		System.out.println(chars);
		chars = removeChars.removeCharsOptimized("Battle of the Vowels: Hawaii vs. Grozny", "aeiou");
		System.out.println(chars);

	}

	/**
	 * Memory overhead. É necessário o dobro de espaço e tempo para manter o
	 * array de copia
	 */
	private String removeChars(String str, String remove) {
		StringBuilder finalString = new StringBuilder();
		for (Character c : str.toCharArray()) {
			if (!remove.contains(c.toString())) {
				finalString.append(c);
			}
		}
		str = finalString.toString();
		return str;
	}


	/**
	 * Continua O(n) mas sem o dobro de consumo de espaço e tempo da versao anterior
	 */
	private String removeCharsOptimized(String str, String remove) {

		boolean[] strs = new boolean[128];
		int src = 0;
		int dst = 0;

		char[] r = remove.toCharArray();
		char[] s = str.toCharArray();

		for (src = 0; src < r.length; src++) {
			strs[r[src]] = true;
		}

		for (src = 0; src < s.length; src++) {
			if (!strs[s[src]]) {
				s[dst++] = s[src];
			}
		}
		return new String(s, 0, dst);
	}

}
