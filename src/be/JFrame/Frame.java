package be.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	public static final String NAME = "Animation";

	public static final int BALLSIZE = 50;
	private static final int MS_SPEED = 5;

	private DirectionTo XactionBall1 = DirectionTo.RIGHT;
	private DirectionTo YactionBall1 = DirectionTo.DOWN;
	private DirectionTo XactionBall2 = DirectionTo.LEFT;
	private DirectionTo YactionBall2 = DirectionTo.DOWN;
	public static boolean IS_RUNNING = true;
	private Panel pan = new Panel();

	public Frame() {

		this.setTitle(NAME);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// positonning the panels
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pan, BorderLayout.CENTER);

		// My button

		JPanel btnpan = new JPanel();
		JButton start_stop = new JButton("Start/Stop");
		JButton reset = new JButton("Reset");
		ActionListener resetbtn = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				pan.posX = 0 - BALLSIZE;
				pan.posY = 0 - BALLSIZE;
				pan.X2 = pan.getWidth();
				pan.Y2 = 0 - BALLSIZE;
				XactionBall1 = DirectionTo.RIGHT;
				YactionBall1 = DirectionTo.DOWN;
				XactionBall2 = DirectionTo.LEFT;
				YactionBall2 = DirectionTo.DOWN;
			}
		};
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (IS_RUNNING) {
					IS_RUNNING = false;
				} else
					IS_RUNNING = true;
			}
		};
		reset.addActionListener(resetbtn);
		btnpan.add(reset);
		start_stop.addActionListener(action);
		btnpan.add(start_stop);
		this.getContentPane().add(btnpan, BorderLayout.SOUTH);
		// My button-------

		// The animation
		go();
	}

	private void go() {
		for (;;) {

			Ball1();
			Ball2();

		}
	}

	private void Ball1() {
		int x = pan.posX;
		int y = pan.posY;
		// actual positions

		// if x or y is bigger then the height or width, then set x and y back
		// to -50
		if (IS_RUNNING) {

			if (XactionBall1 == DirectionTo.LEFT) {
				if (x == 0) {
					XactionBall1 = DirectionTo.RIGHT;
				} else
					x--;

			}
			if (YactionBall1 == DirectionTo.UP) {
				if (y == 0) {
					YactionBall1 = DirectionTo.DOWN;
				} else
					y--;
			}
			if (XactionBall1 == DirectionTo.RIGHT) {
				if (x == this.getWidth() - BALLSIZE) {
					XactionBall1 = DirectionTo.LEFT;
				} else
					x++;
			}
			if (YactionBall1 == DirectionTo.DOWN) {
				if (y == this.getHeight() - 2 * BALLSIZE) {
					YactionBall1 = DirectionTo.UP;
				} else
					y++;
			}

		}

		// telling pan the new positions, and asking to repaint
		pan.posX = x;
		pan.posY = y;
		pan.repaint();

		try {
			Thread.sleep(MS_SPEED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void Ball2() {
		int x = pan.X2;
		int y = pan.Y2;
		// actual positions

		// if x or y is bigger then the height or width, then set x and y back
		// to -50
		if (IS_RUNNING) {

			if (XactionBall2 == DirectionTo.LEFT) {
				if (x == 0) {
					XactionBall2 = DirectionTo.RIGHT;
				} else
					x--;

			}
			if (YactionBall2 == DirectionTo.UP) {
				if (y == 0) {
					YactionBall2 = DirectionTo.DOWN;
				} else
					y--;
			}
			if (XactionBall2 == DirectionTo.RIGHT) {
				if (x == this.getWidth() - BALLSIZE) {
					XactionBall2 = DirectionTo.LEFT;
				} else
					x++;
			}
			if (YactionBall2 == DirectionTo.DOWN) {
				if (y == this.getHeight() - 2 * BALLSIZE) {
					YactionBall2 = DirectionTo.UP;
				} else
					y++;
			}

		}

		// telling pan the new positions, and asking to repaint
		pan.X2 = x;
		pan.Y2 = y;
		pan.repaint();

		try {
			Thread.sleep(MS_SPEED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
