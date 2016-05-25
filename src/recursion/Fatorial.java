package recursion;

/**
 * Iterative solutions are usually more efficient than recursive solutions.
 *
 */
public class Fatorial {

	/**
	 * If it’s a recursive solution, you might want to mention the
	 * inefficiencies inherent in recursive solutions
	 */
	public static void main(String[] args) {
		Fatorial fatorial = new Fatorial();
		int fatorial2 = fatorial.fatorial(4);
		System.out.println(fatorial2);
	}

	private int fatorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * fatorial(n - 1);
	}

}
