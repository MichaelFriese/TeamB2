package backend;

public class GameManager {

	public static void main(String[] args) {
		
		Spielbrett brett = new Spielbrett();
		
		Spieler Michael = new Spieler("Michael","red", brett );
		Spieler Dörte = new Spieler("Dörte","blue", brett );
		Spieler Judith = new Spieler("Judith","yellow", brett );
		Spieler Tobi = new Spieler("Tobi","green", brett );
		
		System.out.println("Michael");
		System.out.println(brett);
		

	}

}
