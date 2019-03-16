package rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortingPanel extends JPanel {

	private static final int WIDTH = 1200, HEIGHT = 900;
	private int[] a;
	int maxValue;
	private int rectWidth;

	public SortingPanel() {
		super();
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

	public void setA(int[] a) {
		this.a = a;
		maxValue = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
			}
		}

		rectWidth = WIDTH / a.length;
	}

	public void update(int delay) {
		repaint();
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
