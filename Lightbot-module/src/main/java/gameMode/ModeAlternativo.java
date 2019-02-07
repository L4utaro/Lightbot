package gameMode;

import java.awt.Point;

import enums.LightStatus;
import enums.Orientation;
import enums.TypeOfBox;
import gameMode.interfaces.Mode;
import model.Avatar;
import model.Command;
import model.Map;

public class ModeAlternativo implements Mode {
	private Command command;
	private Map map;

	public ModeAlternativo(Command command, Map map) {
		this.command = command;
		this.map = map;
	}

	@Override
	public void changePosition() {
		if (this.command.getPointsPositions() != null) {
			changeAvatarPositions();
		} else if (this.command.getMovePositions() != null) {
			changeAvatarMovePositions(this.command.getMovePositions());
		}
	}

	@Override
	public void changeOrientation() {
		if (this.command.getOrientation() != null) {
			setOrientation(map);
		} else {
			girarAvatar(map);
		}
	}

	@Override
	public void changeLight() {
		if (this.command.getLight() != null) {
			if (this.command.getLight().equals("ON-OFF")) {
				this.map.getBox(map.getAvatarPos()).changeStateLight();
			} else if (this.command.getLight().equals("ON")) {
				this.map.getBox(map.getAvatarPos()).setLightStatus(LightStatus.ON);
			} else {
				this.map.getBox(map.getAvatarPos()).setLightStatus(LightStatus.OFF);
			}
		}
	}

	private void changeAvatarMovePositions(Integer moves) {
		Point newAvatarPos = createAvatarPosForMoveAvatar(moves);
		this.map.moveObjectGraphic(this.map.getAvatarPos(), newAvatarPos);
		this.map.setAvatarPos(newAvatarPos);
	}

	private Point createAvatarPosForMoveAvatar(Integer moves) {
		Avatar avatar = ((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
		Point posAvatar = this.map.getAvatarPos();
		if(avatar.getOrientation().equals(Orientation.DOWN)){
			return new Point(posAvatar.x, posAvatar.y + moves);
		} else if(avatar.getOrientation().equals(Orientation.RIGHT)){
			return new Point(posAvatar.x + moves, posAvatar.y);
		} else if(avatar.getOrientation().equals(Orientation.UP)){
			return new Point(posAvatar.x, posAvatar.y - moves);
		} else {
			return new Point(posAvatar.x - moves, posAvatar.y);
		}
	}

	private void changeAvatarPositions() {
		for (Point point : this.command.getPointsPositions()) {
			Point newAvatarPos = createPointsPass(point);
			if (this.map.getBox(newAvatarPos).getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
				throw new IllegalArgumentException("The avatar get out of the path possible!");
			}
			this.map.moveObjectGraphic(this.map.getAvatarPos(), newAvatarPos);
			this.map.setAvatarPos(newAvatarPos);
		}
	}

	private Point createPointsPass(Point point) {
		return new Point(this.map.getAvatarPos().x + point.x, this.map.getAvatarPos().y + point.y);
	}

	private void setOrientation(Map map) {
		((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).setOrientation(this.command.getOrientation());
	}

	private void girarAvatar(Map map) {
		if (this.command.getGirar().equals("RIGHT")) {
			((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).turnRight();
		} else {
			((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic()).turnLeft();
		}
	}
}
