package subway.domain.menu;

import subway.management.StationManagement;

public enum StationMenu {
	ONE("1") {
		public void selectMenu() {
			StationManagement.addStation();
		}
	}, TWO("2") {
		public void selectMenu() {
			StationManagement.deleteStation();
		}
	}, THREE("3") {
		public void selectMenu() {
			StationManagement.lookupStation();
		}
	}, BACK("B") {
		public void selectMenu() {
			return;
		}
	};

	StationMenu(String value) {
		this.value = value;
	}

	private final String value;

	public abstract void selectMenu();

	public static StationMenu findStationMenu(String input) {
		StationMenu[] menus = StationMenu.values();
		for (StationMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

}
