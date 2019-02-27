package sorting;

import javax.swing.JFrame;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(int length, int delay, JFrame frame) {
		super(length, delay, frame);
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
			sp.update(delay);
		}
		a[i] = num;
	}
}
