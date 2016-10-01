package au.com.afl.chidlren.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;

/**
 * In order to perform the circulate children game
 * As the game coordinator I like to able to
 * Construct the children in a circle and remove 
 * they accordingly.
 */
public class ChildrenGamesTest {

	/**
	 * Given the number of children and counter
	 * When the constructor called
	 * Then the ChildrenGames object should return
	 */
	@Test
	public void whenNumberOfChildrenAndCounterProvidedThenGameObjectShouldReturn() {
		//Given the number of children and counter
		int numberOfChild = 20;
		int counter = 6;
		//When the constructor called
		ChildrenGames game =  new ChildrenGames(numberOfChild, counter);
		//Then the ChildrenGames object should return
		assertNotNull(game);
	}
	
	/**
	 * Given an invalid number of children and counter
	 * When the constructor called
	 * Then the exception should raised
	 */
	@Test
	public void whenTheInvalidNumberOfChildrenAndCounterProvidedThenExceptionShouldRaise() {
		//Given the number of children and counter
		int numberOfChild = -20;
		int counter = -6;
		//When the constructor called
		try {
			new ChildrenGames(numberOfChild, counter);
			fail("Program reached unexpected point");
		}
		catch (IllegalArgumentException iae) {
			//Then the exception should raised
			String message = iae.getMessage();
			assertNotNull(message);
			assertEquals("numberOfChild should be greater then zero!", message);
		}
	}
	
	/**
	 * Given an invalid counter
	 * When the constructor called
	 * Then the exception should raised
	 */
	@Test
	public void whenTheInvalidCounterProvidedThenExceptionShouldRaise() {
		//Given the number of children and counter
		int numberOfChild = 20;
		int counter = -6;
		//When the constructor called
		try {
			new ChildrenGames(numberOfChild, counter);
			fail("Program reached unexpected point");
		}
		catch (IllegalArgumentException iae) {
			//Then the exception should raised
			String message = iae.getMessage();
			assertNotNull(message);
			assertEquals("counter should be greater then zero!", message);
		}
	}
	
	/**
	 * Given a counter greater then numberOfChild
	 * When the constructor called
	 * Then the exception should raised
	 */
	@Test
	public void whenTheCounterGTNumberOfChildProvidedThenExceptionShouldRaise() {
		//Given the number of children and counter
		int numberOfChild = 2;
		int counter = 6;
		//When the constructor called
		try {
			new ChildrenGames(numberOfChild, counter);
			fail("Program reached unexpected point");
		}
		catch (IllegalArgumentException iae) {
			//Then the exception should raised
			String message = iae.getMessage();
			assertNotNull(message);
			assertEquals("counter should be less then numberOfChild!", message);
		}
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(3, 1);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(3 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(1), i.next());
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(3), i.next());
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideWith6ThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(6, 1);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(6 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(1), i.next());
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(3), i.next());
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideWithCount2ThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(3, 2);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(3 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(1), i.next());
		assertEquals(new Integer(3), i.next());
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideWith6Count2ThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(6, 2);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(6 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(4), i.next());
		assertEquals(new Integer(6), i.next());
		assertEquals(new Integer(3), i.next());
		assertEquals(new Integer(1), i.next());
		assertEquals(new Integer(5), i.next());
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideWith6Count3ThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(6, 3);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(6 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(3), i.next());
		assertEquals(new Integer(6), i.next());
		assertEquals(new Integer(4), i.next());
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(5), i.next());
		assertEquals(new Integer(1), i.next());
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideWith6Count5ThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(6, 5);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(6 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(5), i.next());
		assertEquals(new Integer(4), i.next());
		assertEquals(new Integer(6), i.next());
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(3), i.next());
		assertEquals(new Integer(1), i.next());
	}
	
	/**
	 * Given a game object
	 * When the play method called
	 * Then the sequence of child go out should return
	 */
	@Test
	public void whenTheGameObjectProvideWith10Count7ThenTheSequenceReturn() {
		//Given the game object
		ChildrenGames game = new ChildrenGames(10, 7);
		//When the play method called
		List<Integer> sequence = game.play();
		//Then the sequence of child go out return
		assertNotNull(sequence);
		assertTrue(10 == sequence.size());
		Iterator<Integer> i = sequence.iterator();
		assertEquals(new Integer(7), i.next());
		assertEquals(new Integer(4), i.next());
		assertEquals(new Integer(2), i.next());
		assertEquals(new Integer(1), i.next());
		assertEquals(new Integer(3), i.next());
		assertEquals(new Integer(6), i.next());
		assertEquals(new Integer(10), i.next());
		assertEquals(new Integer(5), i.next());
		assertEquals(new Integer(8), i.next());
		assertEquals(new Integer(9), i.next());
	}
	
	/**
	 * Given the null argv
	 * When the main called
	 * Then default parameters use to play game
	 * @throws Exception 
	 */
	@Test
	public void whenNullArgvProvidedThenDefaultParamsUsedToPlay() throws Exception {
		//Given the null argv
		String[] argv = null;
//		ChildrenGames mockGame = PowerMockito.mock(ChildrenGames.class);
//		PowerMockito.whenNew(ChildrenGames.class).withAnyArguments().thenReturn(mockGame);
		//When the main method called
		ChildrenGames.main(argv);
		//Then default parameter use to play game
//		ArgumentCaptor<Integer> noOfChild = ArgumentCaptor.forClass(Integer.class);
//		ArgumentCaptor<Integer> count = ArgumentCaptor.forClass(Integer.class);
//		PowerMockito.verifyNew(ChildrenGames.class).withArguments(noOfChild.capture(), count.capture());
//		assertEquals(new Integer(6), noOfChild.getValue());
//		assertEquals(new Integer(2), count.getValue());
	}
	
	/**
	 * Given the empty argv
	 * When the main called
	 * Then default parameters use to play game
	 */
	@Test
	public void whenEmptyArgvProvidedThenDefaultParamsUsedToPlay() {
		//Given the empty argv
		String[] argv = {};
		//When the main method called
		ChildrenGames.main(argv);
		//Then default parameter use to play game
	}
	
	/**
	 * Given a 2 elements argv
	 * When the main called
	 * Then new parameters use to play game
	 */
	@Test
	public void when2ElementArgvProvidedThenNewParamUsedToPlay() {
		//Given the 2 elements argv
		String[] argv = {"7", "1"};
		//When the main method called
		ChildrenGames.main(argv);
		//Then new parameter use to play game
	}
	
	/**
	 * Given a 2 element argv with 1 invalid
	 * When the main called
	 * Then usage display
	 */
	@Test
	public void when2ElementArgvBProvidedThenNewParamUsedToPlay() {
		//Given the invalid argv
		String[] argv = {"7", "a"};
		//When the main method called
		ChildrenGames.main(argv);
		//Then usage display
	}
}
