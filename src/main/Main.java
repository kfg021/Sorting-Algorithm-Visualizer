package main;

import java.util.ArrayList;

import javax.swing.JFrame;

import rendering.SortingMenuBar;
import rendering.SortingPanel;
import sorting.BubbleSort;
import sorting.HeapSort;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.RadixSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.SortingAlgorithm;

/**
 * the driver class which serves as an entry point for the program.
 * 
 * @author kennangumbs
 */
public class Main {
	private static final int DELAY_TIME = 5;
	private static final int ARRAY_LENGTH = 150;
	private static final int WIDTH = 1200, HEIGHT = WIDTH * 10 / 16;

	/**
	 * constructs the relevant objects and starts the program.
	 * 
	 * @param args command-line arguments are not implemented.
	 */
	public static void main(String[] args) {

		int[] a = new int[ARRAY_LENGTH];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);

		SortingPanel sp = new SortingPanel(a, WIDTH, HEIGHT);
		frame.add(sp);

		ArrayList<SortingAlgorithm> algs = new ArrayList<SortingAlgorithm>();
		algs.add(new BubbleSort(a, DELAY_TIME, sp, frame));
		algs.add(new HeapSort(a, DELAY_TIME, sp, frame));
		algs.add(new InsertionSort(a, DELAY_TIME, sp, frame));
		algs.add(new MergeSort(a, DELAY_TIME, sp, frame));
		algs.add(new QuickSort(a, DELAY_TIME, sp, frame));
		algs.add(new RadixSort(a, DELAY_TIME, sp, frame));
		algs.add(new SelectionSort(a, DELAY_TIME, sp, frame));
		algs.add(new ShellSort(a, DELAY_TIME, sp, frame));

		frame.setJMenuBar(new SortingMenuBar(algs));
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
}