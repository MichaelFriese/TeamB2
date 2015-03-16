package backend;

public class Spielfeld {
	private static int counter = 0;
	private String id;
	private Spielfigur spielfigur;
	private FarbEnum farbe=null;
	
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
	@Override
	public String toString(){
		return this.getID() + "_"+this.getFarbe();
	}
}
