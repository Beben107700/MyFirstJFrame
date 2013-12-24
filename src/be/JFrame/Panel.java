package be.JFrame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	public int posX = -50;
	public int posY = -50;

	public int X2 = this.getWidth();
	public int Y2 = -50;

	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// resetting the rectangle

		g.setColor(Color.RED);
		g.fillOval(posX, posY, Frame.BALLSIZE,Frame.BALLSIZE);

		g.setColor(Color.BLUE);
		g.fillOval(X2, Y2, Frame.BALLSIZE, Frame.BALLSIZE);

	}

}
