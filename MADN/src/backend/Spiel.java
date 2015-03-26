package backend;

import frontend.iBediener;

public class Spiel implements iBediener {
	private Spielbrett brett;
	private Spieler[] spieler = new Spieler[4];
	private Spieler amZug;
	
	public Spiel(Spielbrett brett, Spieler sp) {
		this.brett = brett;
		this.spieler[0] = sp;
	}
	
	public Spiel(Spielbrett brett, Spieler sp1, Spieler sp2) {
		this.brett = brett;
		this.spieler[0] = sp1;
		this.spieler[1] = sp2;
	}
	
	public Spiel(Spielbrett brett, Spieler sp1, Spieler sp2, Spieler sp3) {
		this.brett = brett;
		this.spieler[0] = sp1;
		this.spieler[1] = sp2;
		this.spieler[2] = sp3;
	}
	
	public Spiel(Spielbrett brett, Spieler sp1, Spieler sp2, Spieler sp3, Spieler sp4) {
		this.brett = brett;
		this.spieler[0] = sp1;
		this.spieler[1] = sp2;
		this.spieler[2] = sp3;
		this.spieler[3] = sp4;
	}

	public Spielbrett getBrett() {
		return brett;
	}

	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}

	public Spieler[] getSpieler() {
		return spieler;
	}

	public void setSpieler(Spieler[] spieler) {
		this.spieler = spieler;
	}

	public Spieler getAmZug() {
		
		return amZug;
	}

	public void setAmZug(Spieler amZug) {
		this.amZug = amZug;
	}
	

	
}
