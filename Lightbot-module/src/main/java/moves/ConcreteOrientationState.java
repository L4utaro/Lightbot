package moves;

import model.Avatar;

public class ConcreteOrientationState implements OrientationState{

	@Override
	public void turnRight(Avatar avatar) {
		//puedo tener una List<Orientation> orientations (UP, Right, down, left)
		//desde el controller, se envia el map
	}

	@Override
	public void turnLeft(Avatar avatar) {
		
	} 

}
