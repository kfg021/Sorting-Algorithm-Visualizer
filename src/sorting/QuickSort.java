package sorting;

import rendering.SortingPanel;

public class QuickSort extends SortingAlgorithm {

	public QuickSort(int[] a, int delay, SortingPanel sp) {
		super(a, delay, sp);
	}

	@Override
	protected void sort() {
		pivot(0, a.length);
	}

	private void pivot(int l, int r) {
		if (r - l < 1) {
			return;
		}

		int pivot = r - 1;
		int lIndex = l;
		int rIndex = pivot - 1;

		while (rIndex >= lIndex) {
			while (lIndex <= r - 1 && a[lIndex] < a[pivot]) {
				lIndex++;
				super.update(delay);
			}

			while (rIndex >= l && a[rIndex] >= a[pivot]) {
				rIndex--;
				super.update(delay);
			}

			if (rIndex >= lIndex) {
				swap(lIndex, rIndex);
				lIndex++;
				rIndex--;
				super.update(delay);
			}

		}

		swap(lIndex, pivot);

		pivot(l, lIndex);
		pivot(lIndex + 1, r);
	}
}
