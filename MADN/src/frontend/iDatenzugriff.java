package frontend;

import java.io.IOException;



public interface iDatenzugriff {

	
	void speichern(String dateiname, Object o) throws IOException;
	
	Object laden(String dateiname);


}
