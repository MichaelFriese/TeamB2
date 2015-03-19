package backend;

public class GameManager {

	public static void main(String[] args) {
		
		Spielbrett brett = new Spielbrett();
		Regelwerk regel= new Regelwerk();
		
		
		
		Spieler Michael = new Spieler("Michael","red", brett, regel );
		//Spieler Doerte = new Spieler("D�rte","blue", brett );
		//Spieler Judith = new Spieler("Judith","yellow", brett );
		//Spieler Tobi = new Spieler("Tobi","green", brett );
		
		System.out.println("Michael");
		System.out.println(brett);
		Michael.getRegel().spielzug(Michael);
		System.out.println(brett);
		

	}

}
