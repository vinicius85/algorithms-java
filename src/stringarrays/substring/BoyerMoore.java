package stringarrays.substring;

/**
 * Definicao:
 * 
 * - Scan caracteres do padrao da direita para esquerda
 *
 * - Skipa M chars quando encontra char que nao esta no padrao
 * 
 * 
 * Estrutura de Dado:
 * 
 * - Array
 * 
 * Premissas:
 * 
 * 
 * Complexidade: O(N/M) - sublinear. O(MN) no pior caso
 * 
 * 
 * Aplicacao:
 * 
 * 
 */
public class BoyerMoore extends Substring {

	private int[] right;

	public BoyerMoore(String pattern) {
		super(pattern);
		right = new int[RADIX];
		for (int c = 0; c < RADIX; c++)
			right[c] = -1;
		for (int j = 0; j < pattern.length(); j++)
			right[pattern.charAt(j)] = j;
	}

	@Override
	public int search(String txt) {
		int N = txt.length();
		int M = pattern.length();
		int skip;
		for (int i = 0; i <= N - M; i += skip) {
			skip = 0;
			for (int j = M - 1; j >= 0; j--) {
				if (pattern.charAt(j) != txt.charAt(i + j)) {
					skip = Math.max(1, j - right[txt.charAt(i + j)]);
					break;
				}
			}
			if (skip == 0)
				return i;
		}
		return N;
	}

}
