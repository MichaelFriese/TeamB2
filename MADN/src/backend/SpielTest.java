package backend;

import frontend.iBediener;

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
		
		private iBediener s = new Spiel ();
		
		s.SpielerHinzufuegen("Rosa", "red",null);
		s.SpielerHinzufuegen("Helmut", "blue",null);
		s.SpielerHinzufuegen("Reiner", "Green",null);
		s.SpielerHinzufuegen("Ole", "Yellow",null);
		s.initSpiel();

		Spieler s1 = s.getSpieler().get(0);
		Spieler s2 = s.getSpieler().get(1);
		Spieler s3= s.getSpieler().get(2);
		Spieler s4= s.getSpieler().get(3);
		
		
		/*
		 * Zum Testen wird dauerhaft 2 gewuerfelt (spaeter wieder aendern in Spiel.setAmZug())
		 * Spieler kommen mit jeder Zahl von Startfeld weg (Regelwerk.rauskommen())
		 */
		
		spielenNachReihenfolge();
//		spielerSchmeissen(s1);
//		endfelderLaufen(s2);
		
		
		System.out.println(s.getBrett());
	}

	/**
	 * Spieler laeuft um komplettes feld in Endfelder rein
	 * @param spieler, Reihenfolge wird nicht beachtet-> Spieler übergeben
	 */
	public static void endfelderLaufen(Spieler spieler) {
		s.getRegelwerk().rauskommen(spieler, spieler.getSpielfigur(1));
		for(int i=1; i<=21; i++){
			s.getRegelwerk().figurZiehen(spieler, spieler.getSpielfigur(1));			
		}
	}

	/**
	 * Jeder Spieler kommt von Startfeld und laeuft 2 felder.
	 * Rot kommt am Ende mit 2. Spielfigur vom startfeld weg
	 * alles mit richriger Reihenfolge mit spiel.getAmZug()
	 */
	public static void spielenNachReihenfolge() {
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(2));
		s.getRegelwerk().figurZiehen(s.getAmZug(), s.getAmZug().getSpielfigur(2));
	}

	/**
	 * Spieler 1 schlaegt Spielfigur von Spieler 2
	 * 
	 * @param s1, Reihenfolge wird nicht beachtet-> Spieler übergeben
	 */
	public static void spielerSchmeissen(Spieler s1){
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().rauskommen(s.getAmZug(), s.getAmZug().getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
	}

}