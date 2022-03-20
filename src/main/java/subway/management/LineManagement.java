package subway.management;

import subway.domain.Line;
import subway.domain.menu.LineMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineManagement {

	private static LineRepository lineRepository = new LineRepository();

	public static void addLine() {
		PrintHandler.printInputAddLine();
		String inputLineName = InputHandler.input();
		Line line = new Line(inputLineName);
		lineRepository.addLine(line);
		PrintHandler.printInputAddLineAscend();
		String ascend = InputHandler.input();
		PrintHandler.printInputAddLineDescend();
		String descend = InputHandler.input();
		lineRepository.addStationListInLine(StationRepository.makeLineList(ascend, descend), line);
		PrintHandler.printSuccessAddLine();
	}

	public static void lookupLines() {
		PrintHandler.printLines(lineRepository.lines());
	}

	public static void deleteLineByName() {
		PrintHandler.printDeleteLine();
		String inputLineName = InputHandler.input();
		if (!lineRepository.deleteLineByName(inputLineName)) {
			//exception
			return;
		}
		PrintHandler.printSuccessDeleteLine();
	}

	public static void selectLineManagement() {
		PrintHandler.printLineMenu();
		PrintHandler.printSelect();
		LineMenu selectMenu = LineMenu.findLineMenu(InputHandler.input());
		if (selectMenu == null) {
			//TODO exception 발생
		}
		selectMenu.selectMenu();
	}

}
