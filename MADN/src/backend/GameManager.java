package backend;

public class GameManager {

	public static void main(String[] args) {
		
		Spielbrett brett = new Spielbrett();
		Regelwerk regel= new Regelwerk();
		
		
		
		Spieler Michael = new Spieler("Michael","red", brett, regel );
		
		//Spieler Doerte = new Spieler("Doerte","blue", brett );
		//Spieler Judith = new Spieler("Judith","yellow", brett );
		//Spieler Tobi = new Spieler("Tobi","green", brett );
		
		
		System.out.println(brett);
		System.out.println(Michael.getSpielfigur(1));
		//System.out.println(Michael.istAufStartfeld(Michael));

	}

}
