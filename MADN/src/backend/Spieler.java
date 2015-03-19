package backend;



public class Spieler {

		private Spielfigur[] spielfigur;
	
		private Spielfigur sp1;
		private Spielfigur sp2;
		private Spielfigur sp3;
		private Spielfigur sp4;
		private FarbEnum farbe;
		private String name;
		private Spielbrett brett;
		private Regelwerk regel;
		private Wuerfel1 wuerfel;
		

		public Spieler(String name, String farbe, Spielbrett brett, Regelwerk regel) {
			this.regel=regel;
			setFarbe(farbe);
			this.name = name;
			this.brett = brett;
			wuerfel= new Wuerfel1();
			
			this.spielfigur = new Spielfigur[4];
			
			for(int i=0; i<4; i++ ){
				spielfigur[i]= new Spielfigur(i + 1);
				spielfigur[i].setStartPosition(spielfigur[i]);
			}
			
			/*sp1 = new Spielfigur(1);
			sp2 = new Spielfigur(2);
			sp3 = new Spielfigur(3);
			sp4 = new Spielfigur(4);*/
			
			/*sp1.setStartPosition(sp1);
			sp2.setStartPosition(sp2);
			sp3.setStartPosition(sp3);
			sp4.setStartPosition(sp4);*/
		}
		
		
	
		public Spielfigur getSpielfigur(){
	
			for (int i=0; i<spielfigur.length; i++){
				System.out.println(spielfigur[i].getID());
				if (spielfigur[i].getID() == brett.getSpielbrett()[0].getFelder()[1].getSpielfigur().getID()) {
					System.out.println(spielfigur[i].getID() + " " + this.farbe);
					return spielfigur[i];
				}
			}
			return null;
		}
		public Wuerfel1 getWuerfel(){
			return wuerfel;
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
		
		public Spielbrett getBrett(){
			return brett;
		}

		private void setFarbe(String farbe){
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
		
		
		public Regelwerk getRegel(){
			return regel;
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
			public void setPositionNew(Spielfigur sp){
				switch(farbe){
				case RED:
					brett.getSpielbrett()[0].getFelder()[1].setSpielfigur(null);
					brett.getSpielbrett()[0].getFelder()[0].setSpielfigur(sp);
					System.out.println("habe Spieler verschoben");
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
	
	
	

