package subway.management;

import subway.check.FormChecking;
import subway.domain.Station;
import subway.domain.menu.StationMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;
import subway.repository.StationRepository;

public class StationManagement {

	private static final StationRepository stationRepository = new StationRepository();

	public static void addStation() {
		PrintHandler.printInputAddStation();
		String inputStationName = InputHandler.input();
		if (FormChecking.checkStationLength(inputStationName)) {
			PrintHandler.printStationLengthError();
			return;
		}
		if (stationRepository.findExistStationName(inputStationName)) {
			PrintHandler.printAlreadyStationName();
			return;
		}
		stationRepository.addStation(new Station(inputStationName));
		PrintHandler.printSuccessAddStation();
	}

	public static void lookupStation() {
		PrintHandler.printStations(stationRepository.stations());
	}

	public static void deleteStation() {
		PrintHandler.printDeleteStation();
		String inputStationName = InputHandler.input();
		if (!stationRepository.deleteStation(inputStationName)) {
			PrintHandler.printNotExistStation();
			return;
		}
		PrintHandler.printSuccessDeleteStation();
	}

	public static void selectStationManagement() {
		PrintHandler.printStationMenu();
		PrintHandler.printSelect();
		StationMenu selectMenu = StationMenu.findStationMenu(InputHandler.input());
		if (selectMenu == null) {
			PrintHandler.printNotSelectMenu();
			selectStationManagement();
			return;
		}
		selectMenu.selectMenu();
	}

	public static void selectSectionManagement() {
	}
}