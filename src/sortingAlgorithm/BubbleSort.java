package sortingAlgorithm;

public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int length, int delay, int shuffleDelay) {
		super(length, delay, shuffleDelay);
	}

	@Override
	protected void sort() {
		for (int i = a.length; i > -1; i--) {
			for (int j = 1; j < i; j++) {
				incrementComparisons(delay);
				if (a[j - 1] > a[j]) {
					swap(j - 1, j, delay);
				}
			}
		}
	}
}
