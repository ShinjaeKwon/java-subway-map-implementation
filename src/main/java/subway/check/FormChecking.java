package subway.check;

import subway.domain.Station;
import subway.handler.PrintHandler;

public class FormChecking {

	private static final int LENGTH_STANDARD = 2;

	public static boolean checkLineLength(String input) {
		return input.length() < LENGTH_STANDARD;
	}

	public static boolean checkStationLength(String input) {
		return input.length() < LENGTH_STANDARD;
	}

	public static boolean nullCheck(Station ascend, Station descend) {
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
}