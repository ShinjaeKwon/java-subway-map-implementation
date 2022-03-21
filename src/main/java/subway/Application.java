package subway;

import subway.controller.MainController;
import subway.repository.StationRepository;

public class Application {
	public static void main(String[] args) {
		StationRepository.init();
		while (true) {
			MainController.selectMain();
		}
	}
}
