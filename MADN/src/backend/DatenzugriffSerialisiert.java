package backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Test.Syso;
import Test.syso2;
import frontend.iDatenzugriff;

public class DatenzugriffSerialisiert implements iDatenzugriff {

	private Spiel spiel;

	public DatenzugriffSerialisiert(Spiel spiel) {
		this.spiel = spiel;
	}

	@Override
	public void speichern() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("out.ser"));
			oos.writeObject(spiel);
		} catch (FileNotFoundException e) {
			System.err.println("konnte 'out.ser' nicht erzeugen");
		} catch (IOException e) {
			System.err.println("Fehler bei der Ein-/Ausgabe" + e);

		} finally {
			try {
				oos.close();
			} catch (Exception e) {
				System.err.println("Fehler beim Schließen der Datei");
			}
		}
	}

	public void laden() {

	}

}
