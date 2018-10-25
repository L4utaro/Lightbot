package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import enums.TypeOfBox;

public class ViewMapConsole extends JFrame implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
//	public void printBoard() {
//		String file = "";
//		for (int y = 0; y < boxes[0].length; y++) {
//			for (int x = 0; x < boxes.length; x++) {
//				if (boxes[x][y] != null) {
//					if (boxes[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
//						file = file + "[ NO_WALK]";
//					} else if (!(boxes[x][y].getObjectGraphic() == null)) {
//						file = file + "[" +boxes[x][y].getObjectGraphic().getClass().getName() + "]";
//					} else {
//						file = file + "[ WALK]";
//					}
//				} else {
//					file = file + "[ null]";
//				}
//			}
//			System.out.println(file);
//			file = "";
//		}
//	}
}
