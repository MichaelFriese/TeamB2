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
//			if (spieler.getWuerfel().getErgebnis() == 6) {
				spiel.getBrett().getSpielbrett()[0].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[0].getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
//			}
		}
		if (spieler.getFarbe().equals(FarbEnum.BLUE)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spiel.getBrett().getSpielbrett()[0].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[10]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
		if (spieler.getFarbe().equals(FarbEnum.GREEN)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spiel.getBrett().getSpielbrett()[0].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[20]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
		if (spieler.getFarbe().equals(FarbEnum.YELLOW)) {
			if (spieler.getWuerfel().getErgebnis() == 6) {
				spiel.getBrett().getSpielbrett()[0].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[30]
						.getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}
	}
	
	public void figurZiehen(Spieler spieler, Spielfigur spielfigur){
		
//		Spielfeld oldPos=spielfigur.getSpielfeld();
		int oldPos = spielfigur.getSpielfeld().getPosition(); 
//		int newPos = oldPos + spieler.getWuerfel().getErgebnis();
		int newPos = 4;
		
		
		switch (spielfigur.getFarbe()) {
		case RED:
			if(newPos > 40){
				newPos-=40;
				if(newPos > 4){
					break;
				}
				insEndfeldLaufen(spieler, spielfigur, newPos);
			}
			break;
		case BLUE:
			if(newPos > 10){
				newPos-=10;
				if(newPos > 4){
					break;
				}
				insEndfeldLaufen(spieler, spielfigur, newPos);
			}
			break;
		case GREEN:
			if(newPos > 20){
				newPos-=20;
				if(newPos > 4){
					break;
				}
				insEndfeldLaufen(spieler, spielfigur,newPos);
			}
			break;
		case YELLOW:
			if(newPos > 30){
				newPos-=30;
				if(newPos > 4){
					break;
				}
				insEndfeldLaufen(spieler, spielfigur,newPos);
			}
			break;
		}
		
		if(newPos >= 40){
			newPos -= 40;
		}
		
		if(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur() == null){
			spielfigur.getSpielfeld().setSpielfigur(null);
			spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0]);
			spielfigur.getSpielfeld().setSpielfigur(spielfigur);
		}
		if(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur() != null){
			if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur().getFarbe())){
				System.out.println("Feld von eigener Spielfigur besetzt!");
			}else{
				schmeissen(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur());
			}
		}
	
	}
	
	public void insEndfeldLaufen(Spieler spieler, Spielfigur spielfigur, int newPos){
		switch (spielfigur.getFarbe()) {
		case RED:
			for(int i=1; i<=newPos; i++){
				if(spiel.getBrett().getSpielbrett()[39].getFelder()[i].getSpielfigur() != null){
					System.out.println("Ueberspringen nicht moeglich");
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[39].getFelder()[newPos]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
			break;
		case BLUE:
			for(int i=1; i<=newPos; i++){
				if(spiel.getBrett().getSpielbrett()[9].getFelder()[i].getSpielfigur() != null){
					System.out.println("Ueberspringen nicht moeglich");
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[9].getFelder()[newPos]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
			break;
		case GREEN:
			for(int i=1; i<=newPos; i++){
				if(spiel.getBrett().getSpielbrett()[19].getFelder()[i].getSpielfigur() != null){
					System.out.println("Ueberspringen nicht moeglich");
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[19].getFelder()[newPos]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
			break;
		case YELLOW:
			for(int i=1; i<=newPos; i++){
				if(spiel.getBrett().getSpielbrett()[29].getFelder()[i].getSpielfigur() != null){
					System.out.println("Ueberspringen nicht moeglich");
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[29].getFelder()[newPos]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
			break;
		}
	}
	
	public void schmeissen(Spielfigur spielfigur) {
		spielfigur.getSpielfeld().setSpielfigur(null);
		switch (spielfigur.getFarbe()) {
		case RED:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[0].getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[0].getFelder()[i] == null) {
					spiel.getBrett().getSpielbrett()[0].getFelder()[i]
							.setSpielfigur(spielfigur);
					System.out.println(spiel.getBrett().getSpielbrett()[0].getFelder()[i].getSpielfigur().toString()+" Wurde auf Startfeld geschmissen");
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
					System.out.println(spiel.getBrett().getSpielbrett()[10].getFelder()[i].getSpielfigur().toString()+" Wurde auf Startfeld geschmissen");
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
					System.out.println(spiel.getBrett().getSpielbrett()[20].getFelder()[i].getSpielfigur().toString()+" Wurde auf Startfeld geschmissen");
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
					System.out.println(spiel.getBrett().getSpielbrett()[30].getFelder()[i].getSpielfigur().toString()+" Wurde auf Startfeld geschmissen");
					break;
				}
			}
			break;
		}

	}

	/**
	 * // * l�scht eine Spielfigur von dem Startfeld und setzt sie auf das Erste
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
