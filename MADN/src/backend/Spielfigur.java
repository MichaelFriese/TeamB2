package backend;



public class Spielfigur {

	
	public static FarbEnum farbe;
	
	
	public Spielfigur(String farbe){
	
	if (farbe.equals("blau")) {

		Spielfigur.farbe = FarbEnum.BLUE;

	} else if (farbe.equals("gelb")) {
		Spielfigur.farbe = FarbEnum.YELLOW;

	} else if (farbe.equals("gruen")) {
		Spielfigur.farbe = FarbEnum.GREEN;
	} else if (farbe.equals("rot")) {
		Spielfigur.farbe = FarbEnum.RED;
	}
	


}
}
