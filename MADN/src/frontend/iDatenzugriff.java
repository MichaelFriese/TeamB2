package frontend;

import java.io.IOException;



public interface iDatenzugriff {

	
	void speichern(Object o) throws IOException;
	
	Object laden();


}
