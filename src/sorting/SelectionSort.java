package sorting;

import javax.swing.JFrame;

import rendering.SortingPanel;

public class SelectionSort extends SortingAlgorithm {

	public SelectionSort(int[] a, int delay, SortingPanel sp, JFrame frame) {
		super(a, delay, sp, frame);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			swap(i, minIndex);
			super.update(delay * (minIndex - i));
		}
	}
}
