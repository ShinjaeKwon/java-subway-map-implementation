package subway.handler;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

public class PrintHandler {

	private static final String MAIN_MENU = "## 메인 화면\n"
		+ "1. 역 관리\n"
		+ "2. 노선 관리\n"
		+ "3. 구간 관리\n"
		+ "4. 지하철 노선도 출력\n"
		+ "Q. 종료\n";
	private static final String STATION_MENU = "## 역 관리 화면\n"
		+ "1. 역 등록\n"
		+ "2. 역 삭제\n"
		+ "3. 역 조회\n"
		+ "B. 돌아가기\n";
	private static final String LINE_MENU = "## 노선 관리 화면\n"
		+ "1. 노선 등록\n"
		+ "2. 노선 삭제\n"
		+ "3. 노선 조회\n"
		+ "B. 돌아가기\n";
	private static final String STATIONS_PRINT_START = "## 역 목록";
	private static final String SELECT_MENU = "## 원하는 기능을 선택하세요.";
	private static final String INPUT_ADD_STATION = "## 등록할 역 이름을 입력하세요.";
	private static final String DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
	private static final String SUCCESS_DELETE_STATION = "지하철 역이 삭제되었습니다.\n";
	private static final String SUCCESS_ADD_STATION = "지하철 역이 등록되었습니다.\n";
	private static final String INPUT_ADD_LINE = "## 등록할 노선 이름을 입력하세요";
	private static final String LINES_PRINT_START = "## 노선 목록";
	private static final String DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
	private static final String SUCCESS_DELETE_LINE = "지하철 노선이 삭제되었습니다.\n";
	private static final String SUCCESS_ADD_LINE = "지하철 노선이 등록되었습니다.\n";
	private static final String INPUT_ADD_LINE_DESCEND = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
	private static final String INPUT_ADD_LINE_ASCEND = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
	private static final String PREFIX_INFO = "[INFO] ";

	public static void printMenu() {
		System.out.println(MAIN_MENU);
	}

	public static void printStationMenu() {
		System.out.println(STATION_MENU);
	}

	public static void printLineMenu() {
		System.out.println(LINE_MENU);
	}

	public static void printInputAddLine() {
		System.out.println(INPUT_ADD_LINE);
	}

	public static void printInputAddLineAscend() {
		System.out.println(INPUT_ADD_LINE_ASCEND);
	}

	public static void printInputAddLineDescend() {
		System.out.println(INPUT_ADD_LINE_DESCEND);
	}

	public static void printDeleteLine() {
		System.out.println(DELETE_LINE);
	}

	public static void printSuccessDeleteLine() {
		System.out.println(SUCCESS_DELETE_LINE);
	}

	public static void printSuccessAddLine() {
		System.out.println(SUCCESS_ADD_LINE);
	}

	public static void printSuccessAddStation() {
		System.out.println(PREFIX_INFO + SUCCESS_ADD_STATION);
	}

	public static void printSuccessDeleteStation() {
		System.out.println(PREFIX_INFO + SUCCESS_DELETE_STATION);
	}

	public static void printInputAddStation() {
		System.out.println(INPUT_ADD_STATION);
	}

	public static void printDeleteStation() {
		System.out.println(DELETE_STATION);
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
}
