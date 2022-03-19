package subway.management;

import subway.domain.Line;
import subway.handler.PrintHandler;
import subway.repository.LineRepository;

public class LineManagement {

	private static LineRepository lineRepository = new LineRepository();

	public static void addLine(String inputLineName) {
		lineRepository.addLine(new Line(inputLineName));
	}

	public static void lookupLines() {
		PrintHandler.printLines(lineRepository.lines());
	}

	public static boolean deleteStation(String inputStationName) {
		return lineRepository.deleteLineByName(inputStationName);
	}
}
