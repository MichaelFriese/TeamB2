package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import Test.Syso;
import Test.syso2;
import frontend.iBediener;
import frontend.iDatenzugriff;

public class DatenzugriffSerialisiert implements iDatenzugriff {

	private Spiel spiel;

	public DatenzugriffSerialisiert(Spiel spiel) {
		this.spiel = spiel;
	}

	@Override
	public void speichern(Object o) {
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
				System.err.println("Fehler beim Schliessen der Datei");
			}
		}
	}
	
	
	
	@Override
	public Object laden() {
		Object s=null;
		ObjectInputStream ois = null;
		try{
			ois = new ObjectInputStream ( new FileInputStream ("out.ser"));
		
			try {
				s = ois.readObject();
				return s;
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("konnte 'out.ser' nicht finden");
		} catch (IOException e) {
			System.err.println("Fehler bei der Ein-/Ausgabe" + e);

		} finally {
			try {
				ois.close();
			} catch (Exception e) {
				System.err.println("Fehler beim Schliessen der Datei");
			}
		}
		return null;
	}


		
	}

	

