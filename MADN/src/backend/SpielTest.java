package backend;

/**
 * Klasse zum Spielstart
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class SpielTest {

	/**
	 * Main Methode 
	 * @param args
	 */
	public static void main(String[] args) {
		Spiel s = new Spiel();
		s.SpielerHinzuf�gen("Michael", "red");
		s.SpielerHinzuf�gen("Judith", "blue");
		s.initSpiel();
		
		System.out.println(s.getBrett());
	}
}