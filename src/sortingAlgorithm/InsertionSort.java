package sortingAlgorithm;

import java.awt.Color;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(int length, int delay, int shuffleDelay) {
		super(length, delay, shuffleDelay);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			int j = i;
			for (j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					swap(j, j - 1);
					modifications++;
				} else {
					break;
				}
				comparisons++;
			}
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sp.update(new int[] { i, j - 1 }, Color.RED);
		}
	}
}
