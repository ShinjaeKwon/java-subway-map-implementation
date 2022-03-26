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
		MainMenu selectMenu = MainMenu.findMenu(InputHandler.input());
		if (selectMenu == null) {
			ErrorView.printNotSelectMenu();
			return ERROR_CODE;
		}
		return selectMenu.selectMenu();
	}

}