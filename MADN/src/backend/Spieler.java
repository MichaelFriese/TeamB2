package backend;

/**
 * Klasse für die Verwaltung eines Spieler
 * 
 * @author Judy, Michi,Tobi,Doerte
 *
 */

public class Spieler {

	private Spielfigur[] spielfigur;

	/*
	 * private Spielfigur sp1; private Spielfigur sp2; private Spielfigur sp3;
	 * private Spielfigur sp4;
	 */
	private FarbEnum farbe;
	private String name;
	private Wuerfel wuerfel;

	/**
	 * Konstruktor mit Erstellung der Spielfiguren
	 * 
	 * @param name
	 *            des Spielers
	 * @param farbe
	 *            gewählte Farbe der Spielfigur
	 * @param brett
	 *            das Spielbrett
	 * @param regel
	 *            die Regeln für das Spiel
	 */
	public Spieler(String name, FarbEnum farbe) {
		setFarbe(farbe);
		setName(name);
		wuerfel = new Wuerfel();

		this.spielfigur = new Spielfigur[4];

		for (int i = 0; i < 4; i++) {
			spielfigur[i] = new Spielfigur(i + 1);
		}

	}

	/**
	 * gibt die Zufallszahl des Würfels zurück
	 * 
	 * @return gewürfelte Zahl
	 */
	public Wuerfel getWuerfel() {
		return wuerfel;
	}

	/**
	 * gibt die Farbe des farbEnums wieder
	 * 
	 * @return farbe des Enums
	 */

	public FarbEnum getFarbe() {
		return farbe;
	}

	/**
	 * gibt des Namen des Spielers zurück
	 * 
	 * @return name name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * setzt die gewählte Farbe des Spielers
	 * 
	 * @param farbe
	 *            gewählte farbe des Spielers
	 */
	private void setFarbe(FarbEnum farbe) {
		this.farbe = farbe;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gibt die Spielfigur mit gewünschter ID zurück
	 * 
	 * @param i
	 * @return Spielfigur mit angegebener ID
	 */
	public Spielfigur getSpielfigur(int i) {
		i = i - 1;
		if (i < 0)
			i = 0;
		return spielfigur[i];

	}
	
	public Spielfigur[] getSpielfiguren(){
		return spielfigur;
	}
	

	@Override
	public String toString() {
		return getName() + "_" + getFarbe();
	}

	/**
	 * Innere Klasse Spielfigur
	 * 
	 * @author Judy, Michi,Tobi,Doerte
	 *
	 */

	public class Spielfigur {
		private int ID;
		private Spielfeld spielfeld;

		/**
		 * Kontruktor der Inneren Klasse kann nur über die Spielerklasse
		 * aufgerufen werden
		 * 
		 * @param ID
		 *            übergibt jeder erstellte Spielfigur eine ID
		 */

		private Spielfigur(int ID) {
			this.ID = ID;
			this.spielfeld = null;
		}

		/**
		 * gibt die ID der Spielfigur zurück
		 * 
		 * @return ID der Spielfigur
		 */
		public int getID() {
			return ID;
		}

		public Spielfeld getSpielfeld() {
			return spielfeld;
		}

		public void setSpielfeld(Spielfeld spielfeld) {
			if (spielfeld != null) {
				this.spielfeld = spielfeld;
			}
		}

		@Override
		public String toString() {
			return "Spielfigur" + "" + getID() + "_" + getName() + "_"
					+ getFarbe();
		}

	}

}
