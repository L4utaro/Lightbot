package commands.move;

import java.awt.Point;

import enums.Orientation;

public class PositionMove {
	
	public Point getPositionForMove(Point avatarPosition, Orientation orientation) {
		switch(orientation) {
			case UP:
				return new Point(avatarPosition.x, avatarPosition.y - 1);
			case LEFT:
				return new Point(avatarPosition.x - 1, avatarPosition.y);
			case DOWN:
				return new Point(avatarPosition.x , avatarPosition.y + 1);
			case RIGHT:
				return new Point(avatarPosition.x + 1, avatarPosition.y);
		}
		return null;
	}
	
}
