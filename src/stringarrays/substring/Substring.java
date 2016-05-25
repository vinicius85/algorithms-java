package stringarrays.substring;

/**
 * Definicao:
 * 
 * - Encontrar padrao de tamanho M em um texto de tamanho N
 * 
 * Estrutura de Dado:
 * 
 * 
 * Premissas:
 * 
 * 
 * Complexidade:
 * 
 * - Brute-force = O(N2)
 * 
 * Aplicacao:
 * 
 * - Padroes de spam
 * 
 * - Extract data: Encontrar string delimitada por uma regex após a ocorrencia
 * de um padrao
 * 
 */
public abstract class Substring {

	protected String pattern;
	protected static final int RADIX = 256;
	
	public Substring(String pattern) {
		this.pattern = pattern;
	}
	
	public abstract int search(String txt);

}
