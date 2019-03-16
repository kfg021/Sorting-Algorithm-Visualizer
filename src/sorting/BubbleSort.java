package sorting;

import rendering.SortingPanel;

public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int length, int delay, SortingPanel sp) {
		super(length, delay, sp);
	}

	@Override
	protected void sort() {
		for (int i = a.length; i > -1; i--) {
			for (int j = 1; j < i; j++) {
				if (a[j - 1] > a[j]) {
					swap(j - 1, j);
					sp.update(delay);
				}
			}
		}
	}
}
