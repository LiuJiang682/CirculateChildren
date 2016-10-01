package au.com.afl.chidlren.game.util;

import java.util.ArrayList;
import java.util.Optional;

public class CirculateArray {

	private static final int ONE = 1;
	private static final int ZERO = 0;
	private ArrayList<Integer> array;
	
	public CirculateArray(int size) {
		if (size < ONE) {
			throw new IllegalArgumentException("Illegal size argument: " + size + ", must be greater than zero!");
		}
		this.array = new ArrayList<>(size);
		for (int i = 1; i <= size; i++) {
			this.array.add(i);
		}
	}

	public Optional<Integer> remove(int index) {
		if (index < ZERO) {
			throw new IllegalArgumentException("Illegal index argument: " + index + ", must be greater than zero!");
		}
		
		Optional<Integer> result = Optional.empty();
		if (ZERO < this.array.size()) {
			int position = (ZERO == index) ? index : index % this.array.size() - ONE;
			Integer integer = this.array.remove(position);
			result = Optional.of(integer);
		}
		return result;
	}

}
