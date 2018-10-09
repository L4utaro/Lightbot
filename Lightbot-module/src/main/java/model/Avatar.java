package model;

//import enums.Orientation;

public class Avatar implements IObjectGraphic {
	// private Orientation orientation;
	private Integer numOfOrientation;

	public Avatar() {
		// this.orientation = Orientation.RIGHT;
		this.numOfOrientation = 90;
	}

	public void turnLeft() {
		if (this.numOfOrientation == 0) {
			this.numOfOrientation = 360;
		}
		this.numOfOrientation -= 90;
	}

	public void turnRight() {
		if (this.numOfOrientation == 270) {
			this.numOfOrientation = -90;
		}
		this.numOfOrientation += 90;
	}

//	public Orientation getOrientation() {
//		return orientation;
//	}
//
//	public void setOrientation(Orientation orientation) {
//		this.orientation = orientation;
//	}

	public Integer getNumOfOrientation() {
		return numOfOrientation;
	}
}
