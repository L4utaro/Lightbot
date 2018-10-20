package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Map;

public class ViewMap extends JFrame implements Observer{
	private Map map;
	
	public ViewMap() {
		
	}

	@Override
	public void update(Observable observable, Object object) {
		
	}
}
