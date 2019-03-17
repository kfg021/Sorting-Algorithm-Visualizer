package rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortingPanel extends JPanel {

	private static final int WIDTH = 1200, HEIGHT = 900;
	private final int[] a;
	private final int maxValue;
	private final int rectWidth;

	public SortingPanel(int[] a) {
		super();

		this.a = a;
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		maxValue = max;
		rectWidth = WIDTH / a.length;

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
		for (int i = 0; i < a.length; i++) {
			g2d.setColor(generateColor(a[i] - 1, maxValue));

			int rectHeight = HEIGHT * a[i] / maxValue;
			g2d.fillRect(i * rectWidth, HEIGHT - rectHeight, rectWidth, rectHeight);

			if (rectWidth > 1) {
				g2d.setColor(Color.BLACK);
				g2d.drawRect(i * rectWidth, HEIGHT - rectHeight, rectWidth, rectHeight);
			}
		}
	}

	public void update() {
		repaint();
	}
}
