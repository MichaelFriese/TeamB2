package backend;

import java.util.Random;
/**
 * klasse zum Wuerfeln
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class Wuerfel1 {

	private int ergebnis;
	
	
	/**
	 * methode zum Wuerfeln
	 * @return eine Zufallszahl zwischen 1 und 6
	 */
	public int  wuerfel(){
		
		ergebnis= new Random().nextInt(6);
		ergebnis=ergebnis+1;
		String[] zahlen = { "Eins","Zwei","Drei","Vier","Fuenf","Sechs" };
		System.out.println(zahlen[ergebnis-1] + " gewuerfelt");
		
		return ergebnis;
	}
	
	/**
	 * gibt das Ergebnis vom Wuerfel zurück
	 * @return eine Zahl zwischen 1 und 6
	 */
	public int getErgebnis(){
		return ergebnis;
	}
	
	
	/**
	 * Pseudowürfel zum testen 
	 * @return  6
	 */
	public int getRaus(){
	return 6;
	
	}
}
