package sorting;

import javax.swing.JFrame;

import rendering.SortingPanel;

/**
 * Shell sort implementation.
 * 
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Shellsort">https://en.wikipedia.org/wiki/Shellsort</a>
 * @author kennangumbs
 */
public class ShellSort extends SortingAlgorithm {

	public ShellSort(int[] a, int delay, SortingPanel sp, JFrame frame) {
		super(a, delay, sp, frame);
	}

	@Override
	protected void sort() {
		for (int i = a.length / 2; i > 0; i /= 2) {
			shell(i);
			super.update(delay);
		}
	}

	private void shell(int gap) {
		for (int i = gap; i < a.length; i += 1) {
			int num = a[i];
			int j = 0;

			for (j = i; j >= gap && a[j - gap] > num; j -= gap) {
				a[j] = a[j - gap];
				super.update(delay);
			}

			a[j] = num;
			super.update(delay);
		}
	}
}
