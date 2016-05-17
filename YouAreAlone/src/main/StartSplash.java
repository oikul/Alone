package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.InputHandler;

public class StartSplash extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel splash;

	public StartSplash() {
		setBackground(Color.BLACK);
		splash = new JLabel("You Are Alone");
		splash.setHorizontalAlignment(SwingConstants.CENTER);
		splash.setVerticalAlignment(SwingConstants.CENTER);
		splash.setFont(new Font("Papyrus", Font.ITALIC, 100));
		splash.setBounds(0, (int) InputHandler.midPoint.y - InputHandler.screenSize.height / 5, InputHandler.screenSize.width, InputHandler.screenSize.height / 5);
		setLayout(null);
		add(splash);
	}
	
	public void fadeOut(long time){
		long startTime = System.currentTimeMillis();
		long endTime = startTime + time;
		long timeLeft;
		while(System.currentTimeMillis() < endTime){
			timeLeft = endTime - System.currentTimeMillis();
			splash.setForeground(new Color((float) (timeLeft / (float) time), (float) (timeLeft / (float) time), (float) (timeLeft / (float) time), (float) (timeLeft / (float) time)));
			splash.repaint();
		}
	}

}
