package sortingAlgorithm;

import java.util.Random;

import rendering.SortingPanel;

public abstract class SortingAlgorithm {

	protected int[] a;
	private SortingPanel sp;
	protected int delay;

	private int swaps;
	private int comparisons;

	private int shuffleDelay;

	public SortingAlgorithm(int length, int delay, int shuffleDelay) {
		a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = i + 1;
		}

		sp = new SortingPanel(a);

		this.delay = delay;
		this.shuffleDelay = shuffleDelay;
	}

	public final void sortPath() {
		shuffle();
		sort();
		end();
	}

	private void shuffle() {
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			int rand = r.nextInt(a.length);
			swap(i, rand, shuffleDelay);
		}
		System.out.println("Shuffled.");

		swaps = 0;
	}

	protected abstract void sort();

	private void end() {
		System.out.println(comparisons + " comparisons, " + swaps + " swaps.");

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	protected void swap(int index1, int index2, int pauseTime) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
		sp.update(index1, index2);

		try {
			Thread.sleep(pauseTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		swaps++;
	}

	protected final boolean isFullySorted() {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				return false;
			}
		}
		return true;
	}

	protected void incrementComparisons(int delay) {
		comparisons++;
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public SortingPanel getSortingPanel() {
		return sp;
	}
}
