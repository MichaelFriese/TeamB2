package backend;

/**
 * Klasse für die Endfelder, erbt von Spielfeld
 * 
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class Endfeld extends Spielfeld {
	
	/**
	 * @param counterEnde zählt anzahl der erstellten Endfelder. Static damit Wert an Spielbrett weitergegeben werden kann
	 */
	
	private static int counterEnde = 0;

	/**
	 * Der oeffentliche Konstruktor
	 * 
	 * @param farbe gibt die Farbe des Endfeldes an
	 * @param setID übernimmt ID von Spielfeld, E für Endfeld, counterEnde modulo 4 damit anzahl der Endfelder nicht 4 überschreiten kann.
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
