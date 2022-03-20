package subway.domain.menu;

import subway.management.LineManagement;

public enum LineMenu {
	ONE("1") {
		public void selectMenu() {
			LineManagement.addLine();
		}
	}, TWO("2") {
		public void selectMenu() {
			LineManagement.deleteLineByName();
		}
	}, THREE("3") {
		public void selectMenu() {
			LineManagement.lookupLines();
		}
	}, BACK("B") {
		public void selectMenu() {
			return;
		}
	};

	private final String value;

	public abstract void selectMenu();

	LineMenu(String value) {
		this.value = value;
	}

	public static LineMenu findLineMenu(String input) {
		LineMenu[] menus = LineMenu.values();
		for (LineMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

}