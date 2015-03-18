package backend;



public class Spieler {

		private Spielfigur sp1;
		private Spielfigur sp2;
		private Spielfigur sp3;
		private Spielfigur sp4;
		private FarbEnum farbe;
		private String name;
		private Spielbrett brett;
		

		public Spieler(String name, String farbe, Spielbrett brett) {
			setFarbe(farbe);
			this.name = name;
			this.brett = brett;
			sp1 = new Spielfigur(1);
			sp2 = new Spielfigur(2);
			sp3 = new Spielfigur(3);
			sp4 = new Spielfigur(4);
			sp1.setStartPosition(sp1);
			sp2.setStartPosition(sp2);
			sp3.setStartPosition(sp3);
			sp4.setStartPosition(sp4);
		}
		
		public Spielfigur getSp1() {
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
		}

		public FarbEnum getFarbe() {
			return farbe;
		}

		public String getName() {
			return name;
		}

		private void setFarbe(String farbe){
			if (farbe.equals("blau")) {
				this.farbe = FarbEnum.BLUE;
			} else if (farbe.equals("gelb")) {
				this.farbe = FarbEnum.YELLOW;
			} else if (farbe.equals("grün")) {
				this.farbe = FarbEnum.GREEN;
			} else if (farbe.equals("rot")) {
				this.farbe = FarbEnum.RED;
			}
		}
		
		@Override
		public String toString(){
			return getName()+"_"+getFarbe();
		}
		
		
		public class Spielfigur{
			private int ID;
			
			
			public Spielfigur(){
				
			}
			
			public int getID() {
				return ID;
			}

			public Spielfigur(int ID){
				this.ID = ID;
			}
			
			public void setStartPosition(Spielfigur sp){
				switch(farbe){
				case RED:
					brett.getSpielbrett()[0].getFelder()[getID()].setSpielfigur(sp);
					break;
				case BLUE:
					brett.getSpielbrett()[10].getFelder()[getID()].setSpielfigur(sp);
					break;
				case YELLOW:
					brett.getSpielbrett()[20].getFelder()[getID()].setSpielfigur(sp);
					break;
				case GREEN:
					brett.getSpielbrett()[30].getFelder()[getID()].setSpielfigur(sp);
					break;
				}
				
				
			}
			
//			public Spielfeld getPosition() {
//				return position;
//			}
//
//			public void setPosition(Spielfeld position) {
//				this.position = position;
//			}

			@Override
			public String toString(){
				return "Spielfigur"+""+getID()+"_"+getName()+"_"+getFarbe();
			}

		}
		

}
	
	
	

