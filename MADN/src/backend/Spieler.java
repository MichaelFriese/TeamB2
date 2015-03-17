package backend;



public class Spieler {

	

		private Spielfigur spielfigur1;
		private Spielfigur spielfigur2;
		private Spielfigur spielfigur3;
		private Spielfigur spielfigur4;
		
		

		private Wuerfel1 wuerfel;
		private String name;
		private String farbe;
		private int zahl;

		public Spieler(String name, String farbe) {

			this.name = name;
			this.farbe = farbe;
			wuerfel = new Wuerfel1();
			
			spielfigur1= new Spielfigur(farbe);
			
			if (farbe.equals("blau")) {
//				spielfigur1.setSpielfigur(position);
//				spielfigur2.setSpielfigur(position+1);
//				spielfigur3.setSpielfigur(position+2);
//				spielfigur4.setSpielfigur(position+3);

			} else if (farbe.equals("gelb")) {
				Spielfigur.farbe = FarbEnum.RED;

			} else if (farbe.equals("gruen")) {
				Spielfigur.farbe = FarbEnum.GREEN;
			} else if (farbe.equals("rot")) {
				Spielfigur.farbe = FarbEnum.RED;
			}


		}
			
			

		

		public int wuerfeln() {
			return wuerfeln();
		}

		public int getPosition(Spielfigur spielfigur) {

			return 0;

		}

		

	}
	
	
	

