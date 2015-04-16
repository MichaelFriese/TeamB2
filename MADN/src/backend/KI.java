package backend;

import java.io.Serializable;

import backend.Spieler.Spielfigur;

public abstract class KI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spieler spieler;
	private Spiel spiel;

	/**
	 * Konstruktor der KI
	 * 
	 * @param spieler
	 * @param spiel
	 */

	public KI(Spieler spieler, Spiel spiel) {
		this.spieler = spieler;
		this.spiel = spiel;

	}

	/**
	 * Ermittelt die Spielfigur, welche vom Startfeld auf das Erste Spielfeld
	 * gesetzt werden kann
	 * 
	 * @return Spielfigur
	 */

	public Spielfigur KIVersucheRauskommen() {
//		System.out.println("raus");
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i);
			if (s.getSpielfeld().getID().contains("S")){ //&& spieler.getWuerfel().getErgebnis() == 6) {
				
				if(spieler.getFarbe().equals(FarbEnum.RED) && spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}
				if(spieler.getFarbe().equals(FarbEnum.BLUE) && spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur() != null){
					System.out.println("hier");
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}
				if(spieler.getFarbe().equals(FarbEnum.GREEN) && spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}
				if(spieler.getFarbe().equals(FarbEnum.YELLOW) && spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}

				return s;
			}
		}
		return null;
	}

	/**
	 * Ermittelt die Spielfigur, welche ins Endfeld laufen kann
	 * 
	 * @return Spielfigur
	 */
	public Spielfigur KIVersucheInsEndfeld() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i);

//			int oldPos = spiel.getBrett().getSpielbrett()[s.getSpielfeld().getPosition()].getFelder()[0].getSpielfigur().getSpielfeld().getPosition();
			int oldPos = s.getSpielfeld().getPosition();
			int newPos = oldPos + spieler.getWuerfel().getErgebnis();

			switch (spieler.getFarbe()) {
			case RED:

				if (newPos >= 39) {
					return s;
				}
				break;
			case BLUE:
				if (newPos >= 9) {
					return s;
				}
				break;
			case GREEN:
				if (newPos >= 19) {
					return s;
				}
				break;
			case YELLOW:
				if (newPos >= 29) {
					return s;
				}
				break;
			}
		}
		return null;

	}

	/**
	 * Ermittelt die Spielfigur, welche eine andere Figur schmeissen kann
	 * 
	 * @return Spielfigur
	 */
	public Spielfigur KIVersucheSchmeissen() {
//		System.out.println("schmeiss");
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i);
			int newPos = (s.getSpielfeld().getPosition() + spieler.getWuerfel().getErgebnis())-1;
			
			if(newPos < 40){
				Spielfigur s2 = spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur();
//				System.out.println("pos"+(s.getSpielfeld().getPosition() + spieler.getWuerfel().getErgebnis()));
				if (s2 != null && !(s2.getFarbe().equals(s.getFarbe()))) {
					return s;
				}
			}
		}
		return null;
	}

	/**
	 * Ermittelt die Spielfigur, welche einen Zug ausführen kann
	 * 
	 * @return Spielfigur
	 */
	public Spielfigur KIVersucheFigurZiehen() {

		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i);
			int newPos = (s.getSpielfeld().getPosition() + spieler.getWuerfel().getErgebnis()) -1;
			if(newPos < 40){
				if (!(s.getSpielfeld().getID().contains("S")) && spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur() == null) {
					return s;
				} else{
					KIVersucheRauskommen();
				}
			}
		}
		return null;

	}

	/**
	 * getter für den Spieler
	 * 
	 * @return spieler
	 */

	public Spieler getSpieler() {
		return spieler;
	}

	/**
	 * getter für das Spiel
	 * 
	 * @return spiel
	 */
	public Spiel getSpiel() {
		return spiel;
	}

	public abstract void kiZug();

}
