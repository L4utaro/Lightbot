package model;

import enums.LightStatus;
import enums.TypeOfBox;
import model.interfaces.IObjectGraphic;

public class Box {
	private TypeOfBox typeOfBox;
	private LightStatus lightStatus;
	private IObjectGraphic objectGraphic;

	public Box (TypeOfBox typeOfBox) {
		this.typeOfBox = typeOfBox;
	}
	
	public Box (TypeOfBox typeOfBox, IObjectGraphic objectGraphic) {
		this.typeOfBox = typeOfBox;
		this.objectGraphic = objectGraphic;
	}

	public Box (TypeOfBox typeOfBox, LightStatus lightStatus) {
		this.typeOfBox = typeOfBox;
		this.lightStatus = lightStatus;
	}
	
	public Box (TypeOfBox typeOfBox, LightStatus lightStatus, IObjectGraphic objectGraphic) {
		this.typeOfBox = typeOfBox;
		this.lightStatus = lightStatus;
		this.objectGraphic = objectGraphic;
	}

	public TypeOfBox getTypeOfBox() {
		return typeOfBox;
	}

	public void setTypeOfBox(TypeOfBox typeOfBox) {
		this.typeOfBox = typeOfBox;
	}
	
	public IObjectGraphic getObjectGraphic() {
		return objectGraphic;
	}

	public void setObjectGraphic(IObjectGraphic objectGraphic) {
		this.objectGraphic = objectGraphic;
	}	

	public void changeStateLight() {
		this.lightStatus = (this.lightStatus == LightStatus.OFF) ? LightStatus.ON : LightStatus.OFF;
	}

	public void setLightStatus(LightStatus lightStatus) {
		this.lightStatus = lightStatus;
	}

	public LightStatus getLightStatus() {
		return lightStatus;
	}
}
