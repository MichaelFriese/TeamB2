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
	private Spieler spieler;
	private String dateiname;

//	public DatenzugriffCSV() {
//		this.spiel = spiel;
//		setDateiname(dateiname);
//	}

	public void setDateiname(String dateiname){
		this.dateiname=dateiname;
	}
	@Override
	public void speichern(String dateiname,Object o) throws IOException {
		
		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new FileWriter(dateiname+".csv"));
			
			String s = null;
			try{
				s = (String)o;
			}catch(Exception e){
				System.err.println("Kein String �bergeben");
			}
			pw.write(s);
			pw.flush();
			pw.close();

		} catch (NullPointerException e) {
			throw new IOException("UNerwartetes Dateiende");
		} catch (NumberFormatException e) {
			throw new IOException("Falsches Elementformat ");
		} catch (IndexOutOfBoundsException e) {
			throw new IOException("zu wenig Datenelemente");
		}
	}
	
	
	@Override
	public Object laden(String dateiname) {
		BufferedReader reader = null; 
		try{
			reader = new BufferedReader(new FileReader(dateiname+".csv"));
			String s = reader.readLine();
			String erg = "";
			while ( s != null){
				erg += s+"\n";
				s= reader.readLine();
			} return erg;
			
//			Spieler s = new Spieler (reader);
//
//			spiel.setAmZug(s);
//			System.out.println(spiel.getSpieler().toString());
//			spiel.getSpieler().clear();
//			spiel.addSpieler(s);
//			System.out.println(s);
//			System.out.println(spiel.getSpieler().toString());
		}
		catch (Exception e ){
			e.printStackTrace();
		}
		return null;
		}
}