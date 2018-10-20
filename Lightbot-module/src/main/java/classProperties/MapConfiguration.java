package classProperties;

import java.awt.Point;
import java.util.List;

import model.Size;

public class MapConfiguration {
	private Size mapSize;
	private Point posAvatar;
	private List<Point> posLight;
	private List<Point> posOfPathPossible;
	
	public MapConfiguration(Size mapSize, Point posAvatar, List<Point> posLight, List<Point> posOfPathPossible) {
		this.mapSize = mapSize;
		this.posAvatar = posAvatar;
		this.posLight = posLight;
		this.posOfPathPossible = posOfPathPossible;
	}

	public Size getMapSize() {
		return mapSize;
	}

	public void setMapSize(Size mapSize) {
		this.mapSize = mapSize;
	}

	public Point getPosAvatar() {
		return posAvatar;
	}

	public void setPosAvatar(Point posAvatar) {
		this.posAvatar = posAvatar;
	}

	public List<Point> getPosLight() {
		return posLight;
	}

	public void setPosLight(List<Point> posLight) {
		this.posLight = posLight;
	}

	public List<Point> getPosOfPathPossible() {
		return posOfPathPossible;
	}

	public void setPosOfPathPossible(List<Point> posOfPathPossible) {
		this.posOfPathPossible = posOfPathPossible;
	}
}
