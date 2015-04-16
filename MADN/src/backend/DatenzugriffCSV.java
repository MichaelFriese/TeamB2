package backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import frontend.iDatenzugriff;

public class DatenzugriffCSV implements iDatenzugriff {

	private Spiel spiel;

	public DatenzugriffCSV(Spiel spiel) {
		this.spiel = spiel;
	}

	@Override
	public void speichern() {
		PrintWriter pw = null;
		try{
	
		pw = new PrintWriter ( new FileWriter("test.txt"));
		pw.print(spiel.toString());
		pw.flush();
		}
		catch(Exception e){
			System.err.println("Konnte Datei nicht erstellen");
		}
	}

	@Override
	public void laden() {
		
		BufferedReader reader = null;
		try{
			try {
				reader= new BufferedReader(new FileReader("Test.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String s;
			try {
				System.out.println("Spiel geladen");
				s = reader.readLine();
				while (s!=null){
				System.out.println(s);
				s=reader.readLine();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
