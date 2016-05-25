package stringarrays;

/**
 * Lookup O(1), desde que se conheça qual o indice do valor desejado. Do
 * contrario, a busca é O(n) Insercoes e delecoes sao O(n), e será necessario
 * mover os dados
 *
 */
public class PlayArrays {
	
	public static void main(String[] args) {
		PlayArrays play = new PlayArrays();
		System.out.println(play.mostEfficientStringLoop());
	}

	/**
	 * Mais eficiente do que concatenar com +
	 */
	private String mostEfficientStringLoop() {
		//instanciar Builder fora do array
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < 10; ++i) {
			b.append(i)
			 .append(' ');
		}
		return b.toString();
	}

}
