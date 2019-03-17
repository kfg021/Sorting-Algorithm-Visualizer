package sorting;

import javax.swing.JFrame;

import rendering.SortingPanel;

public class RadixSort extends SortingAlgorithm {

	public RadixSort(int[] a, int delay, SortingPanel sp, JFrame frame) {
		super(a, delay, sp, frame);
	}

	@Override
	protected void sort() {
		int digits = (int) Math.log10(maxValue()) + 1;
		int exp = 1;
		for (int i = 0; i < digits; i++) {
			countingSort(exp);
			exp *= 10;
		}
	}

	private void countingSort(int exp) {
		int[] count = new int[10];
		for (int i : a) {
			count[(i / exp) % 10]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int[] output = new int[a.length];
		for (int i = a.length - 1; i > -1; i--) {
			int index = (a[i] / exp) % 10;
			output[count[index] - 1] = a[i];
			count[index]--;
			super.update(delay);
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = output[i];
			super.update(delay);
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