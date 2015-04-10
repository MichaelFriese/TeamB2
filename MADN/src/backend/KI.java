package backend;

import backend.Spieler.Spielfigur;

public abstract class KI {

	private Spieler spieler;
	private Spiel spiel;

	public KI(Spieler spieler, Spiel spiel) {
		this.spieler = spieler;
		this.spiel = spiel;

	}

	public Spielfigur KIVersucheRauskommen() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i + 1);
			if (s.getSpielfeld().getID().contains("S")
					&& spieler.getWuerfel().getErgebnis() == 6) {
				return s;
			}
		}
		return null;
	}

	public Spielfigur KIVersucheInsEndfeld() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i + 1);

			int oldPos = spiel.getBrett().getSpielbrett()[s.getSpielfeld()
					.getPosition()]
					.getFelder()[0].getSpielfigur().getSpielfeld()
					.getPosition();
			int newPos= oldPos + spieler.getWuerfel().getErgebnis();
			
			switch (spieler.getFarbe()) {
			case RED:
					
				if(newPos >= 39){
					return s;
				}
				break;
			case BLUE:
				if(newPos >= 9){
					return s;
				}
				break;
			case GREEN:
				if(newPos >= 19){
					return s;
				}
				break;
			case YELLOW:
				if(newPos >= 29){
					return s;
				}
				break;
					}
				}
		return null;

	}

	public Spielfigur KIVersucheSchmeissen() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i + 1);
			Spielfigur s2 = spiel.getBrett().getSpielbrett()[s.getSpielfeld()
					.getPosition() + spieler.getWuerfel().getErgebnis()]
					.getFelder()[0].getSpielfigur();
			if (s2 != null && !(s2.getFarbe().equals(s.getFarbe()))) {
				return s;
			}
		}
		return null;
	}

	public Spielfigur KIVersucheFigurZiehen() {

		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigur(i + 1);

			if (!(s.getSpielfeld().getID().contains("S"))
					&& spiel.getBrett().getSpielbrett()[s.getSpielfeld()
							.getPosition() + spieler.getWuerfel().getErgebnis()]
							.getFelder()[0].getSpielfigur() == null) {
				return s;
			} else
				KIVersucheRauskommen();
		}
		return null;

	}
}
