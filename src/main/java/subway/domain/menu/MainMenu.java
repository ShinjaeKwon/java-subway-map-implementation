package subway.domain.menu;

import subway.handler.view.MainView;
import subway.management.LineManagement;
import subway.management.SectionManagement;
import subway.management.StationManagement;

public enum MainMenu {

	STATION_MANAGEMENT_MENU("1") {
		public int selectMenu() {
			StationManagement.selectStationManagement();
			return Code.NORMAL_CODE;
		}
	}, LINE_MANAGEMENT_MENU("2") {
		public int selectMenu() {
			LineManagement.selectLineManagement();
			return Code.NORMAL_CODE;
		}
	}, SECTION_MANAGEMENT_MENU("3") {
		public int selectMenu() {
			SectionManagement.selectSectionManagement();
			return Code.NORMAL_CODE;
		}
	}, PRINT_SUBWAY_ROOT_MAP("4") {
		public int selectMenu() {
			MainView.printSubwayRouteMap();
			return Code.NORMAL_CODE;
		}
	}, QUIT("Q") {
		public int selectMenu() {
			return Code.EXIT_CODE;
		}

	};

	MainMenu(String value) {
		this.value = value;
	}

	private final String value;

	public abstract int selectMenu();

	public static MainMenu findMenu(String input) {
		MainMenu[] menus = MainMenu.values();
		for (MainMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

	class Code {
		public static final int EXIT_CODE = -1;
		public static final int NORMAL_CODE = 0;
	}

}