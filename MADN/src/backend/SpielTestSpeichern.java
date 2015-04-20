package backend;

import java.io.IOException;

import frontend.iBediener;

public class SpielTestSpeichern {

	private DatenzugriffSerialisiert speichern;
	
	public static void main(String[] args) throws IOException {
		
		iBediener s = new Spiel ();
//		s.SpielerHinzufuegen("Ki", "red", "aggressiv");
//		s.SpielerHinzufuegen("Ki2", "Blue", "defensiv");
		s.SpielerHinzufuegen("Rosa", "red",null);
		
		s.SpielerHinzufuegen("Helmut", "blue",null);
		s.SpielerHinzufuegen("Reiner", "Green",null);
		s.SpielerHinzufuegen("Ole", "Yellow",null);
		s.initSpiel();
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
		
		
		
//		s.initTestSpiel();
//		s.initTestSpielZugDefensiv();
//		s.initTestSpielZugAggressiv();

		
		//DatenzugriffSerialisiert speichernSerialisiert = new DatenzugriffSerialisiert((Spiel) s);
		//speichernSerialisiert.speichern();
		
		DatenzugriffCSV speichernCSV = new DatenzugriffCSV ((Spiel) s,"Versuch4");
		speichernCSV.speichern();
		DatenzugriffCSV ladenCSV = new DatenzugriffCSV((Spiel)s,"Versuch4");
		ladenCSV.laden();
//		s.zugDurchfuehren(2);
//		s.zugDurchfuehren(1);
		
		
//		speichernCSV.speichern();
		
		
		

	}

}
