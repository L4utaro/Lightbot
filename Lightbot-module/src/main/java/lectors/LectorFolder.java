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
		for (final File fileEntry : this.folder.listFiles()) {
			routesActions.add(fileEntry.getAbsolutePath());
		}
		return routesActions;
	}

	public Integer getCantOfPlayers() {
		return 2;
	}
}
