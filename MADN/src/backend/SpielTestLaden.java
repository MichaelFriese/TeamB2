package backend;

import frontend.iBediener;

public class SpielTestLaden {

	public static void main(String[] args) {
		iBediener s = new Spiel ();
		s.SpielerHinzufuegen("Ki", "red", "aggressiv");
//		s.SpielerHinzufuegen("Ki2", "Blue", "defensiv");
//		s.SpielerHinzufuegen("Rosa", "red",null);
//		s.SpielerHinzufuegen("Helmut", "blue",null);
		s.SpielerHinzufuegen("Reiner", "Green",null);
//		s.SpielerHinzufuegen("Ole", "Yellow",null);
//		s.initSpiel();
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehrenSchmeissenTest(1);
//		s.zugDurchfuehrenEndfeldTest(1);
		
		
		
		s.initTestSpiel();
//		s.initTestSpielZugDefensiv();
//		s.initTestSpielZugAggressiv();

		
//		DatenzugriffSerialisiert ladenTest = new DatenzugriffSerialisiert((Spiel) s);
//		System.out.println("Spielstand geladen");
//		ladenTest.laden();
//		s.zugDurchfuehren(2);
//		
		DatenzugriffCSV ladenCSV = new DatenzugriffCSV((Spiel)s, "Versuch3");
		ladenCSV.laden();
		
		s.zugDurchfuehren(3);
		
		
	}

}
