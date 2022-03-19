package subway.controller;

import subway.domain.menu.MainMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;
import subway.management.LineManagement;
import subway.management.StationManagement;

public class MainController {

	private static StationManagement stationManagement;
	private static LineManagement lineManagement;

	public MainController() {
		stationManagement = new StationManagement();
		lineManagement = new LineManagement();
	}

	public static void selectMain() {
		PrintHandler.printMenu();
		PrintHandler.printSelect();
		MainMenu selectMenu = MainMenu.findMenu(InputHandler.input());
		if (selectMenu == null) {
			//TODO exception 발생
		}
		selectMenu.selectMenu();
	}

}
