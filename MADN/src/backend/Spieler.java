package backend;

public class Spieler {

	private Spielfigur[] spielfigur;

	/*private Spielfigur sp1;
	private Spielfigur sp2;
	private Spielfigur sp3;
	private Spielfigur sp4;*/
	private FarbEnum farbe;
	private String name;
	private Spielbrett brett;
	private Regelwerk regel;
	private Wuerfel1 wuerfel;

	public Spieler(String name, String farbe, Spielbrett brett, Regelwerk regel) {
		this.regel = regel;
		setFarbe(farbe);
		this.name = name;
		this.brett = brett;
		wuerfel = new Wuerfel1();

		this.spielfigur = new Spielfigur[4];

		for (int i = 0; i < 4; i++) {
			spielfigur[i] = new Spielfigur(i + 1);
			spielfigur[i].setzeStartPosition(spielfigur[i]);
		}

		
	}


	public Wuerfel1 getWuerfel() {
		return wuerfel;
	}

	/*public Spielfigur getSp1() {
		return sp1;
	}

	public Spielfigur getSp2() {
		return sp2;
	}

	public Spielfigur getSp3() {
		return sp3;
	}

	public Spielfigur getSp4() {
		return sp4;
	}*/

	public FarbEnum getFarbe() {
		return farbe;
	}

	public String getName() {
		return name;
	}

	public Spielbrett getBrett() {
		return brett;
	}

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

	public Regelwerk getRegel() {
		return regel;
	}
	
	
	public Spielfigur getSpielfigur(int i) {

		i = i - 1;

		return spielfigur[i];

	}
	
	
	/*
	 * Hier wollte ich die Position der Spielfigur ausgeben lassen, sie sich auf dem Spielbrett befinden.
	 * 
	 * 
	 * 
 public String getStandort(Spieler spieler){
	 for (int i=0;i< brett.getSpielbrett().length; i++){
		 if(brett.getSpielbrett()[i].equals(spieler.getSpielfigur(1))){
			 return brett.getSpielbrett()[i].toString();
					 
		 }
		 
	 }
	 
	
	 return null;
 }

		// hier wollte ich die Position auf dem Startfeld ausgeben lassen. 

 public String istAufStartfeld(Spieler spieler){
	 for(int i=1; i<=4;i++){
		 if(brett.getSpielbrett()[0].getFelder()[i].equals(spieler.getSpielfigur(1))){
			 return brett.getSpielbrett()[0].getFelder()[i].toString();
	 }
	 }
	 return null;
	 
 }
	
	
	*/
	
	
	
	

	@Override
	public String toString() {
		return getName() + "_" + getFarbe();
	}

	public class Spielfigur {
		private int ID;
		
		public Spielfigur(){
			
		}


		public int getID() {
			return ID;
		}

		public Spielfigur(int ID) {
			this.ID = ID;
		}


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

		
		public void setPositionNew(Spielfigur sp) {
			switch (farbe) {
			case RED:
				brett.getSpielbrett()[0].getFelder()[1].setSpielfigur(null);
				brett.getSpielbrett()[0].getFelder()[0].setSpielfigur(sp);
				System.out.println("habe Spieler verschoben");
				break;
			case BLUE:
				brett.getSpielbrett()[10].getFelder()[getID()]
						.setSpielfigur(sp);
				break;
			case YELLOW:
				brett.getSpielbrett()[20].getFelder()[getID()]
						.setSpielfigur(sp);
				break;
			case GREEN:
				brett.getSpielbrett()[30].getFelder()[getID()]
						.setSpielfigur(sp);
				break;
			}
		}

		
		
		
		

		@Override
		public String toString() {
			return "Spielfigur" + "" + getID() + "_" + getName() + "_"
					+ getFarbe();
		}

	}
	
}



