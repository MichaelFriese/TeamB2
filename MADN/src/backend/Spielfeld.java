package backend;

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
			if(Spielfigur.farbe.equals(getFarbe())){
				
			}
			
		}
	}
	public int getPosition(){
		return position;
	}
		
	
	
	
	@Override
	public String toString(){
		return this.getID() + "_"+this.getFarbe();
	}
}
