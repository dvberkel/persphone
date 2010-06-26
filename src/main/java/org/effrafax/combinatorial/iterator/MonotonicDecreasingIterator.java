package org.effrafax.combinatorial.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class MonotonicDecreasingIterator implements Iterator<int[]> {

	private static final int INFINITY = Integer.MAX_VALUE;
	private final int height;
	private final int[] sequence;

	public MonotonicDecreasingIterator(int length, int height) {

		this.sequence = startSequence(length);
		this.height = height;
	}

	private int[] startSequence(int length) {

		int[] startSequence = new int[length + 1];
		Arrays.fill(startSequence, 0);
		startSequence[0] = INFINITY;
		return startSequence;
	}

	@Override
	public boolean hasNext() {

		return sequence[1] <= height;
	}

	@Override
	public int[] next() {

		int[] copy = Arrays.copyOfRange(sequence, 1, sequence.length);
		produceNext();

		return copy;
	}

	private void produceNext() {

		int index = findLatestStep();
		increaseAt(index);
	}

	private int findLatestStep() {

		int index = sequence.length - 1;
		while (sequence[index] == sequence[index - 1]) {
			index--;
		}
		return index;
	}

	private void increaseAt(int index) {

		sequence[index]++;
		Arrays.fill(sequence, index + 1, sequence.length, 0);
	}

	@Override
	public void remove() {

	throw new UnsupportedOperationException();
	}
}
