package backend;

public class FeldWrapper {

	private Spielfeld [] felder;
	private Spielfigur spielfigur;
	public FeldWrapper(boolean istStart, boolean istEnde,FarbEnum farbe,Spielfigur spielfigur) {
		if (istStart) {
			felder = new Spielfeld[5];
			felder[0] = new Spielfeld();
			for (int i = 1; i < felder.length; i++) {
				
				felder[i] = new Startfeld(farbe,spielfigur);
			}
		} else if (istEnde) {
			felder = new Spielfeld[5];
			felder[0] = new Spielfeld();
			for (int i = 1; i < felder.length; i++) {
				felder[i] = new Endfeld(farbe);
			}
		} else {
			felder = new Spielfeld[1];
			felder[0] = new Spielfeld();
		}
	}
	
	public Spielfeld[] getFelder(){
		return felder;
	}
	@Override
	public String toString(){
		String s="";
		for(Spielfeld x:felder){
			s+=x.toString()+"\n\t";
			
		}
		return s;
	}
}
