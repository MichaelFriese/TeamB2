package backend;

import java.util.Random;

public class Wuerfel1 {

	private static int ergebnis;
	
	
	public static void wuerfel(){
		
		ergebnis= new Random().nextInt(6);
		ergebnis=ergebnis+1;
		String[] zahlen = { "Eins","Zwei","Drei","Vier","Fünf","Sechs" };
		System.out.println(zahlen[ergebnis-1] + " gewürfelt");
	}
	
	public static void main (String[]args){
		
		wuerfel();
	}
}
