import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class TestAlien {
	private Alien alien1, alien2;
	
	@Before
	public void setUp(){
		alien1 = new Alien(0, 0);
		alien2 = new Alien(0, 0, "image/alien_EASY");
	}

	@Test
	public void test_alienBounds() {
		Rectangle alien1B, alien2B;
		alien1B = alien1.getBounds();
		alien2B = alien2.getBounds();
		
		assertEquals(alien1B, alien2B);
	}
	
	@Test
	public void test_alienSpeed(){
		assertEquals(alien1.getY(), alien2.getY());
		alien1.update();
		assertNotEquals(alien1.getY(), alien2.getY());
	}

}
