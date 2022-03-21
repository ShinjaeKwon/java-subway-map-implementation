package subway.check;

import subway.domain.Line;
import subway.domain.Station;
import subway.handler.PrintHandler;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class FormChecking {

	private static final int LENGTH_STANDARD = 2;

	public static boolean checkLineNameLength(String input) {
		return input.length() < LENGTH_STANDARD;
	}

	public static boolean checkStationLength(String input) {
		return input.length() < LENGTH_STANDARD;
	}

	public static boolean checkNull(Object input) {
		return input == null;
	}

	public static boolean checkNull(String inputLineName, String inputStationName, Integer order) {
		if (checkNull(inputLineName) || checkNull(inputStationName) || checkNull(order)) {
			return true;
		}
		return false;
	}

	public static boolean nullCheckAscendAndDescend(Station ascend, Station descend) {
		if (ascend == null) {
			PrintHandler.printNotExistStation();
			return false;
		}
		if (ascend == null) {
			PrintHandler.printNotExistStation();
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
		return checkLine.getStationList().size() <= 2;
	}
}