package views;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.LightStatus;
import enums.Orientation;
import enums.TypeOfBox;
import model.Avatar;
import model.Map;
import modelo.Game;

public class ViewMap implements Observer {
	private Map map;
	private JFrame frame;
	private JPanel panel;
	private Integer rowCnt;
	private Integer colCnt;
	
	public ViewMap() {
		frame = new JFrame("Lightbot");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    panel = new JPanel();
	}
	
	public void draw() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		rowCnt = this.map.getLimitsBoard().getWidht();
		colCnt = this.map.getLimitsBoard().getHigh();
		panel.setSize(colCnt*40, rowCnt*40);
	    frame.setSize(colCnt*40, rowCnt*40);//check this

	    Point actualPoint;
	    for (int y = 0; y < rowCnt; y++) {
			for (int x = 0; x < colCnt; x++) {
				actualPoint = new Point(x,y);
				if (this.map.getBoard().getBoxes()[x][y] != null) {
					if (this.map.getBoard().getBoxes()[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
						drawBox(actualPoint, Color.GRAY);
					} else if (!(this.map.getBoard().getBoxes()[x][y].getObjectGraphic() == null)) {
						drawAvatar(actualPoint);
					} else if (!(this.map.getBoard().getBoxes()[x][y].getLightStatus() == null)) {
						if(this.map.getBoard().getBoxes()[x][y].getLightStatus().equals(LightStatus.OFF)) {
							drawBox(actualPoint, Color.yellow);
						} else {
							drawBox(actualPoint, Color.orange);
						}
					}else {
						drawBox(actualPoint, Color.cyan);
					}
				} else {
					drawBox(actualPoint, Color.gray);
				}
			}
	    }
	    
	     frame.add(panel);
	     frame.setVisible(true);
	}

	public void drawBox(Point actualPoint, Color color) {
		JLabel label = new JLabel("         ");
		label.setBounds(actualPoint.x*40, actualPoint.y*40,40,40);
		label.setBackground(color);
		label.setOpaque(true);
        panel.add(label);
	}

	public void drawAvatar(Point actualPoint) {
		JLabel label = createStringByOrientation();
		label.setBounds(actualPoint.x*40, actualPoint.y*40,40,40);
		label.setBackground(Color.cyan);
		if (!(this.map.getBoard().getBoxes()[actualPoint.x][actualPoint.y].getLightStatus() == null)) {
			if(this.map.getBoard().getBoxes()[actualPoint.x][actualPoint.y].getLightStatus().equals(LightStatus.OFF)) {
				label.setBackground(Color.yellow);
			} else {
				label.setBackground(Color.orange);
			}
		}
		label.setOpaque(true);
        panel.add(label);
	}

	public JLabel createStringByOrientation() {
		if(((Avatar)this.map.getBoard().getBox(this.map.getAvatarPos()).getObjectGraphic()).getOrientation().equals(Orientation.RIGHT)) {
			return new JLabel("   →    ");
		} else if(((Avatar)this.map.getBoard().getBox(this.map.getAvatarPos()).getObjectGraphic()).getOrientation().equals(Orientation.UP)) {
			return new JLabel("   ↑    ");
		} else if(((Avatar)this.map.getBoard().getBox(this.map.getAvatarPos()).getObjectGraphic()).getOrientation().equals(Orientation.LEFT)) {
			return new JLabel("   ←    ");
		}
		return new JLabel("   ↓    ");
	}

	public void drawMessage(String message) {
		panel.removeAll();
		JLabel label = new JLabel(message);
		label.setBounds( 40, 40, 40, 40);
		label.setOpaque(true);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	@Override
	public void update(Observable observable, Object object) {
		this.map = ((Game) observable).getMap();
		if(((Game) observable).getMessage() == null || ((Game) observable).getMessage().isEmpty()) {
			draw();
		} else {
			drawMessage(((Game) observable).getMessage());
		}
	}
}