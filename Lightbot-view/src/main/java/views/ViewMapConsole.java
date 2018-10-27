package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.LightStatus;
import enums.TypeOfBox;
import model.Map;
import modelo.Game;

public class ViewMapConsole implements Observer {
	private JFrame frame;
	private JPanel contentPane;
	private Map map;
	private Integer rowCnt;
	private Integer colCnt;
	
	public ViewMapConsole() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
	}
	
	public void draw() {
		rowCnt = this.map.getLimitsBoard().getWidht();
		colCnt = this.map.getLimitsBoard().getHigh();
	    frame.setSize(colCnt*120, rowCnt*40);
		
		String file = "";
		List<String> mapString = new ArrayList<>();
		for (int y = 0; y < this.map.getBoard().getBoxes()[0].length; y++) {
			for (int x = 0; x < this.map.getBoard().getBoxes().length; x++) {
				if (this.map.getBoard().getBoxes()[x][y] != null) {
					if (this.map.getBoard().getBoxes()[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
						file = file + "[  NO_WALK  ]";
					} else if (!(this.map.getBoard().getBoxes()[x][y].getObjectGraphic() == null)) {
						file = file + "[  AVATAR   ]";
					} else if (!(this.map.getBoard().getBoxes()[x][y].getLightStatus() == null)) {
						if(this.map.getBoard().getBoxes()[x][y].getLightStatus().equals(LightStatus.OFF)) {
							file = file + "[ LIGHT_OFF ]";
						} else {
							file = file + "[ LIGHT_ON  ]";
						}
					} else {
						file = file + "[   WALK    ]";
					}
				} else {
					file = file + "[  null  ]";
				}
			}
			mapString.add(file);
			//drawFile(y, file);
			file = "";
		}
		drawMap(mapString);
		frame.setContentPane(contentPane);
		frame.setVisible(true);
	}
	
	public void drawMap(List<String> mapString) {
		contentPane.removeAll();
		for(int i = 0; i < mapString.size(); i++) {
			JLabel label = new JLabel(mapString.get(i));
			label.setBounds( 20, i * 20 + 20, mapString.get(i).length(), 30);
			label.setOpaque(true);
			contentPane.add(label);
		}
	}

	public void drawMessage(String message) {
		contentPane.removeAll();
		JLabel label = new JLabel(message);
		label.setBounds( 40, 40, 40, 40);
		label.setOpaque(true);
		contentPane.add(label);
		frame.setContentPane(contentPane);
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
