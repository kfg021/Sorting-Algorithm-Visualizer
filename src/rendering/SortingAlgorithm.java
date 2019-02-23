package rendering;

import java.util.Random;

public abstract class SortingAlgorithm {

	protected int[] a;
	protected SortingPanel sp;
	protected int delay;

	public SortingAlgorithm(int length, int delay) {
		a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = i + 1;
		}

		sp = new SortingPanel(a);

		this.delay = delay;
	}

	public final void sortPath() {
		shuffle();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sort();
		end();
	}

	private void shuffle() {
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			int rand = r.nextInt(a.length);
			swap(i, rand, delay);
		}
		System.out.println("Shuffled.");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	protected abstract void sort();

	private void end() {
		System.out.println("Fully sorted: " + isFullySorted());
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	protected void swap(int index1, int index2, int pauseTime) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
		sp.update(pauseTime);
	}

	private final boolean isFullySorted() {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				return false;
			}
		}
		return true;
	}

	public SortingPanel getSortingPanel() {
		return sp;
	}
}
