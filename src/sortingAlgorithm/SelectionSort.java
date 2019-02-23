package sortingAlgorithm;

import java.awt.Color;

public class SelectionSort extends SortingAlgorithm {

	public SelectionSort(int length, int delay, int shuffleDelay) {
		super(length, delay, shuffleDelay);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (a[j] < min) {
					min = a[j];
					minIndex = j;

				}
				comparisons++;

			}
			swap(i, minIndex);
			sp.update(new int[] { i, minIndex }, Color.RED);
			modifications++;
		}
	}
}
