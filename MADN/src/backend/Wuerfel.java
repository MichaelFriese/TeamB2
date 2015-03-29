package backend;

import java.util.Random;
/**
 * klasse zum Wuerfeln
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class Wuerfel {

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
	 * gibt das Ergebnis vom Wuerfel zurueck
	 * @return eine Zahl zwischen 1 und 6
	 */
	public int getErgebnis(){
		return ergebnis;
	}
	
	
	/**
	 * Pseudowuerfel zum testen 
	 * @return  6
	 */
	public int wurf6(){
		System.out.println("gewürfelt");
		return 6;
	}
}
	

