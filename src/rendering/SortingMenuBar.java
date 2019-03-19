package rendering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import sorting.SortingAlgorithm;

/**
 * A class which allows for an end user to choose which sorting algorithm to
 * display.
 * 
 * @author kennangumbs
 *
 */
@SuppressWarnings("serial")
public class SortingMenuBar extends JMenuBar {

	private Thread t;

	/**
	 * Constructs a SortingMenuBar object.
	 * 
	 * @param algs the sorting algorithms that can be chosen to sort the array.
	 */
	public SortingMenuBar(ArrayList<SortingAlgorithm> algs) {
		super();

		JMenu menu = new JMenu("Choose Algorithm...");

		for (SortingAlgorithm sa : algs) {
			JMenuItem item = new JMenuItem(sa.toString());
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (t != null && t.isAlive()) {
						System.err.println("Wait until sorting is finished.");
						return;
					}

					t = new Thread(sa);
					t.start();
				}
			});

			menu.add(item);
		}
		this.add(menu);
	}
}
