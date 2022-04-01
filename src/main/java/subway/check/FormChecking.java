package subway.check;

import subway.domain.Line;
import subway.domain.Station;
import subway.handler.view.ErrorView;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class FormChecking {

	public static final int LINE_INCLUDE_STATION_NUMBER = 2;

	public static boolean checkNull(Object... inputs) {
		for (Object input : inputs) {
			if (input == null) {
				return true;
			}
		}
		return false;
	}

	public static boolean nullCheckAscendAndDescend(Station ascend, Station descend) {
		if (ascend == null || descend == null) {
			ErrorView.printNotExistStation();
			return false;
		}
		return true;
	}

	public static boolean checkExistLine(String inputLineName) {
		return LineRepository.findExistLineName(inputLineName);
	}

	public static boolean checkExistStation(String inputStationName) {
		return StationRepository.findExistStationName(inputStationName);
	}

	public static boolean checkNumber(String inputNumber) {
		try {
			Integer.parseInt(inputNumber);
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}

	}

	public static boolean checkSectionInLineLength(String inputLineName) {
		Line checkLine = LineRepository.findLine(inputLineName);
		return checkLine.getStationList().size() <= LINE_INCLUDE_STATION_NUMBER;
	}
}