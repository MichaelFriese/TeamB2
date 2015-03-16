package backend;

public class Endfeld extends Spielfeld {
	private static int counterEnde = 0;
	public Endfeld (FarbEnum farbe){
		super();
		super.setFarbe(farbe);
		super.setID("E",(counterEnde%4) +1);
		counterEnde++;
	}
	public static int getCounterEnde (){
		return counterEnde;
	}
}
