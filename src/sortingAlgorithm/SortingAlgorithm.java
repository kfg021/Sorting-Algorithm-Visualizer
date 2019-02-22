package sortingAlgorithm;

import java.awt.Color;
import java.util.Random;

import main.SortingPanel;

public abstract class SortingAlgorithm {

	protected int[] a;
	protected SortingPanel sp;
	protected int delay;

	protected int comparisons;
	protected int modifications;

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
			swap(i, rand);
			sp.update(new int[] { i, rand }, Color.YELLOW);
			try {
				Thread.sleep(shuffleDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Shuffled.");
		sp.update();
		try {
			Thread.sleep(shuffleDelay * 25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected abstract void sort();

	private void end() {
		try {
			Thread.sleep(shuffleDelay * 25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(comparisons + " comparisons, " + modifications + " array modifications.");
		Color color = Color.GREEN;
		if (!isFullySorted()) {
			color = Color.RED;
		}
		for (int i = 0; i < a.length; i++) {
			int[] arr = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				arr[j] = j;
			}
			sp.update(arr, color);
			try {
				Thread.sleep(shuffleDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sp.update();

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	protected void swap(int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	protected final boolean isFullySorted() {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				return false;
			}
		}
		return true;
	}

	public int getArrayModifiactions() {
		return modifications;
	}

	public SortingPanel getSortingPanel() {
		return sp;
	}
}
