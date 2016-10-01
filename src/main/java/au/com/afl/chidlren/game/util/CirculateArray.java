package au.com.afl.chidlren.game.util;

import java.util.ArrayDeque;
import java.util.Optional;

public class CirculateArray {

	private static final int ONE = 1;
	private ArrayDeque<Integer> array;
	
	public CirculateArray(int size) {
		if (size < ONE) {
			throw new IllegalArgumentException("Illegal size argument: " + size + ", must be greater than zero!");
		}
		this.array = new ArrayDeque<>(size);
		for (int i = 1; i <= size; i++) {
			this.array.add(i);
		}
	}

	public Optional<Integer> remove(Integer index) {
		if (index < ONE) {
			throw new IllegalArgumentException("Illegal index argument: " + index + ", must be greater than zero!");
		}
		
		Optional<Integer> result = Optional.empty();
		boolean success = this.array.remove(index);
		if (success) {
			result = Optional.of(index);
		}
		else {
			//Check if the index should be start from
			//beginning 
			Integer newIndex = index % this.array.size();
			success = this.array.remove(newIndex);
			if (success) {
				result = Optional.of(newIndex);
			}
		}
		return result;
	}

}
