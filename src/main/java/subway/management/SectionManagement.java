package subway.management;

import subway.check.FormChecking;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.menu.SectionMenu;
import subway.handler.InputHandler;
import subway.handler.PrintHandler;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionManagement {

	public static void addSection() {
		String inputLineName = addSectionSetLine();
		String inputStationName = addSectionSetStation();
		Integer order = addSectionSetOrder();
		if (FormChecking.checkNull(inputLineName, inputStationName, order)) {
			return;
		}

		Line line = LineRepository.findLine(inputLineName);
		Station station = StationRepository.findStation(inputStationName);
		if (order >= line.getStationList().size() || order < 1) {
			PrintHandler.printAddSectionError();
			return;
		}
		// 갈래길 체크
		line.addStationOrder(station, order);
		PrintHandler.printSuccessAddSection();
	}

	private static Integer addSectionSetOrder() {
		PrintHandler.printInputStationOrder();
		String inputStationOrder = InputHandler.input();
		if (!FormChecking.checkNumber(inputStationOrder)) {
			PrintHandler.printInputNumber();
			return null;
		}
		return Integer.parseInt(inputStationOrder);
	}

	private static String addSectionSetStation() {
		PrintHandler.printInputStation();
		String inputStationName = InputHandler.input();
		if (!FormChecking.checkExistStation(inputStationName)) {
			PrintHandler.printNotExistStation();
			return null;
		}
		return inputStationName;
	}

	private static String addSectionSetLine() {
		PrintHandler.printInputLine();
		String inputLineName = InputHandler.input();
		if (!FormChecking.checkExistLine(inputLineName)) {
			PrintHandler.printNotExistLine();
			return null;
		}
		return inputLineName;
	}

	public static void deleteStationByNameInSection() {

	}

	public static void selectSectionManagement() {
		PrintHandler.printSectionMenu();
		PrintHandler.printSelect();
		SectionMenu selectMenu = SectionMenu.findSectionMenu(InputHandler.input());
		if (selectMenu == null) {
			PrintHandler.printNotSelectMenu();
			selectSectionManagement();
			return;
		}
		selectMenu.selectMenu();
	}
}