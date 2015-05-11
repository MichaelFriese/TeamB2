package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;

import backend.Spiel;

import com.itextpdf.text.DocumentException;




public interface iDatenzugriff {

	
	void speichern(String dateiname, String dateiende, Object o) throws IOException;
	
	Object laden(String dateiname);

	 void spielfeld(Spiel spiel) throws FileNotFoundException, DocumentException;
	
	

}
