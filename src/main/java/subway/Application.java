package subway;

import subway.controller.MainController;
import subway.repository.StationRepository;

public class Application {
	public static void main(String[] args) {
		StationRepository.init();
		int state = 0;
		while (state == 0 || state == 1) {
			state = MainController.selectMain();
		}
	}
}
