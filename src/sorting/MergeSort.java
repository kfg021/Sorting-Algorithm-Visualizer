package sorting;

import rendering.SortingAlgorithm;

public class MergeSort extends SortingAlgorithm {

	public MergeSort(int length, int delay) {
		super(length, delay);
	}

	@Override
	protected void sort() {
		mergeSort(0, a.length);
	}

	private void mergeSort(int l, int r) {
		if (r - l > 1) {
			int m = (l + r) / 2;
			mergeSort(l, m);
			mergeSort(m, r);
			merge(l, m, r);
		}
	}

	private void merge(int l, int m, int r) {
		int lenL = m - l;
		int[] lArr = new int[lenL];
		int lenR = r - m;
		int[] rArr = new int[lenR];

		for (int i = 0; i < lArr.length; i++) {
			lArr[i] = a[i + l];
		}
		for (int i = 0; i < rArr.length; i++) {
			rArr[i] = a[m + i];
		}

		int lIndex = 0;
		int rIndex = 0;
		for (int i = l; i < r; i++) {
			if (lIndex >= lArr.length) {
				a[i] = rArr[rIndex];
				rIndex++;
			} else if (rIndex >= rArr.length) {
				a[i] = lArr[lIndex];
				lIndex++;
			} else if (lArr[lIndex] > rArr[rIndex]) {
				a[i] = rArr[rIndex];
				rIndex++;
			} else {
				a[i] = lArr[lIndex];
				lIndex++;
			}
			sp.update(delay);
		}
	}
}
