package main;

import javax.swing.JFrame;

import sortingAlgorithm.SelectionSort;

public class Tester {
	private static final int DELAY_TIME = 2;
	private static final int SHUFFLE_DELAY_TIME = 10;
	private static final int ARRAY_LENGTH = 200;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Sorting Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

//		BubbleSort bs = new BubbleSort(ARRAY_LENGTH, DELAY_TIME, SHUFFLE_DELAY_TIME);
//		frame.add(bs.getSortingPanel());
		SelectionSort ss = new SelectionSort(ARRAY_LENGTH, DELAY_TIME, SHUFFLE_DELAY_TIME);
		frame.add(ss.getSortingPanel());
//		InsertionSort is = new InsertionSort(ARRAY_LENGTH, DELAY_TIME, SHUFFLE_DELAY_TIME);
//		frame.add(is.getSortingPanel());

		frame.pack();
		frame.setLocationRelativeTo(null);

//		bs.sortPath();
		ss.sortPath();
//		is.sortPath();
	}
}