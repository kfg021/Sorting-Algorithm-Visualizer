package sorting;

import javax.swing.JFrame;

public class SelectionSort extends SortingAlgorithm {

	public SelectionSort(int length, int delay, JFrame frame) {
		super(length, delay, frame);
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
				sp.update(delay);
			}
			swap(i, minIndex);
		}
	}
}
