package dungeon;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utils.InputHandler;

public class Dungeon extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage gameImage = new BufferedImage((int) InputHandler.screenSize.getWidth(),
			(int) InputHandler.screenSize.getHeight(), BufferedImage.TYPE_INT_ARGB);
	private InputHandler input;
	private int xDif = 0, yDif = 0;
	private final double root2 = Math.sqrt(2.0);

	public Dungeon(long seed) {
		
	}

	public void update() {
		if (input.isKeyDown(KeyEvent.VK_W) && input.isKeyDown(KeyEvent.VK_A)) {
			moveUD(1 / root2);
			moveLR(1 / root2);
		} else if (input.isKeyDown(KeyEvent.VK_W) && input.isKeyDown(KeyEvent.VK_D)) {
			moveUD(1 / root2);
			moveLR(-1 / root2);
		} else if (input.isKeyDown(KeyEvent.VK_S) && input.isKeyDown(KeyEvent.VK_A)) {
			moveUD(-1 / root2);
			moveLR(1 / root2);
		} else if (input.isKeyDown(KeyEvent.VK_S) && input.isKeyDown(KeyEvent.VK_D)) {
			moveUD(-1 / root2);
			moveLR(-1 / root2);
		} else if (input.isKeyDown(KeyEvent.VK_W)) {
			moveUD(1);
		} else if (input.isKeyDown(KeyEvent.VK_A)) {
			moveLR(1);
		} else if (input.isKeyDown(KeyEvent.VK_S)) {
			moveUD(-1);
		} else if (input.isKeyDown(KeyEvent.VK_D)) {
			moveLR(-1);
		}
	}

	public void draw(Graphics2D g2d) {
		Graphics2D bufferedG = (Graphics2D) gameImage.getGraphics();
		//draw stuff to game image
		g2d.drawImage(gameImage, xDif, yDif, InputHandler.screenSize.width, InputHandler.screenSize.height, null);
	}

	private void moveUD(double amount) {
		yDif += amount;
	}

	private void moveLR(double amount) {
		xDif += amount;
	}

}
