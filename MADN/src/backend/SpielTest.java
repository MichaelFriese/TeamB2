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
		s.SpielerHinzufügen("Michael", "red");
		s.SpielerHinzufügen("Judith", "blue");
		s.initSpiel();
		
		System.out.println(s.getBrett());
	}
}