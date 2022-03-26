package subway.management;

import subway.check.FormChecking;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.menu.LineMenu;
import subway.handler.InputHandler;
import subway.handler.view.ErrorView;
import subway.handler.view.InputView;
import subway.handler.view.MainView;
import subway.handler.view.RemoveView;
import subway.handler.view.SuccessView;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineManagement {

	private static final LineRepository lineRepository = new LineRepository();

	public static void addLine() {
		InputView.printInputAddLine();
		String inputLineName = InputHandler.input();
		if (FormChecking.checkLineNameLength(inputLineName)) {
			ErrorView.printLineLengthError();
			return;
		}
		if (lineRepository.findExistLineName(inputLineName)) {
			ErrorView.printAlreadyLineName();
			return;
		}
		Line line = new Line(inputLineName);
		lineRepository.addLine(line);
		setAscendStationAndDescendStation(line);
	}

	private static void setAscendStationAndDescendStation(Line line) {
		InputView.printInputAddLineAscend();
		String ascendName = InputHandler.input();
		InputView.printInputAddLineDescend();
		String descendName = InputHandler.input();
		Station ascend = StationRepository.findStation(ascendName);
		Station descend = StationRepository.findStation(descendName);
		if (!FormChecking.nullCheckAscendAndDescend(ascend, descend)) {
			return;
		}
		lineRepository.addStationInLine(ascend, descend, line.getName());
		SuccessView.printSuccessAddLine();
	}

	public static void lookupLines() {
		MainView.printLines(lineRepository.lines());
	}

	public static void deleteLineByName() {
		RemoveView.printDeleteLine();
		String inputLineName = InputHandler.input();
		if (!lineRepository.deleteLineByName(inputLineName)) {
			ErrorView.printNotExistLine();
			return;
		}
		SuccessView.printSuccessDeleteLine();
	}

	public static void selectLineManagement() {
		MainView.printLineMenu();
		MainView.printSelect();
		LineMenu selectMenu = LineMenu.findLineMenu(InputHandler.input());
		if (selectMenu == null) {
			ErrorView.printNotSelectMenu();
			selectLineManagement();
			return;
		}
		selectMenu.selectMenu();
	}

}