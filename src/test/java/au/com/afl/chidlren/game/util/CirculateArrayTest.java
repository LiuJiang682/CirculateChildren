package au.com.afl.chidlren.game.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * In order to perform the circulate children game
 * As the game coordinator I like to able to
 * access to the CirculateArray object.
 */
public class CirculateArrayTest {

	/**
	 * Given the user can access to the class
	 * When the constructor called
	 * Then the CirculateArray object should be return
	 */
	@Test
	public void whenTheConstructorCalledThenObjectShouldReturn() {
		//Given the user can access the the class
		//When the constructor called
		CirculateArray testInstance = new CirculateArray(6);
		//Then the object should return
		assertNotNull(testInstance);
	}
	
	/**
	 * Given a negative number
	 * When the constructor called
	 * Then an illegalArgumentException should be raised
	 */
	@Test
	public void whenTheNegativeNumberProvidedThenExceptionRaised() {
		//Given a negative number
		int size = -1;
		//When the constructor called
		try { 
			new CirculateArray(size);
			fail("Program reached unexpected point!");
		}
		catch (IllegalArgumentException iae) {
			//Then the exception should raised
			String message = iae.getMessage();
			assertNotNull(message);
			assertEquals("Illegal size argument: -1, must be greater than zero!", message);
		}
	}
	
	/**
	 * Given a zero
	 * When the constructor called
	 * Then an illegalArgumentException should be raised
	 */
	@Test
	public void whenTheZeroProvidedThenExceptionRaised() {
		//Given a zero
		int size = 0;
		//When the constructor called
		try { 
			new CirculateArray(size);
			fail("Program reached unexpected point!");
		}
		catch (IllegalArgumentException iae) {
			//Then the exception should raised
			String message = iae.getMessage();
			assertNotNull(message);
			assertEquals("Illegal size argument: 0, must be greater than zero!", message);
		}
	}
}
