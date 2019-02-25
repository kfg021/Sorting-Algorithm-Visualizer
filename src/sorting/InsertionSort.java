package sorting;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort(int length, int delay) {
		super(length, delay);
	}

	@Override
	protected void sort() {
		for (int i = 0; i < a.length; i++) {
			insert(i);
			sp.update(delay);
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
		}
		a[i] = num;
	}
}
