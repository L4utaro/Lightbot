package lectors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LectorFolder {
	final File folder;

	public LectorFolder(String routeFolder) {
		this.folder = new File(routeFolder);
	}

	public List<String> getRoutesOfActions() {
		List<String> routesActions = new ArrayList<>();
		try {
			for (final File fileEntry : this.folder.listFiles()) {
				routesActions.add(fileEntry.getAbsolutePath());
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("The folder don't exists");
		}
		return routesActions;
	}
}
