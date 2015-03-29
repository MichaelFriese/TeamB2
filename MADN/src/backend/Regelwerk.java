package backend;

import backend.Spieler.Spielfigur;

/**
 * Klasse zur Verwaltung der Spielregeln
 * 
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class Regelwerk {

	private Spiel spiel;

	// erste Versuche einen Spielzug zu fuehren

	public Regelwerk(Spiel spiel) {
		this.spiel = spiel;
	}

	public void rauskommen(Spieler spieler, Spielfigur spielfigur) {

		if (spieler.getFarbe().equals(FarbEnum.RED)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[0]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
		if (spieler.getFarbe().equals(FarbEnum.BLUE)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[10]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
		if (spieler.getFarbe().equals(FarbEnum.GREEN)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[20]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
		if (spieler.getFarbe().equals(FarbEnum.YELLOW)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[30]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
	}
	
	public void figurZiehen(Spieler spieler, Spielfigur spielfigur){
		
//		Spielfeld oldPos=spielfigur.getSpielfeld();
		int oldPos = spielfigur.getSpielfeld().getPosition(); 
		int newPos = oldPos + spieler.getWuerfel().getErgebnis();
		
		spielfigur.getSpielfeld().setSpielfigur(null);
		spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0]);
	
	}
	
	public void schmeissen(Spieler spieler, Spielfigur spielfigur) {
		spielfigur.getSpielfeld().setSpielfigur(null);
		switch (spieler.getFarbe()) {
		case RED:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[0].getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[0].getFelder()[i] == null) {
					spiel.getBrett().getSpielbrett()[0].getFelder()[i]
							.setSpielfigur(spielfigur);
					break;
				}
			}
			break;
		case BLUE:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[10]
					.getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[10].getFelder()[i] == null) {
					spiel.getBrett().getSpielbrett()[10].getFelder()[i]
							.setSpielfigur(spielfigur);
					break;
				}
			}
			break;
		case GREEN:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[20]
					.getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[20].getFelder()[i] == null) {
					spiel.getBrett().getSpielbrett()[20].getFelder()[i]
							.setSpielfigur(spielfigur);
					break;
				}
			}
			break;
		case YELLOW:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[30]
					.getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[30].getFelder()[i] == null) {
					spiel.getBrett().getSpielbrett()[30].getFelder()[i]
							.setSpielfigur(spielfigur);
					break;
				}
			}
			break;
		}

	}

	/**
	 * // * löscht eine Spielfigur von dem Startfeld und setzt sie auf das Erste
	 * // * Spielfeld // * // * @param spielfigur //
	 */
	// public void setPositionNew(Spielfigur spielfigur) {
	// switch (farbe) {
	// case RED:
	// brett.getSpielbrett()[0].getFelder()[spielfigur.getID()]
	// .setSpielfigur(null);
	// brett.getSpielbrett()[0].getFelder()[0]
	// .setSpielfigur(spielfigur);
	// spielfigur.setPosition(1);
	// System.out.println("habe Spieler verschoben");
	// break;
	// case BLUE:
	// brett.getSpielbrett()[10].getFelder()[getID()]
	// .setSpielfigur(spielfigur);
	// break;
	// case YELLOW:
	// brett.getSpielbrett()[20].getFelder()[getID()]
	// .setSpielfigur(spielfigur);
	// break;
	// case GREEN:
	// brett.getSpielbrett()[30].getFelder()[getID()]
	// .setSpielfigur(spielfigur);
	// break;
	// }
	// }
	public void laufen(Spieler spieler, int ID) {

	}

}
