package sorting;

import java.util.Random;

import rendering.SortingPanel;

public abstract class SortingAlgorithm {

	protected final int[] a;
	private final SortingPanel sp;
	protected final int delay;

	public SortingAlgorithm(int[] a, int delay, SortingPanel sp) {
		this.a = a;
		this.sp = sp;
		this.delay = delay;
	}

	public final void run() {
		pause(1000);
		shuffle();
		pause(1000);

		long startTime = System.nanoTime();
		sort();
		long timeElapsed = System.nanoTime() - startTime;

		end(timeElapsed);
	}

	private void shuffle() {
		System.out.println(this.toString());
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			int rand = r.nextInt(a.length);
			swap(i, rand);
			update(delay);
		}
		System.out.println("Shuffled.");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected abstract void sort();

	private void end(long timeElapsed) {
		update(0);
		System.out.println("Fully sorted: " + isFullySorted());
		System.out.println("Time elapsed: " + timeElapsed / Math.pow(10, 9) + "s");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
	}

	protected final void swap(int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	protected final void update(int delay) {
		sp.update();
		pause(delay);
	}

	private boolean isFullySorted() {
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
