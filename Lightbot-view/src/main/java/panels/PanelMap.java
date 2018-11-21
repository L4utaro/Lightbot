package panels;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.LightStatus;
import enums.Orientation;
import enums.TypeOfBox;
import model.Avatar;
import model.Map;
import model.Size;
import modelo.Game;

public class PanelMap implements Observer {
	private Map map;
	private JPanel panel;
	private Integer rowCnt;
	private Integer colCnt;
	private Size size;
	
	public PanelMap() {
	    panel = new JPanel();
	}
	
	public void draw() {
		panel.removeAll();
		rowCnt = this.map.getLimitsBoard().getWidht();
		colCnt = this.map.getLimitsBoard().getHigh();
		this.size = new Size(colCnt*40, rowCnt*40);
		panel.setSize(this.size.getHigh(), this.size.getWidht());
		panel.setLocation(new Point(350,20));
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

	
	@Override
	public void update(Observable observable, Object object) {
		this.map = ((Game) observable).getMap();
		draw();
	}

	public JPanel getPanel() {
		return panel;
	}

	public Size getSize() {
		return this.size;
	}
}