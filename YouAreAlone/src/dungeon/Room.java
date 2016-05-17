package dungeon;

import java.awt.Graphics2D;

public class Room {

	private enum Type {
		CAVE, CORRIDOR, MAZE, BOSS, TREASURE
	}

	private Type type;

	public Room(int type) {
		switch (type) {
		case 0:
			this.type = Type.CORRIDOR;
			break;
		case 1:
			this.type = Type.CAVE;
			break;
		case 2:
			this.type = Type.MAZE;
			break;
		case 3:
			this.type = Type.BOSS;
			break;
		case 4:
			this.type = Type.TREASURE;
		}
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics2D g2d){
		
	}
	
	public void generateRoom(){
		switch(type){
		case BOSS:
			break;
		case CAVE:
			break;
		case CORRIDOR:
			break;
		case MAZE:
			break;
		case TREASURE:
			break;
		default:
			break;
		}
	}

}
