package au.com.afl.chidlren.game.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * In order to perform the circulate children game
 * As the game coordinator I like to able to
 * access to the CirculateArray object.
 */
public class CirculateArrayTest {

	private CirculateArray testInstance;
	
	@Before
	public void setUp() {
		this.testInstance = new CirculateArray(6);
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	/**
	 * Given the user can access to the class
	 * When the constructor called
	 * Then the CirculateArray object should be return
	 */
	@Test
	public void whenTheConstructorCalledThenObjectShouldReturn() {
		//Given the user can access the the class
		//When the constructor called
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
	
	/**
	 * Given a negative number
	 * When the remove method called
	 * Then an illegalArgumentException should be raised
	 */
	@Test
	public void whenTheNegativeNumberProvidedWithRemoveMethodThenExceptionRaised() {
		//Given a negative number
		int size = -1;
		//When the remove method called
		try { 
			this.testInstance.remove(size);
			fail("Program reached unexpected point!");
		}
		catch (IllegalArgumentException iae) {
			//Then the exception should raised
			String message = iae.getMessage();
			assertNotNull(message);
			assertEquals("Illegal index argument: -1, must be greater than zero!", message);
		}
	}
	
	/**
	 * Given a positive number
	 * When the remove method called
	 * Then the integer has been remove from the array
	 */
	@Test
	public void whenAPositiveIndexProvidedThenAnIntegerShouldReturn() {
		//Given a positive number
		int index = 3;
		//When the remove method called
		Optional<Integer> integer = this.testInstance.remove(index);
		//Then the integer should remove from array
		assertNotNull(integer);
		assertTrue(integer.isPresent());
		assertTrue(3 == integer.get());
	}
	
	/**
	 * Given a positive number greater then the size
	 * When the remove method called
	 * Then the integer has been remove from the start of array
	 */
	@Test
	public void whenAPositiveIndexGTSizeProvidedThenAnIntegerShouldReturn() {
		//Given a 7
		int index = 7;
		//When the remove method called
		Optional<Integer> integer = this.testInstance.remove(index);
		//Then the integer should remove from array
		assertNotNull(integer);
		assertTrue(integer.isPresent());
		assertTrue(1 == integer.get());
	}
	
	/**
	 * Given a positive number 8
	 * When the remove method called
	 * Then the 2 has been remove from the start of array
	 */
	@Test
	public void whenAPositive2ProvidedThenAnIntegerShouldReturn() {
		//Given a 8
		int index = 8;
		//When the remove method called
		Optional<Integer> integer = this.testInstance.remove(index);
		//Then the integer should remove from array
		assertNotNull(integer);
		assertTrue(integer.isPresent());
		assertTrue(2 == integer.get());
	}
	
	/**
	 * Given 2 positive number 
	 * When the remove method called
	 * Then the 2 integers has been remove from the start of array
	 */
	@Test
	public void when2IndexProvidedThenAnIntegerShouldReturn() {
		//Given a 3
		int index = 3;
		//When the remove method called
		Optional<Integer> integer = this.testInstance.remove(index);
		//Then the integer should remove from array
		assertNotNull(integer);
		assertTrue(integer.isPresent());
		assertTrue(3 == integer.get());
		index = 8;
		Optional<Integer> integer2 = this.testInstance.remove(index);
		assertNotNull(integer2);
		assertTrue(integer2.isPresent());
		assertTrue(4 == integer2.get());
	}
}
