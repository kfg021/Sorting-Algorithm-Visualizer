package sorting;

import rendering.SortingPanel;

public class ShellSort extends SortingAlgorithm {

	public ShellSort(int[] a, int delay, SortingPanel sp) {
		super(a, delay, sp);
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
