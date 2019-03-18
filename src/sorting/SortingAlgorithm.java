package sorting;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rendering.SortingPanel;

/**
 * A class which represents a generic sorting algorithm.
 * 
 * @author kennangumbs
 */
public abstract class SortingAlgorithm implements Runnable {

	private final int[] original;
	protected final int[] a;

	private SortingPanel sp;
	private JFrame frame;

	protected final int delay;

	/**
	 * Constructs a sorting algorithm object.
	 * 
	 * @param a     the array to sort.
	 * @param delay how many milliseconds to wait in between updates.
	 * @param sp    the JPanel where the array is rendered.
	 * @param frame the JFrame which the sorting panel belongs to.
	 */
	public SortingAlgorithm(int[] a, int delay, SortingPanel sp, JFrame frame) {
		this.a = a;
		original = a.clone();

		this.sp = sp;
		this.delay = delay;
		this.frame = frame;
	}

	@Override
	public final void run() {
		init();
		shuffle();
		pause(1000);

		long startTime = System.nanoTime();
		sort();
		long timeElapsed = System.nanoTime() - startTime;

		end(timeElapsed);
	}

	/**
	 * resets the array and sets the JFrame's title.
	 */
	private void init() {
		for (int i = 0; i < a.length; i++) {
			a[i] = original[i];
		}

		frame.setTitle(this.toString());
	}

	/**
	 * shuffles the array using a variant of the Fisher-Yates shuffle.
	 * 
	 * @see <a href=
	 *      "https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle</a>
	 */
	private void shuffle() {
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			int rand = r.nextInt(a.length);
			swap(i, rand);
			update(delay);
		}
	}

	/**
	 * pauses this thread for a certain amount of time.
	 * 
	 * @param ms how long to pause
	 */
	private void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * each subclass will use this method to implement their own sorting algorithm.
	 */
	protected abstract void sort();

	/**
	 * ends the sorting; displays if the array was fully sorted and the time
	 * elapsed.
	 * 
	 * @param timeElapsed how much time has passed from the start of the sorting to
	 *                    the end
	 */
	private void end(long timeElapsed) {
		update(0);

		String display = "";
		display += "Fully sorted: " + isFullySorted() + "\n";
		display += "Time elapsed: " + timeElapsed / Math.pow(10, 9) + "s";

		JOptionPane.showMessageDialog(sp, display, this.toString() + " finished.", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * swaps two elements in the array.
	 * 
	 * @param index1 the index of the first element to swap.
	 * @param index2 the index of the second element to swap.
	 */
	protected final void swap(int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	/**
	 * updates the screen, then pauses the program for a specified amount of time.
	 * 
	 * @param delay how many milliseconds to wait after the screen is updated.
	 */
	protected final void update(int delay) {
		sp.repaint();
		pause(delay);
	}

	/**
	 * checks if the array is fully sorted (in increasing order).
	 * 
	 * @return true if the array is fully sorted, false if it is not.
	 */
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
