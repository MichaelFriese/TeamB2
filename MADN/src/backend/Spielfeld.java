package backend;

import backend.Spieler.Spielfigur;

public class Spielfeld {
	private static int counter = 0;
	private String id;
	private Spielfigur spielfigur;
	private FarbEnum farbe=null;
	private int position=0;
	
	public Spielfeld (){
		counter ++;
		setID("" , counter - Startfeld.getCounterStart() - Endfeld.getCounterEnde());
	}
	public void setID (String prefix, int id){
		this.id = prefix + id;
	}
	public void setFarbe(FarbEnum farbe){
		this.farbe=farbe;
	}
	public String getID (){
		return id;
	}
	public FarbEnum getFarbe(){
		return farbe;
	}
	public void setSpielfigur(int position,Spielfigur spielfigur){
		for(int i=1;i<=4;i++){
//			if(spielfigur.farbe.equals(getFarbe())){
//				
//			}
			
		}
	}
	public int getPosition(){
		return position;
	}
		
	
	public Spielfigur getSpielfigur() {
		return spielfigur;
	}
	public void setSpielfigur(Spielfigur spielfigur) {
		this.spielfigur = spielfigur;
	}
	
	
	@Override
	public String toString(){
		if(spielfigur==null)
			return this.getID() + "_"+this.getFarbe()+"_null";
		else
			return this.getID() + "_"+this.getFarbe()+"_"+spielfigur.toString();
	}
}
