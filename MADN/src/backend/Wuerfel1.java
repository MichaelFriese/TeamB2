package backend;

import java.util.Random;

public class Wuerfel1 {

	private int ergebnis;
	
	
	public void wuerfel(){
		
		ergebnis= new Random().nextInt(6);
		
		System.out.println(ergebnis);
	}
	
}
