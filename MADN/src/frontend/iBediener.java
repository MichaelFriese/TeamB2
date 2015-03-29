package frontend;
import backend.Spiel;

public interface iBediener {
	
	public void SpielerHinzufügen(String name, String farbe);
	public void initSpiel();
//	public void zugDurchfuehren(int ID);
}
