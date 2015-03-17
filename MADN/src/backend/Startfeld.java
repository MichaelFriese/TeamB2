package backend;



public class Startfeld extends Spielfeld {
	private static int counterStart = 0;
	public Startfeld (FarbEnum farbe){
		super();
		super.setFarbe(farbe);
		super.setID("S",(counterStart%4)+1);
		counterStart++;
		
	}
	public static int getCounterStart (){
		return counterStart;
	}

}
