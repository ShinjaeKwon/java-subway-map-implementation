package subway.management;

import java.util.List;

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
		if (isExistLine(inputLineName))
			return null;
		return inputLineName;
	}

	private static boolean isExistLine(String inputLineName) {
		if (!FormChecking.checkExistLine(inputLineName)) {
			PrintHandler.printNotExistLine();
			return true;
		}
		return false;
	}

	public static String deleteSectionCheckLine() {
		PrintHandler.printDeleteLineInSection();
		String inputLineName = InputHandler.input();
		if (isExistLine(inputLineName)) {
			return null;
		}
		return inputLineName;
	}

	private static String deleteSectionCheckStation() {
		PrintHandler.printDeleteStationInLine();
		String inputStationName = InputHandler.input();
		if (!FormChecking.checkExistStation(inputStationName)) {
			PrintHandler.printNotExistStation();
			return null;
		}
		return inputStationName;
	}

	public static void deleteStationByNameInSection() {
		String inputLineName = deleteSectionCheckLine();
		String inputStationName = addSectionSetStation();

		if (FormChecking.checkSectionInLineLength(inputLineName)) {
			PrintHandler.printDeleteStationInLineError();
		}
		Line deleteLine = LineRepository.findLine(inputLineName);
		Station deleteStation = StationRepository.findStation(inputStationName);
		LineRepository.deleteStationInLine(deleteLine, deleteStation);
		PrintHandler.printSuccessDeleteStationInLine();
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

	public static void printSubwayRouteMap() {
		List<Line> lines = LineRepository.getLines();
		PrintHandler.printSubwayRootMap();
		for (Line line : lines) {
			PrintHandler.printSubwayRootMapToLine(line);
			PrintHandler.printDividingLine();
			List<Station> stationList = line.getStationList();
			for (Station station : stationList) {
				PrintHandler.printSubWayRootMapToStation(station);
			}
			System.out.println();
		}
	}

}