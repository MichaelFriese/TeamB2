package JUnit;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import backend.Wuerfel;

public class wuerfelTest {

	Wuerfel w;
	
	@Before
	public  void before(){
		 w= new Wuerfel();
	
	}
	@Test
	public void test() {
	
		assertTrue(w.wuerfel() >= 1 && w.wuerfel()<= 6 );
	
	}
}
