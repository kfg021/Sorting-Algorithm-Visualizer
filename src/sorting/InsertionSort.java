package sorting;

import rendering.SortingAlgorithm;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(int length, int delay) {
		super(length, delay);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					swap(j, j - 1, delay);
				} else {
					break;
				}
			}
		}
	}
}
