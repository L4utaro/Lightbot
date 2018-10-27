package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
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
	
	public ViewMap() {
		frame = new JFrame("Lightbot");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    panel = new JPanel(new BorderLayout());
		rowCnt = 3;
		colCnt = 3;
	    frame.setBounds(rowCnt*40, colCnt*40, colCnt*40, colCnt*40);//check this
	    panel.setBounds(rowCnt*40, colCnt*40, colCnt*40, colCnt*40);
	    
	    frame.setContentPane(panel);
	    frame.setVisible(true);
	}
	public void draw() {
	    
	    
	    //panel.setLayout(new GridLayout(colCnt,rowCnt));//cantColum, cantFila

	    Point actualPoint;
	    for (int y = 0; y < rowCnt; y++) {
			for (int x = 0; x < colCnt; x++) {
				actualPoint = new Point(x,y);
				if (this.map.getBoard().getBoxes()[x][y] != null) {
					if (this.map.getBoard().getBoxes()[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
						drawBox(actualPoint, Color.darkGray);
//					} else if (!(this.map.getBoard().getBoxes()[x][y].getObjectGraphic() == null)) {
//						drawAvatar(actualPoint);
//					} else {
//						drawBox(actualPoint, Color.cyan);
					}
				} else {
					drawBox(actualPoint, Color.gray);
				}
			}
	    }
	}

	public void drawBox(Point actualPoint, Color color) {
		JLabel label = new JLabel("");
		label.setBounds(actualPoint.x*40, actualPoint.y*40,40,40);
		label.setBackground(color);
        panel.add(label);
	}

	public void drawAvatar(Point actualPoint) {
		JLabel label = new JLabel("A");
		label.setBounds(actualPoint.x*40, actualPoint.y*40,40,40);
		label.setBackground(Color.cyan);
        panel.add(label);
//        panel.add(label).setBackground(Color.cyan);
//        panel.add(new JLabel("A")).setBackground(Color.cyan);
//        panel.getComponent(actualPoint.x + actualPoint.y).setBackground(Color.cyan);
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