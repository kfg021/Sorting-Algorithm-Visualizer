package sorting;

import rendering.SortingPanel;

public class HeapSort extends SortingAlgorithm {

	public HeapSort(int length, int delay, SortingPanel sp) {
		super(length, delay, sp);
	}

	@Override
	protected void sort() {
		for (int i = a.length; i > 0; i--) {
			buildMaxHeap(0, i);
		}
	}

	private void buildMaxHeap(int l, int r) {
		int start = (r - l) / 2 - 1;

		for (int i = start; i > l - 1; i--) {
			int lc = 2 * i + 1;
			int rc = 2 * i + 2;

			int max = rc;
			if (rc >= r || a[lc] > a[rc]) {
				max = lc;
			}

			if (a[max] > a[i]) {
				swap(max, i);
				sp.update(delay);
			}
		}

		swap(l, r - 1);
	}
}
