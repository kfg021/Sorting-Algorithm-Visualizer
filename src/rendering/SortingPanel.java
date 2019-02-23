package rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortingPanel extends JPanel {

	private static final int WIDTH = 1600, HEIGHT = 900;
	private int[] a;
	private Color[] colors;
	int maxValue;
	private int rectWidth;

	public SortingPanel(int[] a) {
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		this.a = a;
		colors = generateRainbow(a.length);

		maxValue = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
			}
		}

		rectWidth = WIDTH / a.length;
	}

	private Color[] generateRainbow(int numValues) {
		Color[] colors = new Color[numValues];
		for (int i = 0; i < numValues; i++) {
			int rgb = 0;
			float hue = (float) i / (numValues - 1);
			rgb = Color.HSBtoRGB(hue, 1, 1);
			colors[i] = new Color(rgb);
		}
		return colors;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		renderArray(g2d);
	}

	private void renderArray(Graphics2D g2d) {
		for (int i = 0; i < a.length; i++) {
			g2d.setColor(colors[i]);
//			if (modified != null) {
//				for (int j : modified) {
//					if (j == i) {
//						g2d.setColor(color);
//						break;
//					}
//				}
//			}
			int rectHeight = HEIGHT * a[i] / maxValue;
			g2d.fillRect(i * rectWidth, HEIGHT - rectHeight, rectWidth, rectHeight);

		}
	}

	public void update(int index1, int index2) {
		Color temp = colors[index1];
		colors[index1] = colors[index2];
		colors[index2] = temp;
		this.repaint();
	}
}
