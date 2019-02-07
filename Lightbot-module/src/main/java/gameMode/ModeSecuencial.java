package gameMode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.LightStatus;
import enums.Orientation;
import gameMode.interfaces.Mode;
import model.Avatar;
import model.Command;
import model.Map;
import validators.ValidatorPathOfObjectGraphic;

public class ModeSecuencial implements Mode {
	private Command command;
	private Map map;
	private ValidatorPathOfObjectGraphic validatorPathAvatar;
	
	public ModeSecuencial(Command command, Map map) {
		this.command = command;
		this.map = map;
		this.validatorPathAvatar = new ValidatorPathOfObjectGraphic(map);
	}

	@Override
	public void changePosition() {
		if(this.command.getPointsPositions() != null) {
			changeAvatarPositions();
		} else if (this.command.getMovePositions() != null) {
			changeAvatarMovePositions(this.command.getMovePositions());
		}
	}

	private void changeAvatarMovePositions(Integer moves) {
		while(moves != 0 ) {
			moveAvatar();
			moves -=1;
		}
	}

	private void moveAvatar() {
		Point newAvatarPos = createAvatarPosForMoveAvatar();
		if(!this.validatorPathAvatar.validatePositionForObjectGraphic(newAvatarPos)){
			throw new IllegalArgumentException("The avatar get out of the path possible!");
		}
		this.map.moveObjectGraphic(this.map.getAvatarPos(), newAvatarPos);
		this.map.setAvatarPos(newAvatarPos);
	}

	private Point createAvatarPosForMoveAvatar() {
		Avatar avatar = ((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
		Point posAvatar = this.map.getAvatarPos();
		if(avatar.getOrientation().equals(Orientation.DOWN)){
			return new Point(posAvatar.x, posAvatar.y + 1);
		} else if(avatar.getOrientation().equals(Orientation.RIGHT)){
			return new Point(posAvatar.x + 1, posAvatar.y);
		} else if(avatar.getOrientation().equals(Orientation.UP)){
			return new Point(posAvatar.x, posAvatar.y - 1);
		} else {
			return new Point(posAvatar.x - 1, posAvatar.y);
		}
	}

	private void changeAvatarPositions() {
		for(Point point: this.command.getPointsPositions()) {
			List<Point> pointsPass = createPointsPass(point);
			for(Point newAvatarPos: pointsPass) {
				if(this.validatorPathAvatar.validatePositionForObjectGraphic(newAvatarPos)){
					throw new IllegalArgumentException("The avatar get out of the path possible!");
				}
				this.map.moveObjectGraphic(this.map.getAvatarPos(), newAvatarPos);
				this.map.setAvatarPos(newAvatarPos);
			}
		}
	}

	@Override
	public void changeOrientation() {
		if (this.command.getOrientation() != null) {
			setOrientation(map);
		} else if (this.command.getGirar() != null) {
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

	/**
	 * Crea los puntos por donde pasa el avatar, siempre aumentando o bajando en x y
	 * luego en y.
	 */
	private List<Point> createPointsPass(Point point) {
		List<Point> pointsPass = new ArrayList<>();
		while (point.equals(new Point(0, 0))) {
			if (point.x != 0) {
				if (point.x < 0) {
					pointsPass.add(new Point(this.map.getAvatarPos().x - 1, this.map.getAvatarPos().y));
					point.x -= 1;
				} else {
					pointsPass.add(new Point(this.map.getAvatarPos().x + 1, this.map.getAvatarPos().y));
					point.x += 1;
				}
			} else {
				if (point.y != 0) {
					if (point.y < 0) {
						pointsPass.add(new Point(this.map.getAvatarPos().x, this.map.getAvatarPos().y - 1));
						point.y -= 1;
					} else {
						pointsPass.add(new Point(this.map.getAvatarPos().x, this.map.getAvatarPos().y + 1));
						point.y += 1;
					}
				}
			}
		}
		return pointsPass;
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
