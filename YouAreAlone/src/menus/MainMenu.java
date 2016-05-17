package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import utils.InputHandler;
import utils.Menu;

public class MainMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JButton newGame, loadGame, connect, exit;
	private InputHandler newHandler, loadHandler, connectHandler, exitHandler;

	public MainMenu(String background) {
		super(background);
		title = new JLabel("You Are Alone");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 100));
		title.setForeground(Color.darkGray);
		title.setBounds(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height / 5);
		newGame = new JButton("New Game");
		newHandler = new InputHandler(newGame);
		newGame.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) 7 * InputHandler.screenSize.height / 16,
				InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 10);
		loadGame = new JButton("Load Game");
		loadHandler = new InputHandler(loadGame);
		loadGame.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) 9 * InputHandler.screenSize.height / 16, InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		connect = new JButton("Connect");
		connectHandler = new InputHandler(connect);
		connect.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) 11 * InputHandler.screenSize.height / 16, InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 10);
		exit = new JButton("Exit");
		exitHandler = new InputHandler(exit);
		exit.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) 13 * InputHandler.screenSize.height / 16, InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		setLayout(null);
		add(title);
		add(newGame);
		add(loadGame);
		add(connect);
		add(exit);
	}

	@Override
	public int update() {
		int change = 0;
		if (newHandler.isMouseDown(MouseEvent.BUTTON1)) {
			change = 1;
		}
		if (loadHandler.isMouseDown(MouseEvent.BUTTON1)) {
			change = 2;
		}
		if (connectHandler.isMouseDown(MouseEvent.BUTTON1)) {
			change = 3;
		}
		if (exitHandler.isMouseDown(MouseEvent.BUTTON1)) {
			change = 4;
		}
		return change;
	}

}
