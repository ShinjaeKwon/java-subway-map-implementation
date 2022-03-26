package subway;

import subway.controller.MainController;
import subway.handler.InitHandler;

public class Application {
	public static void main(String[] args) {
		InitHandler.initStation();
		int state = 0;
		while (state == 0 || state == 1) {
			state = MainController.selectMain();
		}
	}
}
