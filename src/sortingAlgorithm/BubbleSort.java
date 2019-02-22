package sortingAlgorithm;

import java.awt.Color;

public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int length, int delay, int shuffleDelay) {
		super(length, delay, shuffleDelay);
	}

	@Override
	protected void sort() {
		for (int i = a.length; i > -1; i--) {
			for (int j = 1; j < i; j++) {
				if (a[j - 1] > a[j]) {
					swap(j - 1, j);
					modifications++;
					sp.update(new int[] { j - 1, j }, Color.RED);
				} else {
					sp.update();
				}
				comparisons++;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
