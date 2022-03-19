package subway.management;

import subway.domain.Station;
import subway.domain.menu.StationMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;
import subway.repository.StationRepository;

public class StationManagement {

	private static StationRepository stationRepository = new StationRepository();

	public static void addStation() {
		PrintHandler.printInputAddStation();
		String inputStationName = InputHandler.input();
		//inputStationName check
		stationRepository.addStation(new Station(inputStationName));
		PrintHandler.printSuccessAddStation();
	}

	public static void lookupStation() {
		PrintHandler.printStations(stationRepository.stations());
	}

	public static boolean deleteStation() {
		PrintHandler.printDeleteStation();
		String inputStationName = InputHandler.input();
		//inputStationName check
		PrintHandler.printSuccessDeleteStation();
		return stationRepository.deleteStation(inputStationName);
	}

	public static void selectStationManagement() {
		PrintHandler.printStationMenu();
		PrintHandler.printSelect();
		StationMenu selectMenu = StationMenu.findStationMenu(InputHandler.input());
		if (selectMenu == null) {
			//TODO exception 발생
		}
		selectMenu.selectMenu();
	}

}
