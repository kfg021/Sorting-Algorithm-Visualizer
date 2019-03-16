package main;

import java.util.ArrayList;

import javax.swing.JFrame;

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

public class Tester {
	private static final int DELAY_TIME = 3;
	private static final int ARRAY_LENGTH = 300;

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

		SortingPanel sp = new SortingPanel();
		frame.add(sp);

		ArrayList<SortingAlgorithm> algs = new ArrayList<SortingAlgorithm>();
		algs.add(new BubbleSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new SelectionSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new InsertionSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new MergeSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new RadixSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new QuickSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new HeapSort(ARRAY_LENGTH, DELAY_TIME, sp));
		algs.add(new ShellSort(ARRAY_LENGTH, DELAY_TIME, sp));

		frame.pack();
		frame.setLocationRelativeTo(null);

		// TODO: Make viewing a specific sorting algorithm more user-friendly (i.e. not
		// just a command line argument)
		boolean arg = false;
		if (args.length > 0) {
			if (args[0].matches("\\d+")) {
				int num = Integer.parseInt(args[0]);
				if (num < algs.size()) {
					SortingAlgorithm sa = algs.get(num);
					sa.run();
					arg = true;
				}
			}
		}

		if (!arg) {
			for (SortingAlgorithm sa : algs) {
				frame.setTitle(sa.toString());
				sa.run();
			}
		}
	}
}