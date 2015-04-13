package backend;

public class KI_Defensiv extends KI {

	public KI_Defensiv(Spieler spieler, Spiel spiel) {
		super(spieler, spiel);

	}

	/**
	 * gibt eine Spielfigur weiter in zugDurchführen der Klasse Spiel mit
	 * folgender Priorität: 1.Versuchen raus zu kommen, wenn nicht dann 2.
	 * Versuche ins Endfeld zu kommen, wenn nicht dann 3. Versuche Figur zu
	 * ziehen, wenn nicht dann 4. schmeissen wenn nicht dann ist der nächste
	 * Spieler am Zug
	 * 
	 */

	public void kiZugDefensiv() {

		if (KIVersucheRauskommen() != null) {
			int id = KIVersucheRauskommen().getID();
			super.getSpiel().zugDurchfuehren(id);
		}

		else if (KIVersucheInsEndfeld() != null) {
			int id = KIVersucheInsEndfeld().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheFigurZiehen() != null) {
			int id = KIVersucheFigurZiehen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheSchmeissen() != null) {
			int id = KIVersucheSchmeissen().getID();
			super.getSpiel().zugDurchfuehren(id);
		}

		else
			super.getSpiel().setNaechster(super.getSpieler());
	}

}
