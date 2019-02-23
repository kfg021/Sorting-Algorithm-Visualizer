package sortingAlgorithm;

public class SelectionSort extends SortingAlgorithm {

	public SelectionSort(int length, int delay, int shuffleDelay) {
		super(length, delay, shuffleDelay);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				incrementComparisons(delay);
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			swap(i, minIndex, delay);
		}
	}
}
