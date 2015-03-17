package backend;



public class Spieler {

	

		private Spielfigur spielfigur1;
		private Spielfigur spielfigur2;
		private Spielfigur spielfigur3;
		private Spielfigur spielfigur4;
		
		

		private Wuerfel1 würfel;
		private String name;
		private String farbe;
		private int zahl;

		public Spieler(String name, String farbe) {

			this.name = name;
			this.farbe = farbe;
			würfel = new Wuerfel1();
			
			spielfigur1= new Spielfigur(farbe);
			
			if (farbe.equals("blau")) {
				

				

			} else if (farbe.equals("gelb")) {
				Spielfigur.farbe = FarbEnum.RED;

			} else if (farbe.equals("gruen")) {
				Spielfigur.farbe = FarbEnum.GREEN;
			} else if (farbe.equals("rot")) {
				Spielfigur.farbe = FarbEnum.RED;
			}


		}
			
			

		

		public int würfeln() {
			return würfeln();
		}

		public int getPosition(Spielfigur spielfigur) {

			return 0;

		}

		

	}
	
	
	

