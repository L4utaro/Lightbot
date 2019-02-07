package model;

import model.interfaces.IObjectGraphic;

import enums.Orientation;

public class Avatar implements IObjectGraphic {
	private Orientation orientation;

	public Avatar() {
		this.orientation = Orientation.RIGHT;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void turnRight() {
		if (this.orientation.equals(Orientation.UP)) {
			this.orientation = Orientation.RIGHT;
		} else if (this.orientation.equals(Orientation.RIGHT)) {
			this.orientation = Orientation.DOWN;
		} else if (this.orientation.equals(Orientation.DOWN)) {
			this.orientation = Orientation.LEFT;
		} else if (this.orientation.equals(Orientation.LEFT)) {
			this.orientation = Orientation.UP;
		}
	}

	public void turnLeft() {
		if (this.orientation.equals(Orientation.UP)) {
			this.orientation = Orientation.LEFT;
		} else if (this.orientation.equals(Orientation.LEFT)) {
			this.orientation = Orientation.DOWN;
		} else if (this.orientation.equals(Orientation.DOWN)) {
			this.orientation = Orientation.RIGHT;
		} else if (this.orientation.equals(Orientation.RIGHT)) {
			this.orientation = Orientation.UP;
		}
	}
}
