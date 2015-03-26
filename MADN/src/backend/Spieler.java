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
	private Spielbrett brett;
	private Regelwerk regel;
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
	public Spieler(String name, String farbe, Spielbrett brett, Regelwerk regel) {
		this.regel = regel;
		setFarbe(farbe);
		this.name = name;
		this.brett = brett;
		wuerfel = new Wuerfel();

		this.spielfigur = new Spielfigur[4];

		for (int i = 0; i < 4; i++) {
			spielfigur[i] = new Spielfigur(i + 1);
			spielfigur[i].setzeStartPosition(spielfigur[i]);
		}

	}

	/**
	 * gibt die ZUfallszahl des Würfels zurück
	 * 
	 * @return gewürfelte Zahl
	 */
	public Wuerfel getWuerfel() {
		return wuerfel;
	}

	/*
	 * public Spielfigur getSp1() { return sp1; }
	 * 
	 * public Spielfigur getSp2() { return sp2; }
	 * 
	 * public Spielfigur getSp3() { return sp3; }
	 * 
	 * public Spielfigur getSp4() { return sp4; }
	 */

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
	 * gibt das Spielbrett zurück
	 * 
	 * @return brett, gibt die 40 Spielfelder auf dem Spielbrett
	 */

	public Spielbrett getBrett() {
		return brett;
	}

	/**
	 * setzt die gewählte Farbe des Spielers
	 * 
	 * @param farbe
	 *            gewählte farbe des Spielers
	 */
	private void setFarbe(String farbe) {
		if (farbe.equals("blue")) {
			this.farbe = FarbEnum.BLUE;
		} else if (farbe.equals("yellow")) {
			this.farbe = FarbEnum.YELLOW;
		} else if (farbe.equals("green")) {
			this.farbe = FarbEnum.GREEN;
		} else if (farbe.equals("red")) {
			this.farbe = FarbEnum.RED;
		}
	}

	/**
	 * gibt die Regeln des Spieles zurück
	 * 
	 * @return regel
	 */
	public Regelwerk getRegel() {
		return regel;
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

	public String getStandort(Spieler spieler, int ID) {
		for (int i = 0; i < brett.getSpielbrett().length; i++) {
			if (brett.getSpielbrett()[i].toString().contains(spieler.getSpielfigur(ID).toString())){
			System.out.println("gefunden");
			return brett.getSpielbrett()[i].getFelder()[0].getID();
			}
		}
		
		return null;
	}

	// hier wollte ich die Position auf dem Startfeld ausgeben lassen.

	public String istAufStartfeld(Spieler spieler) {
		for (int i = 1; i <= 4; i++) {
			if (brett.getSpielbrett()[0].getFelder()[i].equals(spieler
					.getSpielfigur(1))) {
				return brett.getSpielbrett()[0].getFelder()[i].toString();
			}
		}
		return null;

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

		public Spielfigur(int ID) {
			this.ID = ID;
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

		/**
		 * setzt die Spielfigur auf das Startfeld
		 * 
		 * @param spielfigur
		 */

		public void setzeStartPosition(Spielfigur spielfigur) {
			switch (farbe) {
			case RED:
				brett.getSpielbrett()[0].getFelder()[getID()]
						.setSpielfigur(spielfigur);
				break;
			case BLUE:
				brett.getSpielbrett()[10].getFelder()[getID()]
						.setSpielfigur(spielfigur);
			case YELLOW:
				brett.getSpielbrett()[20].getFelder()[getID()]
						.setSpielfigur(spielfigur);
				break;
			case GREEN:
				brett.getSpielbrett()[30].getFelder()[getID()]
						.setSpielfigur(spielfigur);
				break;
			}

		}

		/**
		 * löscht eine Spielfigur von dem Startfeld und setzt sie auf das Erste
		 * Spielfeld
		 * 
		 * @param spielfigur
		 */
		public void setPositionNew(Spielfigur spielfigur) {
			switch (farbe) {
			case RED:
				brett.getSpielbrett()[0].getFelder()[spielfigur.getID()]
						.setSpielfigur(null);
				brett.getSpielbrett()[0].getFelder()[0]
						.setSpielfigur(spielfigur);
				System.out.println("habe Spieler verschoben");
				break;
			case BLUE:
				brett.getSpielbrett()[10].getFelder()[getID()]
						.setSpielfigur(spielfigur);
				break;
			case YELLOW:
				brett.getSpielbrett()[20].getFelder()[getID()]
						.setSpielfigur(spielfigur);
				break;
			case GREEN:
				brett.getSpielbrett()[30].getFelder()[getID()]
						.setSpielfigur(spielfigur);
				break;
			}
		}

//		public void setSpielfeldNeu(Spielfigur spielfigur){
//			switch(farbe){
//			case RED:
//				brett.getSpielbrett()[getStandort(spieler)]
//			}
//		}
		
		
		@Override
		public String toString() {
			return "Spielfigur" + "" + getID() + "_" + getName() + "_"
					+ getFarbe();
		}

	}

}
