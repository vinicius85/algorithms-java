package stringarrays.substring;

/**
 * Definicao:
 * 
 * 
 * Estrutura de Dado:
 * 
 * - Deterministic finite state automaton
 * 
 * Premissas:
 * 
 * - Evita backups
 * 
 * - Eficiente com alfabetos pequenos
 * 
 * - busca de caracteres acessa nao mais que M+N chars, padrao de tamanho M e
 * texto de tamanho N
 * 
 * Complexidade: O(Radix*patternLength) O(N) na pratica
 * 
 * 
 * Aplicacao:
 * 
 * 
 */
public class KnuthMorrisPratt extends Substring {

	private int dfa[][];

	public KnuthMorrisPratt(String pattern) {
		super(pattern);
		int M = pattern.length();
		buildDFA(pattern, M);
	}


	@Override
	public int search(String txt) {
		int i, j, N = txt.length(), M = pattern.length();
		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[txt.charAt(i)][j];
		if (j == M)
			return i - M;
		else
			return N;
	}

	private void buildDFA(String pattern, int M) {
		dfa = new int[RADIX][M];
		dfa[pattern.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < RADIX; c++) {
				dfa[c][j] = dfa[c][X];
				dfa[pattern.codePointAt(j)][j] = j + 1;
				X = dfa[pattern.charAt(j)][X];
			}
		}
	}
}
