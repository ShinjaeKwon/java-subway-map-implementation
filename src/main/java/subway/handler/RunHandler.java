package subway.handler;

import subway.controller.MainController;

public class RunHandler {
	public static final int NORMAl_CODE = 0;
	private static final int EXIT_CODE = -1;

	public static void run() {
		InitHandler.initialize();
		int state = NORMAl_CODE;
		while (state != EXIT_CODE) {
			state = MainController.selectMain();
		}
	}
}
