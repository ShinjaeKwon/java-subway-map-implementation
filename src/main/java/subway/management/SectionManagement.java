package subway.management;

import java.util.List;

import subway.check.FormChecking;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.menu.SectionMenu;
import subway.handler.InputHandler;
import subway.handler.view.ErrorView;
import subway.handler.view.InputView;
import subway.handler.view.MainView;
import subway.handler.view.RemoveView;
import subway.handler.view.SuccessView;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionManagement {

	public static final int ERROR_ORDER_LENGTH = 1;
	public static final int FIRST_IDX = 0;

	public static void addSection() {
		String inputLineName = addSectionSetLine();
		String inputStationName = addSectionSetStation();
		Integer order = addSectionSetOrder();
		Line line = LineRepository.findLine(inputLineName);
		Station station = StationRepository.findStation(inputStationName);
		if (FormChecking.checkNull(inputLineName, inputStationName, order) || checkLastStation(order, line)
			|| !checkForkedLoad(station)) {
			return;
		}
		line.addStationOrder(station, order);
		SuccessView.printSuccessAddSection();
	}

	private static boolean checkLastStation(Integer order, Line line) {
		if (order >= line.getStationList().size() || order < ERROR_ORDER_LENGTH) {
			ErrorView.printAddSectionError();
			return true;
		}
		return false;
	}

	private static boolean checkForkedLoad(Station inputStation) {
		List<Line> lines = LineRepository.getLines();
		for (Line line : lines) {
			List<Station> stationList = line.getStationList();
			if (stationList.get(FIRST_IDX).equals(inputStation) || stationList.get(getLastIdx(stationList))
				.equals(inputStation)) {
				return true;
			}
		}
		ErrorView.printForkedLoadError();
		return false;
	}

	private static int getLastIdx(List<Station> stationList) {
		return stationList.size() - 1;
	}

	private static Integer addSectionSetOrder() {
		InputView.printInputStationOrder();
		String inputStationOrder = InputHandler.input();
		if (!FormChecking.checkNumber(inputStationOrder)) {
			ErrorView.printInputNumber();
			return null;
		}
		return Integer.parseInt(inputStationOrder);
	}

	private static String addSectionSetStation() {
		InputView.printInputStation();
		String inputStationName = InputHandler.input();
		if (!FormChecking.checkExistStation(inputStationName)) {
			ErrorView.printNotExistStation();
			return null;
		}
		return inputStationName;
	}

	private static String addSectionSetLine() {
		InputView.printInputLine();
		String inputLineName = InputHandler.input();
		if (isExistLine(inputLineName))
			return null;
		return inputLineName;
	}

	private static boolean isExistLine(String inputLineName) {
		if (!FormChecking.checkExistLine(inputLineName)) {
			ErrorView.printNotExistLine();
			return true;
		}
		return false;
	}

	public static String deleteSectionCheckLine() {
		RemoveView.printDeleteLineInSection();
		String inputLineName = InputHandler.input();
		if (isExistLine(inputLineName)) {
			return null;
		}
		return inputLineName;
	}

	private static String deleteSectionCheckStation() {
		RemoveView.printDeleteStationInLine();
		String inputStationName = InputHandler.input();
		if (!FormChecking.checkExistStation(inputStationName)) {
			ErrorView.printNotExistStation();
			return null;
		}
		return inputStationName;
	}

	public static void deleteStationByNameInSection() {
		String inputLineName = deleteSectionCheckLine();
		String inputStationName = deleteSectionCheckStation();

		if (FormChecking.checkSectionInLineLength(inputLineName)) {
			ErrorView.printDeleteStationInLineError();
		}
		Line deleteLine = LineRepository.findLine(inputLineName);
		Station deleteStation = StationRepository.findStation(inputStationName);
		LineRepository.deleteStationInLine(deleteLine, deleteStation);
		SuccessView.printSuccessDeleteStationInLine();
	}

	public static void selectSectionManagement() {
		MainView.printSectionMenu();
		MainView.printSelect();
		SectionMenu selectMenu = SectionMenu.findSectionMenu(InputHandler.input());
		if (selectMenu == null) {
			ErrorView.printNotSelectMenu();
			selectSectionManagement();
			return;
		}
		selectMenu.selectMenu();
	}

}