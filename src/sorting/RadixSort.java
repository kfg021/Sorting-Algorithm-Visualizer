package sorting;

import rendering.SortingPanel;

public class RadixSort extends SortingAlgorithm {

	public RadixSort(int length, int delay, SortingPanel sp) {
		super(length, delay, sp);
	}

	@Override
	protected void sort() {
		int digits = (int) Math.log10(maxValue()) + 1;
		int exp = 1;
		for (int i = 0; i < digits; i++) {
			radix(exp);
			exp *= 10;
		}
	}

	private void radix(int exp) {
		int[][] buckets = new int[10][a.length];
		int[] bucketSizes = new int[10];

		for (int i : a) {
			int index = (i / exp) % 10;
			buckets[index][bucketSizes[index]] = i;
			bucketSizes[index]++;
		}

		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < bucketSizes[i]; j++) {
				a[index] = buckets[i][j];
				index++;
				sp.update(delay);
			}
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