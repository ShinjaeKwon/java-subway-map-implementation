package subway.handler.view;

public class SuccessView {

	public static final String SUCCESS_DELETE_STATION = "지하철 역이 삭제되었습니다.\n";
	public static final String SUCCESS_ADD_STATION = "지하철 역이 등록되었습니다.\n";
	public static final String SUCCESS_ADD_SECTION = "구간이 등록되었습니다.\n";
	public static final String SUCCESS_DELETE_STATION_IN_LINE = "구간이 삭제되었습니다.\n";
	public static final String SUCCESS_DELETE_LINE = "지하철 노선이 삭제되었습니다.\n";
	public static final String SUCCESS_ADD_LINE = "지하철 노선이 등록되었습니다.\n";

	public static void printSuccessDeleteLine() {
		System.out.println(SuccessView.SUCCESS_DELETE_LINE);
	}

	public static void printSuccessAddLine() {
		System.out.println(SuccessView.SUCCESS_ADD_LINE);
	}

	public static void printSuccessAddStation() {
		System.out.println(MainView.PREFIX_INFO + SuccessView.SUCCESS_ADD_STATION);
	}

	public static void printSuccessDeleteStation() {
		System.out.println(MainView.PREFIX_INFO + SuccessView.SUCCESS_DELETE_STATION);

	}

	public static void printSuccessAddSection() {
		System.out.println(MainView.PREFIX_INFO + SuccessView.SUCCESS_ADD_SECTION);
	}

	public static void printSuccessDeleteStationInLine() {
		System.out.println(MainView.PREFIX_INFO + SuccessView.SUCCESS_DELETE_STATION_IN_LINE);
	}

}