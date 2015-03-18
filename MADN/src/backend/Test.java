package backend;

public class Test {

	public static void main(String[] args) {
		
		Spielbrett s= new Spielbrett();
		Spieler sp = new Spieler("name1","rot",s);

		System.out.println(s);

	}

}
