package frontend;

import java.io.IOException;



public interface iDatenzugriff {

	
	void speichern() throws IOException;
	
	Object laden();


}
