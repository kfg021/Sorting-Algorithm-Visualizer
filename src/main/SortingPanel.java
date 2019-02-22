package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortingPanel extends JPanel {

	private static final int WIDTH = 1600, HEIGHT = 900;
	private int[] a;
	int maxValue;
	private int rectWidth;

	private int[] modified = new int[0];
	private Color color;

	public SortingPanel(int[] a) {
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		this.a = a;

		maxValue = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
			}
		}

		rectWidth = WIDTH / a.length;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		renderArray(g2d);
	}

	private void renderArray(Graphics2D g2d) {
		for (int i = 0; i < a.length; i++) {
			g2d.setColor(Color.BLACK);
			if (modified != null) {
				for (int j : modified) {
					if (j == i) {
						g2d.setColor(color);
						break;
					}
				}
			}
			int rectHeight = HEIGHT * a[i] / maxValue;
			g2d.fillRect(i * rectWidth, HEIGHT - rectHeight, rectWidth, rectHeight);

		}
	}

	public void update() {
		update(null, null);
	}

	public void update(int[] modified, Color color) {
		this.modified = modified;
		this.color = color;
		this.repaint();
	}
}
