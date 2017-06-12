import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestSpaceship {
	private Spaceship nave;
	
	
	@Before
	public void setUp(){
		nave = new Spaceship(0, 0);
	}
	
	@Test
	public void test_getXGetY() {
		int x,y;
		x = nave.getX();
		y = nave.getY();
		
		assertEquals(0, x);
		assertEquals(0, y);
	}
	
	@Test
	public void test_Score(){
		assertEquals(0, nave.getScore());
		
		Random random = new Random();
		int scoreInt, scoreTotal=0;
		scoreInt = random.nextInt(100);
		scoreTotal+=scoreInt;
		nave.updateScore(scoreInt);
		assertEquals(scoreInt, nave.getScore());

		scoreInt = random.nextInt(100);
		nave.updateScore(scoreInt);
		scoreTotal+=scoreInt;
		scoreInt = random.nextInt(100);
		nave.updateScore(scoreInt);
		scoreTotal+=scoreInt;
		assertEquals(scoreTotal, nave.getScore());
	}
	
	@Test
	public void test_visibility(){
		assertEquals(true, nave.isVisible());
		
		nave.setVisible(false);
		assertEquals(false, nave.isVisible());
	}

}
