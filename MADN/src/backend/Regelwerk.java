package backend;

import backend.Spieler.Spielfigur;

public class Regelwerk {
	
	private Spieler spieler;
	private FarbEnum farbe;
	
	private int ID;

	
	
	public void spielzug(Spieler spieler){
		
		if(spieler.getFarbe().equals(FarbEnum.RED)){
			
			if(spieler.getWuerfel().getRaus()==6){
				//Spielfigur sp = spieler.getSpielfigur();

				
			
			}
			
			
		}
	}
}

