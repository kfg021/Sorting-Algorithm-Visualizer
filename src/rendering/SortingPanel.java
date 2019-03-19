package rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * A class which renders the array during sorting.
 * 
 * @author kennangumbs
 */
@SuppressWarnings("serial")
public class SortingPanel extends JPanel {
	private final int[] a;
	private int maxValue;

	/**
	 * Constructs a SortingPanel object.
	 * 
	 * @param a      the array being sorted.
	 * @param width  the starting width of the panel.
	 * @param height the starting height of the panel.
	 */
	public SortingPanel(int[] a, int width, int height) {
		super();
		this.setPreferredSize(new Dimension(width, height));

		this.a = a;
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		maxValue = max;
	}

	/**
	 * Calculates the color of a rectangle (on a scale of red to violet in HSB)
	 * given the numerical value associated with it.
	 * 
	 * @param n   an integer less than or equal to max.
	 * @param max the max value of the array
	 * @return
	 */
	private Color generateColor(int n, int max) {
		int rgb = 0;
		final float MAX_HUE = 285f / 360f; // Sets the color of the max value to violet instead of red
		float hue = (MAX_HUE * n) / (max - 1);
		rgb = Color.HSBtoRGB(hue, 1, 1);
		return new Color(rgb);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		renderArray(g2d);
	}

	/**
	 * draws a visual representation of the array using color and rectangle height
	 * to depict the value of each element.
	 * 
	 * @param g2d A graphics2D object received from the paintComponent method.
	 */
	private void renderArray(Graphics2D g2d) {
		int rectWidth = this.getWidth() / a.length;
		int remainder = this.getWidth() % a.length;
		for (int i = 0; i < a.length; i++) {
			g2d.setColor(generateColor(a[i] - 1, maxValue));

			int rectHeight = this.getHeight() * a[i] / maxValue;
			Rectangle rect = new Rectangle(i * rectWidth + remainder / 2, this.getHeight() - rectHeight, rectWidth,
					rectHeight);

			g2d.fill(rect);
			if (rectWidth > 1) {
				g2d.setColor(Color.BLACK);
				g2d.draw(rect);
			}
		}
	}
}