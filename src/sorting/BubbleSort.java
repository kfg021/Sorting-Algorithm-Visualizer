package sorting;

import javax.swing.JFrame;

public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int length, int delay, JFrame frame) {
		super(length, delay, frame);
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
