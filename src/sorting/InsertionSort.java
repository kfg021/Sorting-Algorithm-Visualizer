package sorting;

import javax.swing.JFrame;

import rendering.SortingPanel;

/**
 * Insertion sort implementation.
 * 
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Insertion_sort">https://en.wikipedia.org/wiki/Insertion_sort</a>
 * @author kennangumbs
 */
public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(int[] a, int delay, SortingPanel sp, JFrame frame) {
		super(a, delay, sp, frame);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			insert(i);
		}
	}

	private void insert(int index) {
		int num = a[index];
		int i = 0;
		for (i = 0; i < index; i++) {
			if (num < a[i]) {
				break;
			}
		}

		for (int j = index; j > i; j--) {
			a[j] = a[j - 1];
			super.update(delay);
		}
		a[i] = num;
	}
}
