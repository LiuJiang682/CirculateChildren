package au.com.afl.chidlren.game.util;

import java.util.ArrayList;
import java.util.Optional;

import au.com.afl.chidlren.game.constants.Constants.Numeric;

public class CirculateArray {

	public static final int ZERO = 0;
	private ArrayList<Integer> array;
	
	public CirculateArray(int size) {
		if (size < Numeric.ONE) {
			throw new IllegalArgumentException("Illegal size argument: " + size + ", must be greater than zero!");
		}
		this.array = new ArrayList<>(size);
		for (int i = 1; i <= size; i++) {
			this.array.add(i);
		}
	}

	public Optional<Integer[]> remove(int index) {
		if (index < ZERO) {
			throw new IllegalArgumentException("Illegal index argument: " + index + ", must be greater than zero!");
		}
		
		Optional<Integer[]> result = Optional.empty();
		if (ZERO < this.array.size()) {
			int position = index;
			int mod = index % this.array.size();
			if (Numeric.ZERO != index) {
				if (ZERO == mod) {
					position = this.array.size();
				}
				else {
					position = mod;
				}
				position -= Numeric.ONE;
			}
			Integer integer = this.array.remove(position);
			Integer[] removeAndPos = {integer, position + Numeric.ONE};
			result = Optional.of(removeAndPos);
		}
		return result;
	}

	public int size() {
		return this.array.size();
	}
}
