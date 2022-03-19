package subway.management;

import subway.domain.Station;
import subway.handler.PrintHandler;
import subway.repository.StationRepository;

public class StationManagement {

	private static StationRepository stationRepository = new StationRepository();

	public static void addStation(String inputStationName) {
		stationRepository.addStation(new Station(inputStationName));
	}

	public static void lookupStation() {
		PrintHandler.printStations(stationRepository.stations());
	}

	public static boolean deleteStation(String inputStationName) {
		return stationRepository.deleteStation(inputStationName);
	}

}
