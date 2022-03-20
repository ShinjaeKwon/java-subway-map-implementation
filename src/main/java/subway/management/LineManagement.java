package subway.management;

import subway.check.FormChecking;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.menu.LineMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineManagement {

	private static final LineRepository lineRepository = new LineRepository();

	public static void addLine() {
		PrintHandler.printInputAddLine();
		String inputLineName = InputHandler.input();
		if (FormChecking.checkLineLength(inputLineName)) {
			PrintHandler.printLineLengthError();
			return;
		}
		if (lineRepository.findLineName(inputLineName)) {
			PrintHandler.printAlreadyLineName();
			return;
		}
		Line line = new Line(inputLineName);
		lineRepository.addLine(line);
		setAscendStationAndDescendStation(line);
	}

	private static void setAscendStationAndDescendStation(Line line) {
		PrintHandler.printInputAddLineAscend();
		String ascendName = InputHandler.input();
		PrintHandler.printInputAddLineDescend();
		String descendName = InputHandler.input();
		Station ascend = StationRepository.findStation(ascendName);
		Station descend = StationRepository.findStation(descendName);
		if (!FormChecking.nullCheck(ascend, descend)) {
			return;
		}
		lineRepository.addStationInLine(ascend, descend, line.getName());
		PrintHandler.printSuccessAddLine();
	}

	public static void lookupLines() {
		PrintHandler.printLines(lineRepository.lines());
	}

	public static void deleteLineByName() {
		PrintHandler.printDeleteLine();
		String inputLineName = InputHandler.input();
		if (!lineRepository.deleteLineByName(inputLineName)) {
			PrintHandler.printNotExistLine();
			return;
		}
		PrintHandler.printSuccessDeleteLine();
	}

	public static void selectLineManagement() {
		PrintHandler.printLineMenu();
		PrintHandler.printSelect();
		LineMenu selectMenu = LineMenu.findLineMenu(InputHandler.input());
		if (selectMenu == null) {
			PrintHandler.printNotSelectMenu();
			selectLineManagement();
			return;
		}
		selectMenu.selectMenu();
	}

}