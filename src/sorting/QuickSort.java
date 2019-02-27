package sorting;

import javax.swing.JFrame;

public class QuickSort extends SortingAlgorithm {

	public QuickSort(int length, int delay, JFrame frame) {
		super(length, delay, frame);
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
			}

			while (rIndex >= l && a[rIndex] >= a[pivot]) {
				rIndex--;
			}

			if (rIndex >= lIndex) {
				swap(lIndex, rIndex);
				lIndex++;
				rIndex--;
			}
			sp.update(delay);
		}

		swap(lIndex, pivot);
		sp.update(delay);

		pivot(l, lIndex);
		pivot(lIndex + 1, r);
	}
}
