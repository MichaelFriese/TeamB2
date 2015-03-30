package backend;

/**
 * Klasse f�r die Verwaltung eines Spieler
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
	 *            gew�hlte Farbe der Spielfigur
	 * @param brett
	 *            das Spielbrett
	 * @param regel
	 *            die Regeln f�r das Spiel
	 */
	public Spieler(String name, FarbEnum farbe) {
		setFarbe(farbe);
		setName(name);
		wuerfel = new Wuerfel();

		this.spielfigur = new Spielfigur[4];

		for (int i = 0; i < 4; i++) {
			spielfigur[i] = new Spielfigur(i + 1,getFarbe());
		}

	}

	/**
	 * gibt die Zufallszahl des W�rfels zur�ck
	 * 
	 * @return gew�rfelte Zahl
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
	 * gibt des Namen des Spielers zur�ck
	 * 
	 * @return name name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * setzt die gew�hlte Farbe des Spielers
	 * 
	 * @param farbe
	 *            gew�hlte farbe des Spielers
	 */
	private void setFarbe(FarbEnum farbe) {
		this.farbe = farbe;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gibt die Spielfigur mit gew�nschter ID zur�ck
	 * 
	 * @param i
	 * @return Spielfigur mit angegebener ID
	 */
	public Spielfigur getSpielfigur(int i) {
		i = i - 1;
		if (i < 0 ){
			i=0;
		}
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
		private FarbEnum farbe;

		/**
		 * Kontruktor der Inneren Klasse kann nur �ber die Spielerklasse
		 * aufgerufen werden
		 * 
		 * @param ID
		 *            �bergibt jeder erstellte Spielfigur eine ID
		 */

		private Spielfigur(int ID, FarbEnum farbe) {
			this.ID = ID;
			this.spielfeld = null;
			this.farbe = farbe;
		}

		public FarbEnum getFarbe() {
			return farbe;
		}

		public void setFarbe(FarbEnum farbe) {
			this.farbe = farbe;
		}

		/**
		 * gibt die ID der Spielfigur zur�ck
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
