package backend;

import java.util.ArrayList;

import frontend.iBediener;

/**
 * Spiel Klasse dient zum "starten" des Spiels
 * 
 * @author Judith, Michi, Doerte, Tobi
 *
 */
public class Spiel implements iBediener {
	
	private Spielbrett brett;
	private ArrayList<Spieler> spieler;
	private Spieler amZug;
	private Regelwerk regelwerk;
	

	/**
	 * Konstruktor der Spielklasse Spielbrett, Regelwerk und Spieler werden
	 * initialisiert
	 */
	public Spiel() {
		this.brett = new Spielbrett();
		this.regelwerk = new Regelwerk(this);
		spieler = new ArrayList<Spieler>();
	}

	/**
	 * gibt das Spielbrett zurueck
	 * 
	 * @return brett
	 */
	public Spielbrett getBrett() {
		return brett;
	}

	/**
	 * gibt das Array der Spieler zurueck
	 * 
	 * @return spieler
	 */

	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}

	/**
	 * gibt zurueck welcher Spieler am Zug ist
	 * 
	 * @return amZug
	 */

	public Spieler getAmZug() {
		return amZug;
	}

	/**
	 * setzt den Spieler, welcher an der Reihe ist
	 * und wuerfelt
	 * @param amZug
	 */
	public void setAmZug(Spieler amZug) {
		this.amZug = amZug;
		System.out.println(getAmZug().toString() +" ist am Zug");
//		getAmZug().getWuerfel().wuerfeln();
//		getAmZug().getWuerfel().wurf6();
		//Zum Testen wird nur 2 gewuerfelt:
		getAmZug().getWuerfel().wuerfel2();
	}
	
	/**
	 * ermittelt Spieler der als naechstes am Zug ist
	 * @param amZug
	 */
	public void setNaechster(Spieler amZug){
		for(int i=0; i<=spieler.size()-1; i++){
			if(amZug.equals(spieler.get(i))){
				if(i==spieler.size()-1){
					setAmZug(spieler.get(0));
					return;
				}
				setAmZug(spieler.get(i+1));
				return;
			}
		}
	}

	@Override
	public void SpielerHinzufuegen(String name, String farbe, String ki) {
		KIEnum ai = null;
		if(ki!=null){
			switch (ki.toUpperCase()){
			case "AGGRESSIV":
				ai = KIEnum.AGGRESSIV;
				break;
				
			case "DEFENSIV":
				ai= KIEnum.DEFENSIV;
				break;
			
			default:
				throw new RuntimeException("Entweder `AGGRESSIV� oder `DEFENSIV�");
			}
		}
		
		if (farbe != null) {
			FarbEnum f = null;
			switch (farbe.toUpperCase()) {
			case "RED":
				f = FarbEnum.RED;
				break;
			case "BLUE":
				f = FarbEnum.BLUE;
				break;
			case "GREEN":
				f = FarbEnum.GREEN;
				break;
			case "YELLOW":
				f = FarbEnum.YELLOW;
				break;
			default:
				throw new RuntimeException("Farbwahl bitte auf Englisch");
			}
			if (spieler.size() >= 4) {
				throw new RuntimeException("keine Plaetze mehr verfuegbar");
			}
			if (name == null) {
				throw new RuntimeException("ungueltige Eingabe");
			}
			for (Spieler s : spieler) {
				if (s.getFarbe().equals(farbe)) {
					throw new RuntimeException("Farbe schon vergeben");
				}
			} 
				spieler.add(new Spieler(name, f, ai,this));
		}
	}

	@Override
	public void initSpiel() {
		for (Spieler s : spieler) {
			FarbEnum farbe = s.getFarbe();
			switch (farbe) {
			case RED:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[0].getFelder()[i + 1]);
					brett.getSpielbrett()[0].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			case BLUE:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[10].getFelder()[i + 1]);
					brett.getSpielbrett()[10].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			case GREEN:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[20].getFelder()[i + 1]);
					brett.getSpielbrett()[20].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			case YELLOW:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[30].getFelder()[i + 1]);
					brett.getSpielbrett()[30].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			}
		}
		
		setAmZug(spieler.get(0));
//		System.out.println(getAmZug().toString() +" ist am Zug");
//		getAmZug().getWuerfel().wuerfeln();
//		getAmZug().getWuerfel().wurf6();

	}

	public void zugDurchfuehren(int ID){
		regelwerk.aktionsWahl(getAmZug(), getAmZug().getSpielfigur(ID), getAmZug().getWuerfel().getErgebnis());
		System.out.println(brett.toString());
	}
	
	public void zugDurchfuehrenSchmeissenTest(int ID){
		regelwerk.aktionsWahl(spieler.get(1), spieler.get(1).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		System.out.println(brett.toString());
	}
	
	public void zugDurchfuehrenEndfeldTest(int ID){
		for(int i=1; i<=21; i++){
			regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		}
		System.out.println(brett.toString());
	}
	
	/**
	 * gibt das Regelwerk zurueck
	 * 
	 * @return regelwerk
	 */
	public Regelwerk getRegelwerk() {
		return regelwerk;
	}

}
