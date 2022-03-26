package subway.handler.view;

public class RemoveView {

	public static final String DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
	public static final String DELETE_SECTION_IN_LINE = "## 삭제할 구간의 노선을 입력하세요.";
	public static final String DELETE_STATION_IN_LINE = "## 삭제할 구간의 역을 입력하세요.";
	public static final String DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";

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

}