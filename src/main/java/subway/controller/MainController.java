package subway.controller;

import subway.domain.menu.MainMenu;
import subway.handler.InputHandler;
import subway.handler.view.ErrorView;
import subway.handler.view.MainView;

public class MainController {

	public static final int ERROR_CODE = 1;

	public static int selectMain() {
		MainView.printMenu();
		MainView.printSelect();
		MainMenu selectMainMenu = MainMenu.findMenu(InputHandler.input());
		if (selectMainMenu == null) {
			ErrorView.printNotSelectMenu();
			return ERROR_CODE;
		}
		return selectMainMenu.selectMenu();
	}

}