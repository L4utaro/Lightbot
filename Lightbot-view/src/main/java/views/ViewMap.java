package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.TypeOfBox;
import model.Map;
import modelo.Game;

public class ViewMap extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private Map map;
	private JFrame frame;
	private JPanel panel;
	private Integer rowCnt;
	private Integer colCnt;
	
	//public ViewMap() {
	public void draw() {
		frame = new JFrame("Lightbot");
	    panel = new JPanel();
		rowCnt = this.map.getLimitsBoard().getWidht();
		colCnt = this.map.getLimitsBoard().getHigh();
	    frame.setSize(colCnt*40, rowCnt*40);//check this
	    
	    
	    panel.setLayout(new GridLayout(colCnt,rowCnt));//cantColum, cantFila

	    Point actualPoint;
	    for (int y = 0; y < rowCnt; y++) {
			for (int x = 0; x < colCnt; x++) {
				actualPoint = new Point(x,y);
				if (this.map.getBoard().getBoxes()[x][y] != null) {
					if (this.map.getBoard().getBoxes()[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
						drawBox(actualPoint, Color.yellow);
					} else if (!(this.map.getBoard().getBoxes()[x][y].getObjectGraphic() == null)) {
						drawAvatar(actualPoint);
					} else {
						drawBox(actualPoint, Color.cyan);
					}
				} else {
					drawBox(actualPoint, Color.gray);
				}
//				if(this.map.getAvatarPos().equals(actualPoint)) {
//					drawAvatar(actualPoint);
//				} else if(this.map.getListOfLightPos().contains(actualPoint)) {
//					drawBox(actualPoint, Color.yellow);
//				} else if(this.map.getBoard().getBoxes()[x][y].getTypeOfBox().equals(TypeOfBox.WALK)) {
//					drawBox(actualPoint, Color.cyan);
//				} else {
//					drawBox(actualPoint, Color.gray);
//				}
			}
	    }
	    
	     frame.setContentPane(panel);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setVisible(true);
	}

	public void drawBox(Point actualPoint, Color color) {
        panel.add(new JLabel("")).setBackground(color);
	}

	public void drawAvatar(Point actualPoint) {
        panel.add(new JLabel("A")).setBackground(Color.cyan);
	}

	@Override
	public void update(Observable observable, Object object) {
		this.map = ((Game) observable).getMap();
		this.map.printMap();
		draw();
	}
}
//public void drawEmptyBox(Point actualPoint) {
//panel.add(new JTextField(""));
//panel.getComponentAt(actualPoint).setBackground(Color.gray);
//}
//
//public void drawBoxWalk(Point actualPoint) {
//panel.add(new JTextField(""));
//panel.getComponentAt(actualPoint).setBackground(Color.cyan);
//}
//
//public void drawLigth(Point actualPoint) {
//panel.add(new JTextField(""));
//panel.getComponentAt(actualPoint).setBackground(Color.yellow);
//
//}