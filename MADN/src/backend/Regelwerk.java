package backend;

public class Regelwerk {
	
	private Spieler spieler;
	private FarbEnum farbe;
	private Wuerfel1 wuerfel;
	private int ID;
	
	
	
//	public String spielzug(Spieler spieler){
//		
//		
//		
//		if(spieler.getFarbe().equals("red")){
//			if(wuerfel.getErgebnis()==6){
//				spieler.getSp1().setPositionNew(spieler.getSp1());
//			}
//			
//			
//		}
//	}
		
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
