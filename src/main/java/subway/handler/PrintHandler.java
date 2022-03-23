package subway.handler;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;
import subway.handler.view.ErrorView;
import subway.handler.view.InputView;
import subway.handler.view.MenuView;
import subway.handler.view.RemoveView;
import subway.handler.view.SuccessView;

public class PrintHandler {

	private static final String PREFIX_INFO = "[INFO] ";

	private static final String DIVIDING_LINE = "---";
	private static final String STATIONS_PRINT_START = "## 역 목록";
	private static final String LINES_PRINT_START = "## 노선 목록";
	private static final String SUBWAY_ROOT_MAP_PRINT_START = "## 지하철 노선도";

	public static void printMenu() {
		System.out.println(MenuView.MAIN_MENU);
	}

	public static void printStationMenu() {
		System.out.println(MenuView.STATION_MENU);
	}

	public static void printLineMenu() {
		System.out.println(MenuView.LINE_MENU);
	}

	public static void printSectionMenu() {
		System.out.println(MenuView.SECTION_MENU);
	}

	public static void printSelect() {
		System.out.println(MenuView.SELECT_MENU);
	}

	public static void printSuccessDeleteLine() {
		System.out.println(SuccessView.SUCCESS_DELETE_LINE);
	}

	public static void printSuccessAddLine() {
		System.out.println(SuccessView.SUCCESS_ADD_LINE);
	}

	public static void printSuccessAddStation() {
		System.out.println(PREFIX_INFO + SuccessView.SUCCESS_ADD_STATION);
	}

	public static void printSuccessDeleteStation() {
		System.out.println(PREFIX_INFO + SuccessView.SUCCESS_DELETE_STATION);

	}

	public static void printSuccessAddSection() {
		System.out.println(PREFIX_INFO + SuccessView.SUCCESS_ADD_SECTION);
	}

	public static void printSuccessDeleteStationInLine() {
		System.out.println(PREFIX_INFO + SuccessView.SUCCESS_DELETE_STATION_IN_LINE);
	}

	public static void printInputAddStation() {
		System.out.println(InputView.INPUT_ADD_STATION);
	}

	public static void printInputAddLine() {
		System.out.println(InputView.INPUT_ADD_LINE);
	}

	public static void printInputAddLineAscend() {
		System.out.println(InputView.INPUT_ADD_LINE_ASCEND);
	}

	public static void printInputAddLineDescend() {
		System.out.println(InputView.INPUT_ADD_LINE_DESCEND);
	}

	public static void printInputLine() {
		System.out.println(InputView.INPUT_LINE);
	}

	public static void printInputStation() {
		System.out.println(InputView.INPUT_STATION);
	}

	public static void printInputStationOrder() {
		System.out.println(InputView.INPUT_STATION_ORDER);
	}

	public static void printDeleteStation() {
		System.out.println(RemoveView.DELETE_STATION);
	}

	public static void printDeleteLine() {
		System.out.println(RemoveView.DELETE_LINE);
	}

	public static void printDeleteLineInSection() {
		System.out.println(RemoveView.DELETE_SECTION_IN_LINE);
	}

	public static void printDeleteStationInLine() {
		System.out.println(RemoveView.DELETE_STATION_IN_LINE);
	}

	public static void printStations(List<Station> stations) {
		System.out.println(STATIONS_PRINT_START);
		stations.forEach(station -> System.out.println(PREFIX_INFO + station.getName()));
		System.out.println();
	}

	public static void printLines(List<Line> lines) {
		System.out.println(LINES_PRINT_START);
		lines.forEach(line -> System.out.println(PREFIX_INFO + line.getName()));
		System.out.println();
	}

	public static void printSubwayRootMap() {
		System.out.println(SUBWAY_ROOT_MAP_PRINT_START);
	}

	public static void printSubwayRootMapToLine(Line line) {
		System.out.println(PREFIX_INFO + line.getName());
	}

	public static void printDividingLine() {
		System.out.println(PREFIX_INFO + DIVIDING_LINE);
	}

	public static void printSubWayRootMapToStation(Station station) {
		System.out.println(PREFIX_INFO + station.getName());
	}

	public static void printDeleteStationInLineError() {
		System.out.println(ErrorView.ERROR_FAILED_DELETE_STATION_IN_LINE);
	}

	public static void printAddSectionError() {
		System.out.println(ErrorView.ERROR_NOT_ADD_SECTION);
	}

	public static void printInputNumber() {
		System.out.println(ErrorView.ERROR_NOT_NUMBER);
	}

	public static void printLineLengthError() {
		System.out.println(ErrorView.ERROR_LINE_LENGTH);
	}

	public static void printStationLengthError() {
		System.out.println(ErrorView.ERROR_STATION_LENGTH);
	}

	public static void printAlreadyStationName() {
		System.out.println(ErrorView.ERROR_ALREADY_STATION_NAME);
	}

	public static void printAlreadyLineName() {
		System.out.println(ErrorView.ERROR_ALREADY_LINE_NAME);
	}

	public static void printNotSelectMenu() {
		System.out.println(ErrorView.ERROR_NOT_SELECT_MENU);
	}

	public static void printNotExistLine() {
		System.out.println(ErrorView.ERROR_NOT_EXIST_LINE);
	}

	public static void printNotExistStation() {
		System.out.println(ErrorView.ERROR_NOT_EXIST_STATION);
	}

	public static void printForkedLoadError() {
		System.out.println(ErrorView.ERROR_FORKED_LOAD);
	}
}