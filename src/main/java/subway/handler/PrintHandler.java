package subway.handler;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

public class PrintHandler {

	private static final String MENU = "## 메인 화면\n"
		+ "1. 역 관리\n"
		+ "2. 노선 관리\n"
		+ "3. 구간 관리\n"
		+ "4. 지하철 노선도 출력\n"
		+ "Q. 종료\n";
	private static final String STATIONS_PRINT_START = "## 역 목록";
	private static final String LINES_PRINT_START = "## 노선 목록";
	private static final String SELECT = "## 원하는 기능을 선택하세요.";
	private static final String PREFIX = "[INFO] ";

	public static void printMenu() {
		System.out.println(MENU);
	}

	public static void printSelect() {
		System.out.println(SELECT);
	}

	public static void printStations(List<Station> stations) {
		System.out.println(STATIONS_PRINT_START);
		stations.forEach(station -> System.out.println(PREFIX + station));
	}

	public static void printLines(List<Line> lines) {
		System.out.println(LINES_PRINT_START);
		lines.forEach(line -> System.out.println(PREFIX + line));
	}
}
