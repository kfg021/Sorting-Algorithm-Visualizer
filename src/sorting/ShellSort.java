package sorting;

import rendering.SortingPanel;

public class ShellSort extends SortingAlgorithm {

	public ShellSort(int length, int delay, SortingPanel sp) {
		super(length, delay, sp);
	}

	@Override
	protected void sort() {
		for (int i = a.length / 2; i > 0; i /= 2) {
			shell(i);
		}
	}

	private void shell(int gap) {
		for (int i = gap; i < a.length; i += 1) {
			int num = a[i];
			int j = 0;

			for (j = i; j >= gap && a[j - gap] > num; j -= gap) {
				a[j] = a[j - gap];
			}

			a[j] = num;
			sp.update(delay);
		}
	}
}
