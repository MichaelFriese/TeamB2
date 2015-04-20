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

	public DatenzugriffCSV(Spiel spiel, String dateiname) {
		this.spiel = spiel;
		setDateiname(dateiname);
	}

	public void setDateiname(String dateiname){
		this.dateiname=dateiname;
	}
	@Override
	public void speichern() throws IOException {
		
		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new FileWriter(this.dateiname+".csv"));
			
			String s = "";
			
			
			

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
			System.out.println(spiel.getAmZug());
			for(int i=0;i<spiel.getSpieler().size();i++){
			pw.println(	spiel.getSpieler().get(i));
			}
			pw.println(spiel.getAmZug()+"\n" + s);
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
		try{
			reader = new BufferedReader(new FileReader(dateiname+".csv"));
			Spieler s = new Spieler (reader);

//			spiel.setAmZug(s);
			System.out.println(spiel.getSpieler().toString());
			spiel.getSpieler().clear();
			spiel.addSpieler(s);
//			System.out.println(s);
			System.out.println(spiel.getSpieler().toString());
		}
		catch (Exception e ){
			e.printStackTrace();
		}
		return null;
		}
}