import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSetCurrentSpeed {
	
	Locomotive loco;

	@Before
	public void setUp() throws Exception {
		loco = new Locomotive(EngineStates.RUNNING, 78, 25);
	}

	@Test
	public void testRight() throws Exception {
		int expectedSpeed = 123;
		loco.setCurrentSpeed(expectedSpeed);
		assertEquals("Right test for setCurrentSpeed", expectedSpeed, loco.getCurrentSpeed(), 0.0001);
	}
	
	@Test(expected = Exception.class)
	public void testException() throws Exception {
		loco.setCurrentSpeed(-15);
		fail("Failed to throw exception on incorrect value for setCurrentSpeed");
	}
	
	@Test
	public void testBoundary() throws Exception {
		int expectedSpeed = 150;
		loco.setCurrentSpeed(expectedSpeed);
		assertEquals("Boundary test for setCurrentSpeed", expectedSpeed, loco.getCurrentSpeed(), 0.0001);
	}
	
	@Test
	public void testPerformance() throws Exception {
		float start = System.currentTimeMillis();
		loco.setCurrentSpeed(23);
		float end = System.currentTimeMillis();
		assertTrue("Performance test for setCurrentSpeed", start - end < 0.0000001);
	}

}
