package main;

import javax.swing.JFrame;

import sorting.ShellSort;

public class Tester {
	private static final int DELAY_TIME = 5;
	private static final int ARRAY_LENGTH = 400;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Sorting Visualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

//		BubbleSort bs = new BubbleSort(ARRAY_LENGTH, DELAY_TIME, frame);
//		SelectionSort ss = new SelectionSort(ARRAY_LENGTH, DELAY_TIME, frame);
//		InsertionSort is = new InsertionSort(ARRAY_LENGTH, DELAY_TIME, frame);
//		MergeSort ms = new MergeSort(ARRAY_LENGTH, DELAY_TIME, frame);
//		RadixSort rs = new RadixSort(ARRAY_LENGTH, DELAY_TIME, frame);
//		QuickSort qs = new QuickSort(ARRAY_LENGTH, DELAY_TIME, frame);
//		HeapSort hs = new HeapSort(ARRAY_LENGTH, DELAY_TIME, frame);
		ShellSort shs = new ShellSort(ARRAY_LENGTH, DELAY_TIME, frame);

		frame.pack();
		frame.setLocationRelativeTo(null);

//		bs.sortPath();
//		ss.sortPath();
//		is.sortPath();
//		ms.sortPath();
//		rs.sortPath();
//		qs.sortPath();
//		hs.sortPath();
		shs.sortPath();
	}
}