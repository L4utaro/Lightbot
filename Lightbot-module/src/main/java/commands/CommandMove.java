package commands;

import java.awt.Point;

import commands.interfaces.ICommand;
import commands.move.PositionMove;
import model.Avatar;
import model.Map;

public class CommandMove implements ICommand {
	private PositionMove positionMove;
	
	public CommandMove() {
		this.positionMove = new PositionMove();
	}

	public void executeCommand(Map map) {
		moveAvatar(map, (Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
	}

	public void moveAvatar(Map map, Avatar avatar) {
		makeChangePositionOfAvatar(map, map.getAvatarPos(), 
				this.positionMove.getPositionForMove(map.getAvatarPos(), avatar.getOrientation())
				, avatar);
	}

	public void makeChangePositionOfAvatar(Map map, Point oldPositionAvatar, Point newPositionAvatar, Avatar avatar) {
		if (!map.isOcupatePosition(newPositionAvatar)) {
			map.addBoxObjectGraphic(newPositionAvatar, avatar);
			map.setAvatarPos(newPositionAvatar);
			map.deleteObjectGraphic(oldPositionAvatar);
		}
	}
}
