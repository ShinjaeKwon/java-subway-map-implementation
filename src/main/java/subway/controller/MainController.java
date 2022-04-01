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

//추상화 : 복잡한것을 숨기고 간단한 부분만 보여준다. -> 구현을 숨긴다.
//추상화 레벨 : 각 기능들의 레벨, 추상화레벨이 같은 것끼리 묶는다