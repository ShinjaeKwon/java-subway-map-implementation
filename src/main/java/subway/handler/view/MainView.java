package subway.handler.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;

public class MainView {

	public static final String MAIN_MENU = "## 메인 화면\n"
		+ "1. 역 관리\n"
		+ "2. 노선 관리\n"
		+ "3. 구간 관리\n"
		+ "4. 지하철 노선도 출력\n"
		+ "Q. 종료\n";
	public static final String STATION_MENU = "## 역 관리 화면\n"
		+ "1. 역 등록\n"
		+ "2. 역 삭제\n"
		+ "3. 역 조회\n"
		+ "B. 돌아가기\n";
	public static final String LINE_MENU = "## 노선 관리 화면\n"
		+ "1. 노선 등록\n"
		+ "2. 노선 삭제\n"
		+ "3. 노선 조회\n"
		+ "B. 돌아가기\n";
	public static final String SECTION_MENU = "## 구간 관리 화면\n"
		+ "1. 구간 등록\n"
		+ "2. 구간 삭제\n"
		+ "B. 돌아가기\n";
	public static final String SELECT_MENU = "## 원하는 기능을 선택하세요.";
	public static final String PREFIX_INFO = "[INFO] ";
	private static final String DIVIDING_LINE = "---";
	private static final String STATIONS_PRINT_START = "## 역 목록";
	private static final String LINES_PRINT_START = "## 노선 목록";
	private static final String SUBWAY_ROOT_MAP_PRINT_START = "## 지하철 노선도";

	public static void printMenu() {
		System.out.println(MAIN_MENU);
	}

	public static void printStationMenu() {
		System.out.println(STATION_MENU);
	}

	public static void printLineMenu() {
		System.out.println(LINE_MENU);
	}

	public static void printSectionMenu() {
		System.out.println(SECTION_MENU);
	}

	public static void printSelect() {
		System.out.println(SELECT_MENU);
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

	public static void printSubwayRouteMap() {
		List<Line> lines = LineRepository.lines();
		MainView.printSubwayRootMap();
		for (Line line : lines) {
			MainView.printSubwayRootMapToLine(line);
			MainView.printDividingLine();
			List<Station> stationList = line.getStationList();
			for (Station station : stationList) {
				MainView.printSubWayRootMapToStation(station);
			}
			System.out.println();
		}
	}

}