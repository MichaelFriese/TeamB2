package backend;

/**
 * Klasse zum Spielstart
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class SpielTest {

	/**
	 * Main Methode 
	 * @param args
	 */
	public static void main(String[] args) {
		Spiel s = new Spiel();
		s.SpielerHinzufuegen("Michael", "red");
		s.SpielerHinzufuegen("Judith", "blue");
		s.initSpiel();
		
		Spieler s1 = s.getSpieler().get(0);
//		s1.getWuerfel().wurf6();
		s.getRegelwerk().rauskommen(s1, s1.getSpielfigur(4));
		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(4));
		
//		s.getRegelwerk().rauskommen(s1, s1.getSpielfigur(3));
//		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(3));
		
		System.out.println(s.getBrett());
	}
}