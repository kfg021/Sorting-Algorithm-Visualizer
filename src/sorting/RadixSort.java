package sorting;

import java.util.ArrayList;

public class RadixSort extends SortingAlgorithm {

	public RadixSort(int length, int delay) {
		super(length, delay);
	}

	@Override
	protected void sort() {
		int digits = (int) Math.log10(maxValue()) + 1;
		for (int i = 0; i < digits; i++) {
			radix(i, digits);
		}
	}

	private void radix(int digit, int digits) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		for (int i : a) {
			buckets[(i / (int) (Math.pow(10, digit))) % 10].add(i);
		}

		ArrayList<Integer> sorted = new ArrayList<Integer>();
		for (ArrayList<Integer> i : buckets) {
			sorted.addAll(i);
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = sorted.get(i);
			sp.update(delay / digits);
		}
	}

	private int maxValue() {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			max = Math.max(a[i], max);
		}
		return max;
	}
}