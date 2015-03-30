package frontend;
import backend.Spiel;

public interface iBediener {
	
	/**
	 * Methode um einen Spieler hinzuzufuegen
	 * @param name des Spielers 
	 * @param farbe der gewaehlten Spilfigur 
	 */
	public void SpielerHinzufuegen(String name, String farbe);
	
	/**
	 * Methode um das Spiel zu initialisieren 
	 */
	public void initSpiel();
	
//	public void zugDurchfuehren(int ID);
}
