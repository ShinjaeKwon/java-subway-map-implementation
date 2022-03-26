package subway.controller;

import subway.domain.menu.MainMenu;
import subway.handler.InputHandler;
import subway.handler.view.ErrorView;
import subway.handler.view.MainView;

public class MainController {

	public static void selectMain() {
		MainView.printMenu();
		MainView.printSelect();
		MainMenu selectMenu = MainMenu.findMenu(InputHandler.input());
		if (selectMenu == null) {
			ErrorView.printNotSelectMenu();
			return;
		}
		selectMenu.selectMenu();
	}

}