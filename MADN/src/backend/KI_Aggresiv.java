package backend;

public class KI_Aggresiv extends KI {

	public KI_Aggresiv(Spieler spieler, Spiel spiel) {
		super(spieler, spiel);
	}

	/**
	 * gibt eine Spielfigur weiter in zugDurchführen der Klasse Spiel mit
	 * folgender Priorität:1. schmeissen wenn nicht dann 2. Versuchen raus zu
	 * kommen wenn nicht dann 3. Versuche ins Endfeld wenn nicht dann 4. Figur
	 * im Spielfeld ziehen wenn nicht dann ist der nächste Spieler am Zug
	 */

	@Override
	public void kiZug() {

		if (KIVersucheSchmeissen() != null) {
			int id = KIVersucheSchmeissen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheRauskommen() != null) {
			int id = KIVersucheRauskommen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheInsEndfeld() != null) {
			int id = KIVersucheInsEndfeld().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheFigurZiehen() != null) {
			int id = KIVersucheFigurZiehen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else
			super.getSpiel().setNaechster(super.getSpieler());
	}

}
