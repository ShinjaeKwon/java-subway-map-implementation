package subway.handler.view;

public class ErrorView {

	public static final String ERROR_LINE_LENGTH = "[ERROR] 노선 이름은 두글자 이상이여야 합니다.\n";
	public static final String ERROR_STATION_LENGTH = "[ERROR] 역 이름은 두글자 이상이여야 합니다.\n";
	public static final String ERROR_ALREADY_STATION_NAME = "[ERROR] 이미 등록된 역 이름입니다.\n";
	public static final String ERROR_ALREADY_LINE_NAME = "[ERROR] 이미 등록된 노선 이름입니다.\n";
	public static final String ERROR_NOT_SELECT_MENU = "[ERROR] 선택할 수 없는 기능입니다.\n";
	public static final String ERROR_NOT_EXIST_LINE = "[ERROR] 존재하지 않는 노선입니다.\n";
	public static final String ERROR_NOT_EXIST_STATION = "[ERROR] 존재하지 않는 역입니다.\n";
	public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.\n";
	public static final String ERROR_NOT_ADD_SECTION = "[ERROR] 종점 전,후의 위치에는 역을 추가할 수 없습니다.\n";
	public static final String ERROR_FAILED_DELETE_STATION_IN_LINE = "[ERROR] 노선에 포함된 역이 두개 이하입니다.\n";
	public static final String ERROR_FORKED_LOAD = "[ERROR] 노선이 갈래길이 됩니다.\n";
	public static final String ERROR_STATION_END_CHAR_NOT_STATION = "[ERROR] 입력된 역의 이름은 역으로 끝나야 합니다.\n";
	public static final String ERROR_STATION_END_CHAR_NOT_LINE = "[ERROR] 입력된 노선의 이름은 선으로 끝나야 합니다.\n";

	public static void printDeleteStationInLineError() {
		System.out.println(ErrorView.ERROR_FAILED_DELETE_STATION_IN_LINE);
	}

	public static void printAddSectionError() {
		System.out.println(ErrorView.ERROR_NOT_ADD_SECTION);
	}

	public static void printInputNumber() {
		System.out.println(ErrorView.ERROR_NOT_NUMBER);
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