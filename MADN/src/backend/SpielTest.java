package backend;

/**
 * Klasse zum Spielstart
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class SpielTest {
	private static Spiel s = new Spiel();

	/**
	 * Main Methode 
	 * @param args
	 */
	public static void main(String[] args) {
		
		s.SpielerHinzufuegen("Rosa", "red");
		s.SpielerHinzufuegen("Helmut", "blue");
		s.SpielerHinzufuegen("Reiner", "Green");
		s.SpielerHinzufuegen("Ole", "Yellow");
		s.initSpiel();
		System.out.println(s.getSpieler().get(0).getName()+s.getSpieler().get(0).getFarbe());
		System.out.println(s.getSpieler().get(1).getName()+s.getSpieler().get(1).getFarbe());
		System.out.println(s.getSpieler().get(2).getName()+s.getSpieler().get(2).getFarbe());
		System.out.println(s.getSpieler().get(3).getName()+s.getSpieler().get(3).getFarbe());
		
		Spieler s1 = s.getSpieler().get(0);
		Spieler s2 = s.getSpieler().get(1);
		Spieler s3= s.getSpieler().get(2);
		Spieler s4= s.getSpieler().get(3);
		
		SpielzugRaus(s1,s2,s3,s4);
		//System.out.println(s.getBrett());
		ziehen(s1,s2,s2,s4);
		ziehen(s1,s2,s2,s4);
		
		
		System.out.println(s.getBrett());
	}


public static void SpielzugRaus(Spieler s1, Spieler s2, Spieler s3, Spieler s4){
	s.getRegelwerk().rauskommen(s1, s1.getSpielfigur(1));
	s.getRegelwerk().rauskommen(s2, s2.getSpielfigur(1));


}

	
	public static void ziehen(Spieler s1, Spieler s2, Spieler s3, Spieler s4){
		s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
		s.getRegelwerk().figurZiehen(s2, s2.getSpielfigur(1));
		//s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
		//s.getRegelwerk().figurZiehen(s1, s1.getSpielfigur(1));
		
		
	}

}