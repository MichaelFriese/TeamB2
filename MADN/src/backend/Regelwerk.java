package backend;

import backend.Spieler.Spielfigur;


/**
 * Klasse zur Verwaltung der Spielregeln
 * @author  Judy, Michi,Tobi,Doerte
 *
 */

public class Regelwerk {
	
	private Spieler spieler;
	private FarbEnum farbe;
	
	private int ID;

	//erste Versuche einen Spielzug zu führen
	
	public void spielzug(Spieler spieler){
		
		if(spieler.getFarbe().equals(FarbEnum.RED)){
			
			if(spieler.getWuerfel().getRaus()==6){
				//Spielfigur sp = spieler.getSpielfigur();

				
			
			}
			
			
		}
	}
}

