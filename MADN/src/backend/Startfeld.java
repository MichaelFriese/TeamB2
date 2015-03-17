package backend;



public class Startfeld extends Spielfeld {
	private static int counterStart = 0;
	public Startfeld (FarbEnum farbe,Spielfigur spielfigur){
		super();
		super.setFarbe(farbe);
//		super.setSpielfigur(getPosition(), spielfigur);
		super.setID("S",(counterStart%4)+1);
		counterStart++;
		
	}
	public static int getCounterStart (){
		return counterStart;
	}

}
