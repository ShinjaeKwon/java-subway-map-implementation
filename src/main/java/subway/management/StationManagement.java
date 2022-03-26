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

	private static final StationRepository stationRepository = new StationRepository();

	public static void addStation() {
		InputView.printInputAddStation();
		String inputStationName = InputHandler.input();
		if (FormChecking.checkStationLength(inputStationName)) {
			ErrorView.printStationLengthError();
			return;
		}
		if (stationRepository.findExistStationName(inputStationName)) {
			ErrorView.printAlreadyStationName();
			return;
		}
		stationRepository.addStation(new Station(inputStationName));
		SuccessView.printSuccessAddStation();
	}

	public static void lookupStation() {
		MainView.printStations(stationRepository.stations());
	}

	public static void deleteStation() {
		RemoveView.printDeleteStation();
		String inputStationName = InputHandler.input();
		if (!stationRepository.deleteStation(inputStationName)) {
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