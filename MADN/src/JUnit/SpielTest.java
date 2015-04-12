package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.Spiel;

public class SpielTest {
	
	// TODO welcher Spieler ist gerade am Zug

	Spiel s;

	@Before
	public void before() {
		s = new Spiel();
		//s.SpielerHinzufuegen("Meyer", "red");
		//s.SpielerHinzufuegen("Meyer", "blue");
		//s.SpielerHinzufuegen("Meyer", "green");
		//s.SpielerHinzufuegen("Meyer", "yellow");
		s.initSpiel();

	}

	/**
	 * testet, ob ein Spiel Spielbrett, spieler und ein Regelwerk kennt
	 */
	@Test
	public void test0(){
		s.getRegelwerk().rauskommen(s.getSpieler().get(0), s.getSpieler().get(0).getSpielfigur(1));
	}
		

	
	@Test
	public void test() {
		assertNotNull(s.getBrett());
		assertNotNull(s.getSpieler());
		assertNotNull(s.getRegelwerk());
	}

	/**
	 * testet, ob alle Spielfiguren mit der Richtigen Farbe auf den richtigen Startfeldern sitzen
	 */
	@Test
	public void Test2() {
		assertNotNull(s.getBrett().getSpielbrett()[0].getFelder()[1]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[0].getFelder()[2]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[0].getFelder()[3]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[0].getFelder()[4]
				.getSpielfigur());

		assertEquals(
				s.getBrett().getSpielbrett()[0].getFelder()[1].getSpielfigur(),
				s.getSpieler().get(0).getSpielfigur(1));
		
		assertEquals(
				s.getBrett().getSpielbrett()[0].getFelder()[2].getSpielfigur(),
				s.getSpieler().get(0).getSpielfigur(2));
		
		assertEquals(
				s.getBrett().getSpielbrett()[0].getFelder()[3].getSpielfigur(),
				s.getSpieler().get(0).getSpielfigur(3));
		
		assertEquals(
				s.getBrett().getSpielbrett()[0].getFelder()[4].getSpielfigur(),
				s.getSpieler().get(0).getSpielfigur(4));
		
		

		assertNotNull(s.getBrett().getSpielbrett()[10].getFelder()[1]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[10].getFelder()[2]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[10].getFelder()[3]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[10].getFelder()[4]
				.getSpielfigur());

		assertNotNull(s.getBrett().getSpielbrett()[20].getFelder()[1]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[20].getFelder()[2]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[20].getFelder()[3]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[20].getFelder()[4]
				.getSpielfigur());

		assertNotNull(s.getBrett().getSpielbrett()[30].getFelder()[1]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[30].getFelder()[2]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[30].getFelder()[3]
				.getSpielfigur());
		assertNotNull(s.getBrett().getSpielbrett()[30].getFelder()[4]
				.getSpielfigur());

	}

}
