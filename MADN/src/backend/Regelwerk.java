package backend;

import backend.Spieler.Spielfigur;

public class Regelwerk {
	
	private Spieler spieler;
	private FarbEnum farbe;
	
	private int ID;

	
	
	public void spielzug(Spieler spieler){
		
		if(spieler.getFarbe().equals(FarbEnum.RED)){
			
			if(spieler.getWuerfel().getRaus()==6){
				Spielfigur sp = spieler.getSpielfigur();

				
			
			}
			
			
		}
	}
		
	public int getID(){
		if(spieler.getFarbe().equals("red")){
		return	spieler.getSp1().getID();
	}
		if(spieler.getFarbe().equals("blue")){
		return	spieler.getSp1().getID();
	
	}
		if(spieler.getFarbe().equals("yellow")){
		return	spieler.getSp1().getID();
	
	}
		if(spieler.getFarbe().equals("green")){
		return	spieler.getSp1().getID();
	
			}
		return 0;
		}
	}
