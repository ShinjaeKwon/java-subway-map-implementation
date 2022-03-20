package subway.controller;

import subway.domain.menu.MainMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;

public class MainController {

	public static void selectMain() {
		PrintHandler.printMenu();
		PrintHandler.printSelect();
		MainMenu selectMenu = MainMenu.findMenu(InputHandler.input());
		if (selectMenu == null) {
			PrintHandler.printNotSelectMenu();
			return;
		}
		selectMenu.selectMenu();
	}

}