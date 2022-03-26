package subway.handler.view;

public class InputView {

	public static final String INPUT_ADD_STATION = "## 등록할 역 이름을 입력하세요.";
	public static final String INPUT_ADD_LINE_DESCEND = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
	public static final String INPUT_ADD_LINE_ASCEND = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
	public static final String INPUT_LINE = "## 노선을 입력하세요.";
	public static final String INPUT_STATION = "## 역이름을 입력하세요.";
	public static final String INPUT_STATION_ORDER = "## 순서를 입력하세요.";
	public static final String INPUT_ADD_LINE = "## 등록할 노선 이름을 입력하세요";

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

}