package au.com.afl.chidlren.game.util;

import java.util.ArrayDeque;

public class CirculateArray {

	private static final int ONE = 1;
	private ArrayDeque<Integer> array;
	
	public CirculateArray(int size) {
		if (size < ONE) {
			throw new IllegalArgumentException("Illegal size argument: " + size + ", must be greater than zero!");
		}
		this.array = new ArrayDeque<>(size);
	}

}
