package stringarrays.sort;

/**
 * Definicao: Ordenar strings a partir dos caracteres menos importantes (do fim
 * para o inicio da string)
 * 
 * Vantagens: Algoritmos lineares (às vezes sublineares), mais eficientes que
 * algoritmos de ordenação O(n log n) no caso médio
 * 
 * Premissa: strings com mesmo tamanho; usa o key-indexed counting
 *
 * Complexidade: O(2WN) com O(N+R) de espaço
 */
public class LSDRadixSort {

	public static void sort(String[] a, int W) {
		int R = 256;
		int N = a.length;
		String[] aux = new String[N];

		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];
			for (int i = 0; i < N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}
	}

}
