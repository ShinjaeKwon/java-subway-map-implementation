package subway.controller;

import subway.management.LineManagement;
import subway.management.StationManagement;
import subway.menu.MainMenu;

public class MainController {

	private static MainMenu mainMenu;
	private static StationManagement stationManagement;
	private static LineManagement lineManagement;

	public MainController() {
		mainMenu = new MainMenu();
		stationManagement = new StationManagement();
		lineManagement = new LineManagement();
	}

}
