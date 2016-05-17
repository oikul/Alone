package main;

import java.awt.Graphics2D;
import java.awt.Image;

import dungeon.Dungeon;
import menus.ConnectMenu;
import menus.LoadGameMenu;
import menus.MainMenu;
import menus.NewGameMenu;
import utils.AbstractMain;
import utils.Menu;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 1L;
	private Menu mainMenu, newMenu, loadMenu, connectMenu;
	private StartSplash splash = new StartSplash();
	private Dungeon dungeon;
	private State state = State.MENU_MAIN;

	private enum State {
		MENU_MAIN, MENU_NEW, MENU_LOAD, MENU_CONNECT, GAME_DUNGEON, GAME_INVENTORY
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	@Override
	public void initialise() {
		setTitle("You Are Alone");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		mainMenu = new MainMenu("backgrounds/graveyard.png");
		this.add(mainMenu);
		running = true;
		setVisible(running);
	}

	@Override
	public void update() {
		int change = 0;
		switch (state) {
		case GAME_DUNGEON:
			break;
		case GAME_INVENTORY:
			break;
		case MENU_MAIN:
			change = mainMenu.update();
			if (change == 1) {
				state = State.MENU_NEW;
				newMenu = new NewGameMenu("backgrounds/graveyard.png");
				remove(mainMenu);
				add(newMenu);
				setVisible(running);
			} else if (change == 2) {
				state = State.MENU_LOAD;
				loadMenu = new LoadGameMenu("backgrounds/graveyard.png");
				remove(mainMenu);
				add(loadMenu);
				setVisible(running);
			} else if (change == 3) {
				state = State.MENU_CONNECT;
				connectMenu = new ConnectMenu("backgrounds/graveyard.png");
				remove(mainMenu);
				add(connectMenu);
				setVisible(running);
			} else if (change == 4) {
				System.exit(0);
			}
			break;
		case MENU_NEW:
			change = newMenu.update();
			if (change == 1) {
				state = State.GAME_DUNGEON;
				remove(newMenu);
				add(splash);
				setVisible(running);
				splash.fadeOut(3000);
				dungeon = new Dungeon(((NewGameMenu) newMenu).getSeed());
				remove(splash);
				add(dungeon);
				setVisible(running);
			} else if (change == 2) {
				state = State.MENU_MAIN;
				mainMenu = new MainMenu("backgrounds/graveyard.png");
				remove(newMenu);
				add(mainMenu);
				setVisible(running);
			}
			break;
		case MENU_LOAD:
			change = loadMenu.update();
			if (change == 1) {
				state = State.GAME_DUNGEON;
				remove(loadMenu);
				setVisible(running);
			} else if (change == 2) {
				state = State.MENU_MAIN;
				mainMenu = new MainMenu("backgrounds/graveyard.png");
				remove(loadMenu);
				add(mainMenu);
				setVisible(running);
			}
			break;
		case MENU_CONNECT:
			change = connectMenu.update();
			if (change == 1) {
				state = State.GAME_DUNGEON;
				remove(connectMenu);
				setVisible(running);
			} else if (change == 2) {
				state = State.MENU_MAIN;
				mainMenu = new MainMenu("backgrounds/graveyard.png");
				remove(connectMenu);
				add(mainMenu);
				setVisible(running);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void draw() {
		Graphics2D g2d = (Graphics2D) getGraphics();
		Image offImage = createImage(getWidth(), getHeight());
		Graphics2D offGraphics = (Graphics2D) offImage.getGraphics();
		switch (state) {
		case GAME_DUNGEON:
			dungeon.draw(offGraphics);
			g2d.drawImage(offImage, 0, 0, getWidth(), getHeight(), null);
			break;
		case GAME_INVENTORY:
			g2d.drawImage(offImage, 0, 0, getWidth(), getHeight(), null);
			break;
		default:
			break;
		}
	}

}
