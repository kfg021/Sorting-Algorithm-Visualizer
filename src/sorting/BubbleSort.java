package sorting;

import javax.swing.JFrame;

import rendering.SortingPanel;

/**
 * Bubble sort implementation.
 * 
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Bubble_sort">https://en.wikipedia.org/wiki/Bubble_sort</a>
 * @author kennangumbs
 */
public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int[] a, int delay, SortingPanel sp, JFrame frame) {
		super(a, delay, sp, frame);
	}

	@Override
	protected void sort() {
		for (int i = a.length; i > -1; i--) {
			for (int j = 1; j < i; j++) {
				if (a[j - 1] > a[j]) {
					swap(j - 1, j);
					super.update(delay);
				}
			}
		}
	}
}