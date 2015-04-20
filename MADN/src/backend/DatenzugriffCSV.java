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
	public void speichern() throws IOException {
		
		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new FileWriter("test.csv"));
			
			String s = " ";
			
			

			for (int i = 0; i < spiel.getBrett().getSpielbrett().length; i++) {
				switch (i) {
				case 0:
					for (int j = 0; j <= 4; j++) {
						s += spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 10:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 20:

					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 30:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 40:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 39:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
					
				case 9:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 19:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;
				case 29:
					for (int j = 0; j <= 4; j++) {
						s+= spiel.getBrett().getSpielbrett()[i].getFelder()[j]
								.toString();
					}
					break;

				default:
					s+= spiel.getBrett().getSpielbrett()[i].getFelder()[0]
							.toString();
					break;
				}
				
			}
			pw.println(s);
			
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
	public Object laden() {
		
		BufferedReader reader = null;
//		BufferedReader reader = null;
//		String line= reader.readLine();
//		String [] fields= line.split("_");
		
		//spiel.getBrett().getSpielbrett()[1].gfields[0];
		try{
			try {
				reader= new BufferedReader(new FileReader("Test.csv"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		String erg="";
			try {
				
				String s=reader.readLine();
				
				while (s!=null){
				erg+=s;
				s=reader.readLine();
				}
				return erg;
				
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
		return null;
	}
	
}
