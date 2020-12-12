import static org.junit.Assert.*;

import org.junit.Test;

public class TestConstructor {
	
	Locomotive loco;
	
	@Test
	public void testRight() throws Exception {
		int expectedTrip = 78;
		int expectedSpeed = 25;
		loco = new Locomotive(EngineStates.RUNNING, expectedTrip, expectedSpeed);
		assertEquals("Test correct assignment of kmSinceDeparture", expectedTrip, loco.getTripKm(), 0.0001);
		assertEquals("Test correct assignment of currentSpeed", expectedSpeed, loco.getCurrentSpeed(), 0.0001);
	}
	
	@Test(expected = Exception.class)
	public void testException() throws Exception {
		loco = new Locomotive(EngineStates.RUNNING, 78, 225);
		fail("Failed to throw exception on incorrect value for constructor");
	}
	
	@Test
	public void testBoundary() throws Exception {
		int expectedTrip = 78;
		int expectedSpeed = 0;
		loco = new Locomotive(EngineStates.STARTING, expectedTrip, expectedSpeed);
		assertEquals("Test correct assignment of kmSinceDeparture", expectedTrip, loco.getTripKm(), 0.0001);
		assertEquals("Test correct assignment of currentSpeed", expectedSpeed, loco.getCurrentSpeed(), 0.0001);
	}
	
}
