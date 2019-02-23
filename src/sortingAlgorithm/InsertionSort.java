package sortingAlgorithm;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(int length, int delay, int shuffleDelay) {
		super(length, delay, shuffleDelay);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				incrementComparisons(delay);
				if (a[j] < a[j - 1]) {
					swap(j, j - 1, delay);
				} else {
					break;
				}
			}
		}
	}
}
