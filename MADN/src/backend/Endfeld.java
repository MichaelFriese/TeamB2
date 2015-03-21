package backend;

/**
 * Klasse für die Endfelder erbt von der Oberklsse Spielfeld
 * 
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class Endfeld extends Spielfeld {
	private static int counterEnde = 0;

	/**
	 * Der oeffentliche Konstruktor
	 * 
	 * @param farbe gibt die Farbe des Endfarbes an
	 */
	public Endfeld(FarbEnum farbe) {
		super();
		super.setFarbe(farbe);
		super.setID("E", (counterEnde % 4) + 1);
		counterEnde++;
	}

	public static int getCounterEnde() {
		return counterEnde;
	}
}
