package backend;

import backend.Spieler.Spielfigur;

/**
 * Klasse fuer die Startfelder
 * erbt von der Oberklsse Spielfeld
 * @author Judith, Michi,Tobi,Doerte
 *
 */


public class Startfeld extends Spielfeld {
	
	private static int counterStart = 0;
	
	/**
	 * Der oeffentliche Konstruktor 
	 * @param farbe gibt die Farbe des Spielfeldes an
	 */
	public Startfeld (FarbEnum farbe){
		super();
		super.setFarbe(farbe);
		super.setID("S",(counterStart%4)+1);
		counterStart++;
		
	}
	
	public static int getCounterStart (){
		return counterStart;
	}

}
