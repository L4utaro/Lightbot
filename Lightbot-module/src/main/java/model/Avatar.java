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
}
