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
	
	public void spielzug(Spieler spieler, int ID){
		
		spieler.getWuerfel().wurf6();
		
		if(spieler.getFarbe().equals(FarbEnum.RED)){
			
			if(spieler.getWuerfel().wurf6()==6){
				spieler.getSpielfigur(ID).setPositionNew(spieler.getSpielfigur(ID));	
			
			}
			
			
		}
	}
	
	public void laufen(Spieler spieler, int ID){
		
		
	}
	
}

