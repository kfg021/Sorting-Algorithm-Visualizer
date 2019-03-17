package sorting;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rendering.SortingPanel;

public abstract class SortingAlgorithm implements Runnable {

	private final int[] original;
	protected final int[] a;

	private SortingPanel sp;
	private JFrame frame;

	protected final int delay;

	public SortingAlgorithm(int[] a, int delay, SortingPanel sp, JFrame frame) {
		this.a = a;
		original = a.clone();

		this.sp = sp;
		this.delay = delay;
		this.frame = frame;
	}

	@Override
	public final void run() {
		reset();
		shuffle();
		pause(1000);

		long startTime = System.nanoTime();
		sort();
		long timeElapsed = System.nanoTime() - startTime;

		end(timeElapsed);
	}

	private void reset() {
		for (int i = 0; i < a.length; i++) {
			a[i] = original[i];
		}

		frame.setTitle(this.toString());
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

		String display = "";
		display += "Fully sorted: " + isFullySorted() + "\n";
		display += "Time elapsed: " + timeElapsed / Math.pow(10, 9) + "s";

		JOptionPane.showMessageDialog(sp, display, this.toString() + " finished.", JOptionPane.INFORMATION_MESSAGE);
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
