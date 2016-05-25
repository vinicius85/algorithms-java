package stringarrays.substring;

/**
 * Definicao:
 * 
 * - Modular hashing
 * 
 * - computar hash do padrao 0 a M-1
 * 
 * - para cada i, computar hash do texto de i a M+i-1
 * 
 * - se hash = hash da substring, match
 * 
 * 
 * Estrutura de Dado:
 * 
 * - Hash
 * 
 * 
 * Premissas:
 * 
 * 
 * Complexidade: O(N), N = tamanho do texto
 * 
 * 
 * Aplicacao:
 * 
 * - Extensível para computar multiplos padroes
 * 
 * 
 */
public class RabinKarp extends Substring {

	/**
	 * Se Q é um primo alto aleatorio a probabilidade de colisao será 1/Q
	 */
	private static final int Q = 123123231;
	private long patternHash;
	private long RM;

	public RabinKarp(String pattern) {
		super(pattern);
		int M = pattern.length();
		RM = 1;
		for (int i = 1; i <= M - 1; i++) {
			RM = (RADIX * RM) % Q;
		}
		patternHash = hash(pattern, M);
	}

	@Override
	public int search(String txt) {
		int M = pattern.length();
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (patternHash == txtHash)
			return 0;
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM * txt.charAt(i = M) % Q) % Q;
			txtHash = (txtHash * RADIX + txt.charAt(i)) % Q;
			if (patternHash == txtHash)
				return i - M + 1;
		}
		return N;
	}

	/**
	 * Horner linear-time hash
	 */
	private long hash(String key, int M) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (RADIX * h + key.charAt(j)) % Q;
		return h;
	}

}
