package backend;

import java.util.Random;

public class Wuerfel1 {

	private int ergebnis;
	
	
	public int  wuerfel(){
		
		ergebnis= new Random().nextInt(6);
		ergebnis=ergebnis+1;
		String[] zahlen = { "Eins","Zwei","Drei","Vier","Fuenf","Sechs" };
		System.out.println(zahlen[ergebnis-1] + " gewuerfelt");
		
		return ergebnis;
	}
	
	public int getErgebnis(){
		return ergebnis;
	}
	
	
	
	
}
