package subway.management;

import subway.check.FormChecking;
import subway.domain.Station;
import subway.domain.menu.StationMenu;
import subway.handler.InputHandler;
import subway.handler.view.ErrorView;
import subway.handler.view.InputView;
import subway.handler.view.MainView;
import subway.handler.view.RemoveView;
import subway.handler.view.SuccessView;
import subway.repository.StationRepository;

public class StationManagement {

	public static void addStation() {
		InputView.printInputAddStation();
		String inputStationName = InputHandler.input();
		if (FormChecking.checkStationLength(inputStationName)) {
			ErrorView.printStationLengthError();
			return;
		}
		if (StationRepository.findExistStationName(inputStationName)) {
			ErrorView.printAlreadyStationName();
			return;
		}
		StationRepository.addStation(new Station(inputStationName));
		SuccessView.printSuccessAddStation();
	}

	public static void lookupStation() {
		MainView.printStations(StationRepository.stations());
	}

	public static void deleteStation() {
		RemoveView.printDeleteStation();
		String inputStationName = InputHandler.input();
		if (!StationRepository.deleteStation(inputStationName)) {
			ErrorView.printNotExistStation();
			return;
		}
		SuccessView.printSuccessDeleteStation();
	}

	public static void selectStationManagement() {
		MainView.printStationMenu();
		MainView.printSelect();
		StationMenu selectMenu = StationMenu.findStationMenu(InputHandler.input());
		if (selectMenu == null) {
			ErrorView.printNotSelectMenu();
			selectStationManagement();
			return;
		}
		selectMenu.selectMenu();
	}

}