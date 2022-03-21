package subway.domain.menu;

import subway.management.LineManagement;
import subway.management.SectionManagement;
import subway.management.StationManagement;

public enum MainMenu {
	ONE("1") {
		public void selectMenu() {
			StationManagement.selectStationManagement();
		}
	}, TWO("2") {
		public void selectMenu() {
			LineManagement.selectLineManagement();
		}
	}, THREE("3") {
		public void selectMenu() {
			SectionManagement.selectSectionManagement();
		}
	}, FORE("4") {
		public void selectMenu() {
			SectionManagement.printSubwayRouteMap();
		}
	}, QUIT("Q") {
		public void selectMenu() {
			System.exit(0);
		}
	};

	MainMenu(String value) {
		this.value = value;
	}

	private final String value;

	public abstract void selectMenu();

	public static MainMenu findMenu(String input) {
		MainMenu[] menus = MainMenu.values();
		for (MainMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

}