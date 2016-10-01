package au.com.afl.chidlren.game;

import java.util.ArrayList;
import java.util.List;

import au.com.afl.chidlren.game.constants.Constants.Numeric;
import au.com.afl.chidlren.game.util.CirculateArray;

public class ChildrenGames {

	private static final int CORRECT_PARAMS_LENGTH = 2;
	private static final int DEFAULT_COUNT = 2;
	private static final int DEFAULT_NO_CHILDREN = 6;
	private int numberOfChild;
	private int counter;
	private CirculateArray childrens;
	
	public ChildrenGames(int numberOfChild, int counter) {
		if (numberOfChild < Numeric.ZERO) {
			throw new IllegalArgumentException("numberOfChild should be greater then zero!");
		}
		if (counter < Numeric.ZERO) {
			throw new IllegalArgumentException("counter should be greater then zero!");
		}
		if (numberOfChild < counter) {
			throw new IllegalArgumentException("counter should be less then numberOfChild!");
		}
		this.numberOfChild = numberOfChild;
		this.counter = counter;
		this.childrens = new CirculateArray(this.numberOfChild);
	}

	public List<Integer> play() {
		List<Integer> childIds = new ArrayList<>(this.numberOfChild);
		int position = Numeric.ZERO;
		boolean isFirst = true;
		int length = numberOfChild - Numeric.ONE;
		for (int index = 0; index < length; index++) {
			if (Numeric.ONE == counter) {
				//If the counter is one, just return the first element.
				position = Numeric.ZERO;
			}
			else {
				position = position + counter;
				if (isFirst) {
					//Due to it is first loop, the position is
					//on first element, it requires the position
					//moves forward fully. 
					isFirst = false;
				}
				else {
					//Because the previous round already remove
					//one element, the position is on the new
					//element, thus, it only requires the position
					//moves forward less one.
					--position;
				}
			}

			Integer[] removedAndPos = this.childrens.remove(position).get();
			childIds.add(removedAndPos[Numeric.ZERO]);
			position = removedAndPos[Numeric.ONE];
		}
		childIds.add(this.childrens.remove(Numeric.ZERO).get()[Numeric.ZERO]);
		return childIds;
	}

	public void playAndWon() {
		List<Integer> childs = play();
		Integer winner = childs.remove(childs.size() - Numeric.ONE);
		System.out.println("The winner is: " + winner);
		int length = childs.size();
		StringBuilder buf = new StringBuilder();
		for (int i = Numeric.ZERO; i < length; i++) {
			buf.append(childs.get(i));
			buf.append(" ");
		}
		
		System.out.println("The order of child goes out is: " + buf.toString());
	}
	
	private static void usage() {
		System.out.println("Usage: java -jar target/ChildrenGames.jar numberOfChildren count");
	}
	
	public static void main(String[] argv) {
		int numberofChildren = DEFAULT_NO_CHILDREN;
		int count = DEFAULT_COUNT;
		
		if ((null != argv) && (CORRECT_PARAMS_LENGTH == argv.length)) {
			try {
				numberofChildren = Integer.parseInt(argv[Numeric.ZERO]);
				count = Integer.parseInt(argv[Numeric.ONE]);
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
				usage();
				return;
			}
		}
		ChildrenGames  game = new ChildrenGames(numberofChildren, count);
		game.playAndWon();
	}
}
