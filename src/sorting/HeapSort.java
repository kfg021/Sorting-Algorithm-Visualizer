package sorting;

import javax.swing.JFrame;

import rendering.SortingPanel;

/**
 * Heap sort implementation.
 * 
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Heapsort">https://en.wikipedia.org/wiki/Heapsort</a>
 * @author kennangumbs
 */
public class HeapSort extends SortingAlgorithm {

	public HeapSort(int[] a, int delay, SortingPanel sp, JFrame frame) {
		super(a, delay, sp, frame);
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
				super.update(delay);
			}
		}

		swap(l, r - 1);
		super.update(delay);
	}
}
