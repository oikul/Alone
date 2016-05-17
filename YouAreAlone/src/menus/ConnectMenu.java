package menus;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import utils.InputHandler;
import utils.Menu;

public class ConnectMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private JButton connect, cancel;
	private InputHandler connectHandler, cancelHandler;

	public ConnectMenu(String background) {
		super(background);
		connect = new JButton("Connect");
		connect.setBounds((int) InputHandler.midPoint.x / 2 - InputHandler.screenSize.width / 12,
				(int) (5 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		connectHandler = new InputHandler(connect);
		cancel = new JButton("Cancel");
		cancel.setBounds((int) (3 * InputHandler.midPoint.x / 2) - InputHandler.screenSize.width / 12,
				(int) (5 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		cancelHandler = new InputHandler(cancel);
		setLayout(null);
		add(connect);
		add(cancel);
	}

	@Override
	public int update() {
		int change = 0;
		if (connectHandler.isMouseDown(MouseEvent.BUTTON1)) {
			change = 1;
		} else if (cancelHandler.isMouseDown(MouseEvent.BUTTON1)) {
			change = 2;
		}
		return change;
	}

}
