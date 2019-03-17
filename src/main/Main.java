package main;

import java.util.ArrayList;

import javax.swing.JFrame;

import rendering.SortingPanel;
import rendering.UIMenuBar;
import sorting.BubbleSort;
import sorting.HeapSort;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.RadixSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.SortingAlgorithm;

public class Main {
	private static final int DELAY_TIME = 5;
	private static final int ARRAY_LENGTH = 150;
	private static final int WIDTH = 1200, HEIGHT = WIDTH * 10 / 16;

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
		/* 0 */ algs.add(new BubbleSort(a, DELAY_TIME, sp));
		/* 1 */ algs.add(new SelectionSort(a, DELAY_TIME, sp));
		/* 2 */ algs.add(new InsertionSort(a, DELAY_TIME, sp));
		/* 3 */ algs.add(new MergeSort(a, DELAY_TIME, sp));
		/* 4 */ algs.add(new RadixSort(a, DELAY_TIME, sp));
		/* 5 */ algs.add(new QuickSort(a, DELAY_TIME, sp));
		/* 6 */ algs.add(new HeapSort(a, DELAY_TIME, sp));
		/* 7 */ algs.add(new ShellSort(a, DELAY_TIME, sp));

		frame.setJMenuBar(new UIMenuBar(algs));
		frame.pack();
		frame.setLocationRelativeTo(null);

//		// TODO: Make viewing a specific sorting algorithm more user-friendly (i.e. not
//		// just a command line argument)
//		boolean arg = false;
//		if (args.length > 0) {
//			if (args[0].matches("\\d+")) {
//				int num = Integer.parseInt(args[0]);
//				if (num < algs.size()) {
//					SortingAlgorithm sa = algs.get(num);
//					frame.setTitle(sa.toString());
//					sa.run();
//					arg = true;
//				}
//			}
//		}
//		if (!arg) {
//			for (SortingAlgorithm sa : algs) {
//				frame.setTitle(sa.toString());
//				sa.run();
//			}
//		}
	}
}