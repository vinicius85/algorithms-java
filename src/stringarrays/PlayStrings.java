package stringarrays;

import java.util.Hashtable;

/**
 * PROBLEM Write an efficient function to find the first nonrepeated character
 * in a string. For instance, the first nonrepeated character in “ total ” is '
 * o ' and the first nonrepeated character in “ teeter ” is ' r '. Discuss the
 * efficiency of your algorithm
 *
 */
public class PlayStrings {

	public static void main(String[] args) {
		PlayStrings playStrings = new PlayStrings();
		System.out.println(playStrings.findFirstNonRepeated("teeter"));
	}

	/**
	 * Usar uma estrutura de dados de acesso O(1). Indice de arrays ou key de
	 * Hashtable
	 * 
	 * "arrays are a better choice for long strings with a limited set of
	 * possible character values; hash tables are more efficient for shorter
	 * strings or when there are many possible character values"
	 */
	private char findFirstNonRepeated(String s1) {
		Hashtable<Character, Integer> charHash = new Hashtable<>();
		char first = ' ';
		//Montar a hashtable: O(n)
		for (Character c : s1.toCharArray()) {
			if (!charHash.containsKey(c)) {
				charHash.put(c, 1);
			} else {
				charHash.put(c, charHash.get(c) + 1);
			}
		}
		
		//Iterar sobre a string: O(n)
		for (Character c : s1.toCharArray()) {
			if (charHash.get(c) == 1) {
				first = c;
				break;
			}
		}
		
		//Performance do algoritmo: O(n)
		return first;
	}

}
