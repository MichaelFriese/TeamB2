package backend;

import java.util.ArrayList;

import frontend.iBediener;

public class Spiel implements iBediener {
	private Spielbrett brett;
	private ArrayList<Spieler> spieler;
	private Spieler amZug;
	private Regelwerk regelwerk;
	
	public Spiel() {
		this.brett = new Spielbrett();
		regelwerk = new Regelwerk(this);
		spieler = new ArrayList <Spieler>();
	}
	public Spielbrett getBrett() {
		return brett;
	}

	public ArrayList <Spieler> getSpieler() {
		return spieler;
	}
	
	public Spieler getAmZug() {
		
		return amZug;
	}
	
	public void setAmZug(Spieler amZug) {
		this.amZug = amZug;
	}
	@Override
	public void SpielerHinzufügen (String name, String farbe){
		if(farbe!=null){
		FarbEnum f=null;
		switch(farbe.toUpperCase()){
		case "RED":
			f=FarbEnum.RED;
			break;
		
		case "BLUE":
		f=FarbEnum.BLUE;
		break;
		case "GREEN":
			f=FarbEnum.GREEN;
			break;
		case "YELLOW":
			f=FarbEnum.YELLOW;
			break;
		default:
			throw new RuntimeException("Farbwahl bitte auf Englisch");
		}
		if (spieler.size()>=4){
			throw new RuntimeException ("keine plätze mehr verfügbar");
		} if (name==null){
			throw new RuntimeException ("ungültige Eingabe");
		} for (Spieler s: spieler){
			if (s.getFarbe().equals(farbe)){
				throw new RuntimeException ("Farbe schon vergeben");
			}
		} spieler.add(new Spieler (name, f));
	}
	}
@Override
	public void initSpiel(){
		for(Spieler s:spieler){
			FarbEnum farbe=s.getFarbe();
		switch (farbe) {
			case RED:
				for(int i=0;i<s.getSpielfiguren().length;i++){
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[0].getFelder()[i+1]);
				brett.getSpielbrett()[0].getFelder()[i+1]
						.setSpielfigur(s.getSpielfigur(i+1));
				}
				break;
			case BLUE:
				for(int i=0;i<s.getSpielfiguren().length;i++){
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[10].getFelder()[i+1]);
					brett.getSpielbrett()[10].getFelder()[i+1]
							.setSpielfigur(s.getSpielfigur(i+1));
					}
				break;
			case YELLOW:
				for(int i=0;i<s.getSpielfiguren().length;i++){
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[20].getFelder()[i+1]);
					brett.getSpielbrett()[20].getFelder()[i+1]
							.setSpielfigur(s.getSpielfigur(i+1));
					}
				break;
			case GREEN:
				for(int i=0;i<s.getSpielfiguren().length;i++){
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[30].getFelder()[i+1]);
					brett.getSpielbrett()[30].getFelder()[i+1]
							.setSpielfigur(s.getSpielfigur(i+1));
					}
				break;
			}

		}	
	
	}
//	@Override
//	public void zugDurchfuehren(int ID){
//	
//		
//	}
		
}
