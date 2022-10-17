package pt.iscte.poo.example;

import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;

public class Entity extends GameElement{
	
	// Entities exclusive attributes
	public int health;
	public int attack;
	
	// Entity Constructor
	public Entity(String name, Point2D position, int health, int attack) {
		super(name, position, 0);
		this.health = health;
		this.attack = attack;
	}

	// Getters
	public int getHealth() {
		return health;
	}
	
	public int getAttack() {
		return attack;
	}
	// Setters
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	// Entity related methods
	public void move(Direction d) {
		//Update Later
		int oldPositionX = this.getPosition().getX();
		int oldPositionY = this.getPosition().getY();
		Point2D newPosition = this.getPosition().plus(d.asVector());
		int newPositionX = newPosition.getX();
		int newPositionY= newPosition.getY();
		boolean withinBounds = (newPositionX < EngineExample.GRID_WIDTH && newPositionY < EngineExample.GRID_HEIGHT && newPositionX >= 0 && newPositionY >= 0);
		
		//Checks if new position is valid
		if  (withinBounds && !(EngineExample.getMapOccupied(newPositionX, newPositionY)) ){
			this.setPosition(newPosition);
			EngineExample.setMapOccupied(false,oldPositionX ,oldPositionY );
			EngineExample.setMapOccupied(true, newPositionX, newPositionY);
		}
	}
	
	// Because all entities layers are 0:
	@Override
	public int getLayer() {
		return 0;
	}
		
}
