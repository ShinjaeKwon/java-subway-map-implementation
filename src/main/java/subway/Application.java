package subway;

import subway.controller.MainController;
import subway.repository.StationRepository;

public class Application {
	public static void main(String[] args) {
		MainController mainController = new MainController();
		StationRepository.init();
		while (true) {
			mainController.selectMain();
		}
	}
}
