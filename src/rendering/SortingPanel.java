package rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortingPanel extends JPanel {
	private final int[] a;
	private int maxValue;

	public SortingPanel(int[] a, int width, int height) {
		super();

		this.a = a;
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		maxValue = max;

		this.setPreferredSize(new Dimension(width, height));
	}

	private Color generateColor(int n, int max) {
		int rgb = 0;
		final float MAX_HUE = 285f / 360f;
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

	public void update() {
		repaint();
	}
}
