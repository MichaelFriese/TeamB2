package backend;

import frontend.iBediener;
import frontend.iDatenzugriff;

public class SpielTestLaden {

	public static void main(String[] args) {
		iBediener s = new Spiel ();
//		s.laden("Supertest2","csv");
		
//		iDatenzugriff speicherSer = new DatenzugriffSerialisiert();
//		s=(Spiel)speicherSer.laden("supertest5");
//		s.zugDurchfuehren(2);
		
		s.laden("CSVFinal", "csv");
	
		
		
		
		
		
	}

}
