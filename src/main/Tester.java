package main;

import javax.swing.JFrame;

import sorting.MergeSort;

public class Tester {
	private static final int DELAY_TIME = 5;
	private static final int ARRAY_LENGTH = 400;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Sorting Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

//		BubbleSort bs = new BubbleSort(ARRAY_LENGTH, DELAY_TIME);
//		frame.add(bs.getSortingPanel());
//		SelectionSort ss = new SelectionSort(ARRAY_LENGTH, DELAY_TIME);
//		frame.add(ss.getSortingPanel());
//		InsertionSort is = new InsertionSort(ARRAY_LENGTH, DELAY_TIME);
//		frame.add(is.getSortingPanel());
		MergeSort ms = new MergeSort(ARRAY_LENGTH, DELAY_TIME);
		frame.add(ms.getSortingPanel());

		frame.pack();
		frame.setLocationRelativeTo(null);

//		bs.sortPath();
//		ss.sortPath();
//		is.sortPath();
		ms.sortPath();
	}
}